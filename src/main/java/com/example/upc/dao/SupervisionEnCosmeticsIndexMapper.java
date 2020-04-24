package com.example.upc.dao;

import com.example.upc.dataobject.SupervisionEnCosmeticsIndex;

public interface SupervisionEnCosmeticsIndexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_cosmetics_index
     *
     * @mbg.generated Thu Apr 23 00:04:26 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_cosmetics_index
     *
     * @mbg.generated Thu Apr 23 00:04:26 CST 2020
     */
    int insert(SupervisionEnCosmeticsIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_cosmetics_index
     *
     * @mbg.generated Thu Apr 23 00:04:26 CST 2020
     */
    int insertSelective(SupervisionEnCosmeticsIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_cosmetics_index
     *
     * @mbg.generated Thu Apr 23 00:04:26 CST 2020
     */
    SupervisionEnCosmeticsIndex selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_cosmetics_index
     *
     * @mbg.generated Thu Apr 23 00:04:26 CST 2020
     */
    int updateByPrimaryKeySelective(SupervisionEnCosmeticsIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_cosmetics_index
     *
     * @mbg.generated Thu Apr 23 00:04:26 CST 2020
     */
    int updateByPrimaryKey(SupervisionEnCosmeticsIndex record);
}