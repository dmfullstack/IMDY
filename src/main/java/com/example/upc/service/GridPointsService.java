package com.example.upc.service;

import com.example.upc.controller.param.GridPoints1;
import com.example.upc.controller.param.SmilePoints;
import com.example.upc.controller.param.SmilePointsPhone;
import com.example.upc.controller.param.enterpriseId;
import com.example.upc.controller.searchParam.EnterpriseSearchParam;
import com.example.upc.dataobject.GridPoints;
import com.example.upc.dataobject.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zcc
 * @date 2019/8/13 11:11
 */
public interface GridPointsService {
    List<GridPoints> getAll();
    List<GridPoints1> getAll1();
    List<GridPoints> getByAreaId(int id);
    int checkPoint(int id);
    int updatePoint(GridPoints record);
    int insertPoint(GridPoints record);
    List<SmilePoints> getSmileMapPoints(EnterpriseSearchParam enterpriseSearchParam);
    List<SmilePoints> getSmileMapPointsPhone(EnterpriseSearchParam enterpriseSearchParam);
    List<enterpriseId> getEnterpriseByName(String name);

    Map<String,Object> getAreaEnterprise();
    int deleteByEnterpriseId(int id);
    GridPoints getPointByEnterpriseId(Integer id);
    int getVideoIdByEnterprise(int id);
    void updateEnterprisePoint(int id , String code, String points, SysUser sysUser);
}
