package com.example.upc.dao;

import com.example.upc.dataobject.SupervisionEnSmallCaterIndex;

public interface SupervisionEnSmallCaterIndexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_small_cater_index
     *
     * @mbg.generated Fri Apr 24 17:31:47 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_small_cater_index
     *
     * @mbg.generated Fri Apr 24 17:31:47 CST 2020
     */
    int insert(SupervisionEnSmallCaterIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_small_cater_index
     *
     * @mbg.generated Fri Apr 24 17:31:47 CST 2020
     */
    int insertSelective(SupervisionEnSmallCaterIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_small_cater_index
     *
     * @mbg.generated Fri Apr 24 17:31:47 CST 2020
     */
    SupervisionEnSmallCaterIndex selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_small_cater_index
     *
     * @mbg.generated Fri Apr 24 17:31:47 CST 2020
     */
    int updateByPrimaryKeySelective(SupervisionEnSmallCaterIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_small_cater_index
     *
     * @mbg.generated Fri Apr 24 17:31:47 CST 2020
     */
    int updateByPrimaryKey(SupervisionEnSmallCaterIndex record);
}