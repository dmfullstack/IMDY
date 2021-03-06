package com.example.upc.dao;

import com.example.upc.controller.param.PageQuery;
import com.example.upc.controller.searchParam.MeasurementSearchParam;
import com.example.upc.dataobject.FormatRecovery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormatRecoveryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_recovery
     *
     * @mbg.generated Fri Oct 18 20:20:09 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_recovery
     *
     * @mbg.generated Fri Oct 18 20:20:09 CST 2019
     */
    int insert(FormatRecovery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_recovery
     *
     * @mbg.generated Fri Oct 18 20:20:09 CST 2019
     */
    int insertSelective(FormatRecovery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_recovery
     *
     * @mbg.generated Fri Oct 18 20:20:09 CST 2019
     */
    FormatRecovery selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_recovery
     *
     * @mbg.generated Fri Oct 18 20:20:09 CST 2019
     */
    int updateByPrimaryKeySelective(FormatRecovery record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_recovery
     *
     * @mbg.generated Fri Oct 18 20:20:09 CST 2019
     */
    int updateByPrimaryKey(FormatRecovery record);

    int countList(@Param("search") MeasurementSearchParam search, @Param("id") Integer id);
    List<FormatRecovery> getPage(@Param("page") PageQuery page, @Param("search") MeasurementSearchParam search, @Param("id") Integer id);
    int countByAll(@Param("id") Integer id, @Param("enterprise") String enterprise, @Param("charger") String charger, @Param("address") String address,@Param("phone") String phone, @Param("Id") Integer Id);
    List<FormatRecovery> getPage2(@Param("search") MeasurementSearchParam search, @Param("id") Integer id);
}