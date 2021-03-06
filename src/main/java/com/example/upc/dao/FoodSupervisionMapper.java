package com.example.upc.dao;

import com.example.upc.controller.param.PageQuery;
import com.example.upc.dataobject.FoodSupervision;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodSupervisionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_supervision
     *
     * @mbg.generated Thu May 16 15:02:38 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_supervision
     *
     * @mbg.generated Thu May 16 15:02:38 CST 2019
     */
    int insert(FoodSupervision record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_supervision
     *
     * @mbg.generated Thu May 16 15:02:38 CST 2019
     */
    int insertSelective(FoodSupervision record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_supervision
     *
     * @mbg.generated Thu May 16 15:02:38 CST 2019
     */
    FoodSupervision selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_supervision
     *
     * @mbg.generated Thu May 16 15:02:38 CST 2019
     */
    int updateByPrimaryKeySelective(FoodSupervision record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_supervision
     *
     * @mbg.generated Thu May 16 15:02:38 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(FoodSupervision record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_supervision
     *
     * @mbg.generated Thu May 16 15:02:38 CST 2019
     */
    int updateByPrimaryKey(FoodSupervision record);
    int countList();
    List<FoodSupervision> getPage(@Param("page") PageQuery page);
}