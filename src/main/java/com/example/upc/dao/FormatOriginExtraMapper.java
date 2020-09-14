package com.example.upc.dao;

import com.example.upc.controller.param.PageQuery;
import com.example.upc.controller.searchParam.OriginExtraSearchParam;
import com.example.upc.dataobject.FormatOriginExtra;
import com.example.upc.dataobject.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormatOriginExtraMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_origin_extra
     *
     * @mbg.generated Mon Sep 14 17:18:16 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_origin_extra
     *
     * @mbg.generated Mon Sep 14 17:18:16 CST 2020
     */
    int insert(FormatOriginExtra record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_origin_extra
     *
     * @mbg.generated Mon Sep 14 17:18:16 CST 2020
     */
    int insertSelective(FormatOriginExtra record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_origin_extra
     *
     * @mbg.generated Mon Sep 14 17:18:16 CST 2020
     */
    FormatOriginExtra selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_origin_extra
     *
     * @mbg.generated Mon Sep 14 17:18:16 CST 2020
     */
    int updateByPrimaryKeySelective(FormatOriginExtra record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table format_origin_extra
     *
     * @mbg.generated Mon Sep 14 17:18:16 CST 2020
     */
    int updateByPrimaryKey(FormatOriginExtra record);

    int countList(@Param("search") OriginExtraSearchParam search, @Param("id") Integer id);
    List<FormatOriginExtra> getPage(@Param("page") PageQuery page, @Param("id") Integer id, @Param("search")  OriginExtraSearchParam search);
    FormatOriginExtra selectByName(@Param("materialname") String materialname);
    List<FormatOriginExtra> getPage2(@Param("id") Integer id, @Param("search")  OriginExtraSearchParam search);

    void insertList(List<FormatOriginExtra> formatOriginExtraList, SysUser sysUser);
}