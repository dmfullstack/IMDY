package com.example.upc.service.impl;

import com.example.upc.common.BusinessException;
import com.example.upc.common.EmBusinessError;
import com.example.upc.common.ValidationResult;
import com.example.upc.common.ValidatorImpl;
import com.example.upc.controller.param.*;
import com.example.upc.controller.searchParam.CaSearchParam;
import com.example.upc.controller.searchParam.EnterpriseSearchParam;
import com.example.upc.controller.searchParam.MeasurementSearchParam;
import com.example.upc.dao.*;
import com.example.upc.dataobject.*;
import com.example.upc.service.SupervisionCaService;
import com.example.upc.util.ExcalUtils;
import com.example.upc.util.MD5Util;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SupervisionCaServiceImpl implements SupervisionCaService {
    @Autowired
    SupervisionCaMapper supervisionCaMapper;
    @Autowired
    private ValidatorImpl validator;
    @Autowired
    private SupervisionEnterpriseMapper supervisionEnterpriseMapper;
    @Autowired
    private SysIndustryMapper sysIndustryMapper;
    @Autowired
    private SysWorkTypeMapper sysWorkTypeMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public PageResult getPage(PageQuery pageQuery, CaSearchParam caSearchParam) {
        int count= supervisionCaMapper.countList(caSearchParam);
        if (count > 0) {
            List<SupervisionCa> supervisionCaList = supervisionCaMapper.getPage(pageQuery,caSearchParam);
            PageResult<SupervisionCa> pageResult = new PageResult<>();
            pageResult.setData(supervisionCaList);
            pageResult.setTotal(count);
            pageResult.setPageNo(pageQuery.getPageNo());
            pageResult.setPageSize(pageQuery.getPageSize());
            return pageResult;
        }
        PageResult<SupervisionCa> pageResult = new PageResult<>();
        return pageResult;
    }

    @Override
    @Transactional
    public void insert(CaParam caParam) {
        ValidationResult result = validator.validate(caParam);
        if(result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }
        if(supervisionCaMapper.countByIdNumber(caParam.getIdNumber(),caParam.getId())>0){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"已有该人员");
        }

        SupervisionCa supervisionCa = new SupervisionCa();
        BeanUtils.copyProperties(caParam,supervisionCa);

        supervisionCa.setOperateTime(new Date());
        supervisionCa.setOperateIp("124.214.124");
        supervisionCa.setOperator("zcc");
        supervisionCaMapper.insertSelective(supervisionCa);

        SysUser sysUser = new SysUser();
        String encryptedPassword = MD5Util.md5("123456+");
        sysUser.setUsername(supervisionCa.getName());
        sysUser.setLoginName(supervisionCa.getIdNumber());
        sysUser.setPassword(encryptedPassword);
        sysUser.setUserType(3);
        sysUser.setInfoName(supervisionCa.getName());
        sysUser.setInfoId(supervisionCa.getId());
        sysUser.setStatus(0);
        sysUser.setOperator("操作人");
        sysUser.setOperateIp("124.124.124");
        sysUser.setOperateTime(new Date());
        sysUserMapper.insertSelective(sysUser);

        SysRoleUser sysRoleUser =new SysRoleUser();
        sysRoleUser.setUserId(sysUser.getId());
        sysRoleUser.setRoleId(28);
        sysRoleUser.setOperateTime(new Date());
        sysRoleUser.setOperator("操作人");
        sysRoleUser.setOperateIp("123.124.124");
        sysRoleUserMapper.insertSelective(sysRoleUser);
    }

    @Override
    public void delete(int caId) {
        SupervisionCa supervisionCa = supervisionCaMapper.selectByPrimaryKey(caId);
        if(supervisionCa ==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"不存在，无法删除");
        }
        supervisionCaMapper.deleteByPrimaryKey(caId);
    }

    @Override
    @Transactional
    public void update(CaParam caParam) {
        ValidationResult result = validator.validate(caParam);
        if(result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }
        if(supervisionCaMapper.countByIdNumber(caParam.getIdNumber(),caParam.getId())>0){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"已有该人员");
        }
        SupervisionCa before = supervisionCaMapper.selectByPrimaryKey(caParam.getId());
        if(before==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"待更新人员不存在");
        }
        SupervisionCa supervisionCa = new SupervisionCa();
        BeanUtils.copyProperties(caParam,supervisionCa);
        supervisionCa.setOperateTime(new Date());
        supervisionCa.setOperateIp("124.214.124");
        supervisionCa.setOperator("zcc");

        supervisionCaMapper.updateByPrimaryKeySelective(supervisionCa);
    }

    @Override
    @Transactional
    public void importExcel(MultipartFile file, Integer type) {
        List<EnterpriseListResult> enterpriseListResultList = supervisionEnterpriseMapper.getAll();
        Map<String,Integer> enterpriseMap = new HashMap<>();
        for (EnterpriseListResult enterpriseListResult: enterpriseListResultList)
        {enterpriseMap.put(enterpriseListResult.getEnterpriseName(),enterpriseListResult.getId());}
        List<SysIndustry> sysIndustryList = sysIndustryMapper.getList();
        Map<String,Integer> industryMap = new HashMap<>();
        for (SysIndustry sysIndustry : sysIndustryList){industryMap.put(sysIndustry.getName(),sysIndustry.getId());}
        List<SupervisionCa> supervisionCaList = new ArrayList<>();
        List<SysWorkType> sysWorkTypeList = sysWorkTypeMapper.getList();
        Map<String,Integer> workTypeMap = new HashMap<>();
        for(SysWorkType sysWorkType : sysWorkTypeList){workTypeMap.put(sysWorkType.getName(),sysWorkType.getId());}
        List<SupervisionCa> allCaList = supervisionCaMapper.getAll();
        Map<String,Integer> allCaMap = new HashMap<>();
        for (SupervisionCa supervisionCa : allCaList){allCaMap.put(supervisionCa.getIdNumber(),supervisionCa.getId());}
        if(type == 3){
            try {
                HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
                int numberOfSheets = workbook.getNumberOfSheets();
                for (int i = 0; i < numberOfSheets; i++) {
                    HSSFSheet sheet = workbook.getSheetAt(i);
                    int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                    for (int j = 0; j < physicalNumberOfRows; j++) {
                        if (j == 0) {
                            continue;//标题行
                        }
                        SupervisionCa supervisionCa = new SupervisionCa();
                        HSSFRow row = sheet.getRow(j);
                        supervisionCa.setCompanyName(ExcalUtils.handleStringHSSF(row.getCell(0)));
                        supervisionCa.setCompanyId(enterpriseMap.get(ExcalUtils.handleStringHSSF(row.getCell(0))));
                        supervisionCa.setName(ExcalUtils.handleStringHSSF(row.getCell(1)));
                        supervisionCa.setIdNumber(ExcalUtils.handleStringHSSF(row.getCell(2)));
                        supervisionCa.setSexy(ExcalUtils.handleStringHSSF(row.getCell(3))=="女"?1:0);
                        supervisionCa.setTelephone(ExcalUtils.handleStringHSSF(row.getCell(4)));
                        supervisionCa.setWorkType(workTypeMap.get(ExcalUtils.handleStringHSSF(row.getCell(5))));
                        supervisionCa.setIndustry(industryMap.get(ExcalUtils.handleStringHSSF(row.getCell(6))));
                        supervisionCa.setElectronicNumber(ExcalUtils.handleStringHSSF(row.getCell(7)));
                        supervisionCa.setHealth(ExcalUtils.handleStringHSSF(row.getCell(8)));
                        supervisionCa.setTrain(ExcalUtils.handleStringHSSF(row.getCell(9)));
                        supervisionCa.setEducation(ExcalUtils.handleStringHSSF(row.getCell(10)));
                        supervisionCa.setHealthNumber(ExcalUtils.handleStringHSSF(row.getCell(11)));
                        supervisionCa.setStartTime(ExcalUtils.handleDateHSSF(row.getCell(12)));
                        supervisionCa.setEndTime(ExcalUtils.handleDateHSSF(row.getCell(13)));
                        supervisionCa.setIssuingAuthority(ExcalUtils.handleStringHSSF(row.getCell(14)));
                        supervisionCa.setOperator("操作人");
                        supervisionCa.setOperateIp("123.123.123");
                        supervisionCa.setOperateTime(new Date());
                        if(supervisionCa.getIdNumber()!=null&&supervisionCa.getCompanyId()!=null) {
                            supervisionCaList.add(supervisionCa);
                        }
                    }
                }
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(type == 7){
            try {
                XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                int numberOfSheets = workbook.getNumberOfSheets();
                for (int i = 0; i < numberOfSheets; i++) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                    for (int j = 0; j < physicalNumberOfRows; j++) {
                        if (j == 0) {
                            continue;//标题行
                        }
                        SupervisionCa supervisionCa = new SupervisionCa();
                        XSSFRow row = sheet.getRow(j);
                        supervisionCa.setCompanyName(ExcalUtils.handleStringXSSF(row.getCell(0)));
                        supervisionCa.setCompanyId(enterpriseMap.get(ExcalUtils.handleStringXSSF(row.getCell(0))));
                        supervisionCa.setName(ExcalUtils.handleStringXSSF(row.getCell(1)));
                        supervisionCa.setIdNumber(ExcalUtils.handleStringXSSF(row.getCell(2)));
                        supervisionCa.setSexy(ExcalUtils.handleStringXSSF(row.getCell(3))=="女"?1:0);
                        supervisionCa.setTelephone(ExcalUtils.handleStringXSSF(row.getCell(4)));
                        supervisionCa.setWorkType(workTypeMap.get(ExcalUtils.handleStringXSSF(row.getCell(5))));
                        supervisionCa.setIndustry(industryMap.get(ExcalUtils.handleStringXSSF(row.getCell(6))));
                        supervisionCa.setElectronicNumber(ExcalUtils.handleStringXSSF(row.getCell(7)));
                        supervisionCa.setHealth(ExcalUtils.handleStringXSSF(row.getCell(8)));
                        supervisionCa.setTrain(ExcalUtils.handleStringXSSF(row.getCell(9)));
                        supervisionCa.setEducation(ExcalUtils.handleStringXSSF(row.getCell(10)));
                        supervisionCa.setHealthNumber(ExcalUtils.handleStringXSSF(row.getCell(11)));
                        supervisionCa.setStartTime(ExcalUtils.handleDateXSSF(row.getCell(12)));
                        supervisionCa.setEndTime(ExcalUtils.handleDateXSSF(row.getCell(13)));
                        supervisionCa.setIssuingAuthority(ExcalUtils.handleStringXSSF(row.getCell(14)));
                        supervisionCa.setOperator("操作人");
                        supervisionCa.setOperateIp("123.123.123");
                        supervisionCa.setOperateTime(new Date());
                        if(supervisionCa.getIdNumber()!=null&&supervisionCa.getCompanyId()!=null) {
                            supervisionCaList.add(supervisionCa);
                        }
//                        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
//                        for (int k = 0; k < physicalNumberOfCells; k++) {
//                            XSSFCell cell = row.getCell(k);
//                        }
                    }
                }
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"文件错误");
        }
        List<Integer> updateIds = new ArrayList<>();
        List<SysUser> sysUserList = new ArrayList<>();
        for (SupervisionCa supervisionCa : supervisionCaList){
            if(allCaMap.get(supervisionCa.getIdNumber())!=null){
                int id = allCaMap.get(supervisionCa.getIdNumber());
                updateIds.add(allCaMap.get(supervisionCa.getIdNumber()));
                supervisionCa.setId(id);
            }else {
                SysUser sysUser = new SysUser();
                String encryptedPassword = MD5Util.md5("123456+");
                sysUser.setUsername(supervisionCa.getName());
                sysUser.setLoginName(supervisionCa.getIdNumber());
                sysUser.setPassword(encryptedPassword);
                sysUser.setUserType(3);
                sysUser.setInfoName(supervisionCa.getName());
                sysUser.setInfoId(supervisionCa.getId());
                sysUser.setStatus(0);
                sysUser.setOperator("操作人");
                sysUser.setOperateIp("124.124.124");
                sysUser.setOperateTime(new Date());
                sysUserList.add(sysUser);
            }
        }
        if(updateIds.size()>0){
            supervisionCaMapper.batchDelete(updateIds);
        }
        if(supervisionCaList.size()>0){
            supervisionCaMapper.batchInsert(supervisionCaList);
        }
        Map<String,Integer> caMap = new HashMap<>();
        for(SupervisionCa supervisionCa : supervisionCaList){caMap.put(supervisionCa.getIdNumber(),supervisionCa.getId());}
        if(sysUserList.size()>0){
            sysUserMapper.batchInsert(sysUserList.stream().map(sysUser -> {sysUser.setInfoId(caMap.get(sysUser.getLoginName())); return sysUser;}).collect(Collectors.toList()));
        }
        List<SysRoleUser> sysRoleUserList = new ArrayList<>();
        for(SysUser sysUser:sysUserList)
        {
            SysRoleUser sysRoleUser =new SysRoleUser();
            sysRoleUser.setUserId(sysUser.getId());
            sysRoleUser.setRoleId(28);
            sysRoleUser.setOperateTime(new Date());
            sysRoleUser.setOperator("操作人");
            sysRoleUser.setOperateIp("123.124.124");
            sysRoleUserList.add(sysRoleUser);
        }
        if(sysRoleUserList.size()>0){
            sysRoleUserMapper.batchInsert(sysRoleUserList);
        }
    }

    @Override
    public Map<String, Integer> getStatistics(CaSearchParam caSearchParam, EnterpriseSearchParam enterpriseSearchParam) {
        Map<String,Integer> map =new HashMap<>();
        map.put("companyNumber",supervisionEnterpriseMapper.countList(enterpriseSearchParam));
        map.put("trainNumber",supervisionCaMapper.countListByTrain(caSearchParam,"已培训"));
        return map;
    }

    @Override
    public Map<String, Integer> getEnStatistics(Integer id) {
        Map<String,Integer> map =new HashMap<>();
        map.put("trainNumber",supervisionCaMapper.countTrainByEnterprise(id,"已培训"));
        return map;
    }

    @Override
    public PageResult getListByEnterpriseId(PageQuery pageQuery, SysUser sysUser) {
        int count = supervisionCaMapper.countListByEnterprise(sysUser.getInfoId());
        if (count > 0) {
            List<SupervisionCa> supervisionCaList = supervisionCaMapper.getPageByEnterprise(pageQuery,sysUser.getInfoId());
            PageResult<SupervisionCa> pageResult = new PageResult<>();
            pageResult.setData(supervisionCaList);
            pageResult.setTotal(count);
            pageResult.setPageNo(pageQuery.getPageNo());
            pageResult.setPageSize(pageQuery.getPageSize());
            return pageResult;
        }
        PageResult<SupervisionCa> pageResult = new PageResult<>();
        return pageResult;
    }

    @Override
    public PageResult<SupervisionCa> getCaPageByEnterprise(PageQuery pageQuery, int id) {
        int count = supervisionCaMapper.countListByEnterprise(id);
        if (count > 0) {
            List<SupervisionCa> supervisionCaList = supervisionCaMapper.getPageByEnterprise(pageQuery,id);
            PageResult<SupervisionCa> pageResult = new PageResult<>();
            pageResult.setData(supervisionCaList);
            pageResult.setPageNo(pageQuery.getPageNo());
            pageResult.setPageSize(pageQuery.getPageSize());
            return pageResult;
        }
        PageResult<SupervisionCa> pageResult = new PageResult<>();
        return pageResult;
    }

    @Override
    public List<SupervisionCa> getAllByEnterpriseId(Integer id) {
        return supervisionCaMapper.getAllByEnterpriseId(id);
    }

    @Override
    public PageResult getNameByEnterpriseId(PageQuery pageQuery, SysUser sysUser, MeasurementSearchParam measurementSearchParam) {
        int count = supervisionCaMapper.countListNameByEnterpriseId(sysUser.getInfoId(), measurementSearchParam);
        if (count > 0) {
            List<SupervisionCa> supervisionCaList = supervisionCaMapper.getNameByEnterpriseId(pageQuery,sysUser.getInfoId(), measurementSearchParam);
            PageResult<SupervisionCa> pageResult = new PageResult<>();
            pageResult.setData(supervisionCaList);
            pageResult.setTotal(count);
            pageResult.setPageNo(pageQuery.getPageNo());
            pageResult.setPageSize(pageQuery.getPageSize());
            return pageResult;
        }
        PageResult<SupervisionCa> pageResult = new PageResult<>();
        return pageResult;
    }

    @Override
    public List<SupervisionCaParam> getAllByEnterpriseId2(Integer id) {
        return supervisionCaMapper.getAllByEnterpriseId2(id);
    }

    @Override
    public SupervisionCa getCaInfo(int id)
    {
        return supervisionCaMapper.getCaInfoByUserId(id);
    }

    @Override
    public SupervisionCa getCaInfoByIdNumber(String idNumber){
        if(supervisionCaMapper.countByIdNumber(idNumber,null)==0){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"该人员未注册");
        }
        return supervisionCaMapper.getCaInfoByIdNumber(idNumber);
    }
}
