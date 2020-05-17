package com.example.upc.dao;

import com.example.upc.dataobject.SupervisionEnIndustrialProductsIndex;
import com.example.upc.dataobject.SupervisionEnMedicalBuIndex;
import com.example.upc.dataobject.SupervisionEnMedicalProIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupervisionEnMedicalBuIndexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu_index
     *
     * @mbg.generated Fri Apr 24 17:22:03 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu_index
     *
     * @mbg.generated Fri Apr 24 17:22:03 CST 2020
     */
    int insert(SupervisionEnMedicalBuIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu_index
     *
     * @mbg.generated Fri Apr 24 17:22:03 CST 2020
     */
    int insertSelective(SupervisionEnMedicalBuIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu_index
     *
     * @mbg.generated Fri Apr 24 17:22:03 CST 2020
     */
    SupervisionEnMedicalBuIndex selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu_index
     *
     * @mbg.generated Fri Apr 24 17:22:03 CST 2020
     */
    int updateByPrimaryKeySelective(SupervisionEnMedicalBuIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supervision_en_medical_bu_index
     *
     * @mbg.generated Fri Apr 24 17:22:03 CST 2020
     */
    int updateByPrimaryKey(SupervisionEnMedicalBuIndex record);

    SupervisionEnMedicalBuIndex selectByEnterpriseId(@Param("eid") Integer eid);
    List<SupervisionEnMedicalBuIndex> getAll();
    int deleteByEnterpriseId(@Param("eid") Integer eid);
}