package com.example.upc.dao;

import com.example.upc.controller.param.PageQuery;
import com.example.upc.dataobject.AbnormalContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbnormalContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal_content
     *
     * @mbg.generated Sun Apr 19 17:11:21 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal_content
     *
     * @mbg.generated Sun Apr 19 17:11:21 CST 2020
     */
    int insert(AbnormalContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal_content
     *
     * @mbg.generated Sun Apr 19 17:11:21 CST 2020
     */
    int insertSelective(AbnormalContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal_content
     *
     * @mbg.generated Sun Apr 19 17:11:21 CST 2020
     */
    AbnormalContent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal_content
     *
     * @mbg.generated Sun Apr 19 17:11:21 CST 2020
     */
    int updateByPrimaryKeySelective(AbnormalContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal_content
     *
     * @mbg.generated Sun Apr 19 17:11:21 CST 2020
     */
    int updateByPrimaryKey(AbnormalContent record);

    int countList();
    List<AbnormalContent> getPage(@Param("page") PageQuery page);
    List<AbnormalContent> getList();
    int countByType(@Param("content") String Content, @Param("Id") Integer Id);
}