package com.example.upc.redis;

import com.example.upc.common.BusinessException;
import com.example.upc.common.EmBusinessError;
import com.example.upc.controller.param.UserParam;
import com.example.upc.dao.SysUserErrorMapper;
import com.example.upc.dao.SysUserMapper;
import com.example.upc.dataobject.SysUser;
import com.example.upc.dataobject.SysUserError;
import com.example.upc.util.MD5Util;
import com.example.upc.util.UUIDUtil;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc
 * @date 2019/5/25 21:02
 */
@Service
public class UserSessionService {
    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    RedisService redisService;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserErrorMapper sysUserErrorMapper;

    public SysUser getByToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)) {
            throw new BusinessException(EmBusinessError.PLEASE_LOGIN);
        }
        SysUser sysUser =(SysUser)redisService.getUser(SessionUserKey.token, token);
        //延长有效期
        if(sysUser != null) {
            addCookie(response, token, sysUser);
        }else {
            throw new BusinessException(EmBusinessError.PLEASE_LOGIN);
        }
        return sysUser;
    }

    public boolean logout(HttpServletRequest request,HttpServletResponse response){
        String paramToken = request.getParameter(UserSessionService.COOKIE_NAME_TOKEN);
        String cookieToken = getCookieValue(request, UserSessionService.COOKIE_NAME_TOKEN);
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return true;
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        redisService.delUser(SessionUserKey.token, token);
        return true;
    }

    public boolean login(HttpServletResponse response, UserParam userParam) throws BusinessException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();//new一个Calendar类,把Date放进去
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);

        if(userParam == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数错误");
        }
        String loginName = userParam.getLoginName();
        String formPass = userParam.getPassword();
        //判断账号是否存在
        SysUser sysUser = sysUserMapper.selectByLoginName(loginName);
        if(sysUser == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"帐号不存在");
        }
        //验证密码
        String dbPass = sysUser.getPassword();
        MD5Util md5Code =new MD5Util();
        SysUserError sysUserError = sysUserErrorMapper.selectByUserId(sysUser.getId(),formatter.format(date),formatter.format(calendar.getTime()));
        if(!md5Code.md5(formPass).equals(dbPass)) {
            //如果错误log为空，创建新记录，
            if (sysUserError==null){
                SysUserError sysUserError1 = new SysUserError();
                sysUserError1.setUserId(sysUser.getId());
                sysUserError1.setError(1);
                sysUserErrorMapper.insertSelective(sysUserError1);
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"密码错误，可再尝试4次！");
            }
            //如果有记录，那么将记录中的
            else {
                if (sysUserError.getError()==5){
                    throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"您今日已经尝试登录5次，请明日再试！");
                }
                else {
                    int a = sysUserError.getError()+1;
                    sysUserError.setError(a);
                    sysUserErrorMapper.updateByPrimaryKeySelective(sysUserError);
                    throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"密码错误，可再尝试"+(5-a)+"次！");
                }
            }
        }
        if (sysUserError!=null&&sysUserError.getError()==5){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"您今日已经尝试登录5次，请明日再试！");
        }
        //生成cookie
        String token	 = sysUser.getId().toString()+'_'+UUIDUtil.uuid();
        addCookie(response, token, sysUser);
        return true;
    }

    private void addCookie(HttpServletResponse response, String token, SysUser sysUser) {
        redisService.setUser(SessionUserKey.token, token, sysUser);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(SessionUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[]  cookies = request.getCookies();
        if(cookies==null){
            return null;
        }
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    // 小程序登录
    public Map<String, Object> miniUserLogin(HttpServletResponse response, UserParam userParam) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();//new一个Calendar类,把Date放进去
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);

        if(userParam == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数错误");
        }
        String loginName = userParam.getLoginName();
        String formPass = userParam.getPassword();
        //判断账号是否存在
        SysUser sysUser = sysUserMapper.selectByLoginName(loginName);
        if(sysUser == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"帐号不存在");
        }
        SysUserError sysUserError = sysUserErrorMapper.selectByUserId(sysUser.getId(),formatter.format(date),formatter.format(calendar.getTime()));
        if (sysUserError==null){
            SysUserError sysUserError1 = new SysUserError();
            sysUserError1.setUserId(sysUser.getId());
            sysUserError1.setError(0);
            sysUserErrorMapper.insertSelective(sysUserError1);
        }
        SysUserError sysUserError2 = sysUserErrorMapper.selectByUserId(sysUser.getId(),formatter.format(date),formatter.format(calendar.getTime()));
        if (sysUserError2.getError()==5){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"您今日已经尝试登录5次，请明日再试！");
        }
        //验证密码
        String dbPass = sysUser.getPassword();
        MD5Util md5Code =new MD5Util();
        if(!md5Code.md5(formPass).equals(dbPass)) {
            int a = sysUserError2.getError()+1;
            sysUserError2.setError(a);
            sysUserErrorMapper.updateByPrimaryKeySelective(sysUserError2);
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"密码错误，可再尝试"+(5-a)+"次！");
        }
        //生成cookie
        String token	 = sysUser.getId().toString()+'_'+UUIDUtil.uuid();
        addCookie(response, token, sysUser);
        // 数据返回格式修改
        Map<String,Object> result = new HashMap<>();
        result.put("userId",sysUser.getId());   //用户id
        result.put("enterpriseId",sysUser.getInfoId()); // 企业id
        return result;
    }

    public int getEnterpriseIdByInfoId(SysUser sysUser){
        int infoId = sysUser.getInfoId();
        return sysUserMapper.getEnterpriseIdByInfoId(infoId);
    }
}
