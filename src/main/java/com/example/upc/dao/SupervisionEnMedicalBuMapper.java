package com.example.upc.dao;

import com.example.upc.dataobject.SupervisionEnFoodPro;
import com.example.upc.dataobject.SupervisionEnMedicalBu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupervisionEnMedicalBuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu
     *
     * @mbg.generated Fri Apr 24 17:23:04 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu
     *
     * @mbg.generated Fri Apr 24 17:23:04 CST 2020
     */
    int insert(SupervisionEnMedicalBu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu
     *
     * @mbg.generated Fri Apr 24 17:23:04 CST 2020
     */
    int insertSelective(SupervisionEnMedicalBu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu
     *
     * @mbg.generated Fri Apr 24 17:23:04 CST 2020
     */
    SupervisionEnMedicalBu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu
     *
     * @mbg.generated Fri Apr 24 17:23:04 CST 2020
     */
    int updateByPrimaryKeySelective(SupervisionEnMedicalBu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu
     *
     * @mbg.generated Fri Apr 24 17:23:04 CST 2020
     */
    int updateByPrimaryKey(SupervisionEnMedicalBu record);

    List<SupervisionEnMedicalBu> getListByEnterpriseId(@Param("enterpriseId") int eid);
}