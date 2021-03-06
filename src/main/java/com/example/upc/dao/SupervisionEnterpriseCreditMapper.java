package com.example.upc.dao;

import com.example.upc.controller.param.PageQuery;
import com.example.upc.controller.param.SupervisionEnterpriseCreditParam;
import com.example.upc.controller.param.SupervisionEnterpriseCreditParamDetail;
import com.example.upc.controller.searchParam.SupervisionEnterpriseCreditSearchParam;
import com.example.upc.dataobject.SupervisionEnterpriseCredit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupervisionEnterpriseCreditMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_enterprise_credit
     *
     * @mbg.generated Mon Nov 30 20:50:04 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_enterprise_credit
     *
     * @mbg.generated Mon Nov 30 20:50:04 CST 2020
     */
    int insert(SupervisionEnterpriseCredit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_enterprise_credit
     *
     * @mbg.generated Mon Nov 30 20:50:05 CST 2020
     */
    int insertSelective(SupervisionEnterpriseCredit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_enterprise_credit
     *
     * @mbg.generated Mon Nov 30 20:50:05 CST 2020
     */
    SupervisionEnterpriseCredit selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_enterprise_credit
     *
     * @mbg.generated Mon Nov 30 20:50:05 CST 2020
     */
    int updateByPrimaryKeySelective(SupervisionEnterpriseCredit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_enterprise_credit
     *
     * @mbg.generated Mon Nov 30 20:50:05 CST 2020
     */
    int updateByPrimaryKey(SupervisionEnterpriseCredit record);

    List<SupervisionEnterpriseCredit> selectByEnterpriseId(@Param("searchParam") SupervisionEnterpriseCreditSearchParam supervisionEnterpriseCreditSearchParam, @Param("page")PageQuery pageQuery);

    List<SupervisionEnterpriseCreditParam> getPage(@Param("searchParam")  SupervisionEnterpriseCreditSearchParam supervisionEnterpriseCreditSearchParam,@Param("page")PageQuery pageQuery);

    List<SupervisionEnterpriseCreditParamDetail> getCreditPage(@Param("searchParam")  SupervisionEnterpriseCreditSearchParam supervisionEnterpriseCreditSearchParam, @Param("page")PageQuery pageQuery);

    int counListCredit(@Param("flag") int flag);
}