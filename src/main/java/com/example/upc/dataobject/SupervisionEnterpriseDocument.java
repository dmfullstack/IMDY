package com.example.upc.dataobject;

public class SupervisionEnterpriseDocument {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supervision_enterprise_document.id
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supervision_enterprise_document.enterprise_id
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    private Integer enterpriseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supervision_enterprise_document.flag
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    private Integer flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supervision_enterprise_document.document
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    private String document;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supervision_enterprise_document.id
     *
     * @return the value of supervision_enterprise_document.id
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supervision_enterprise_document.id
     *
     * @param id the value for supervision_enterprise_document.id
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supervision_enterprise_document.enterprise_id
     *
     * @return the value of supervision_enterprise_document.enterprise_id
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supervision_enterprise_document.enterprise_id
     *
     * @param enterpriseId the value for supervision_enterprise_document.enterprise_id
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supervision_enterprise_document.flag
     *
     * @return the value of supervision_enterprise_document.flag
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supervision_enterprise_document.flag
     *
     * @param flag the value for supervision_enterprise_document.flag
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supervision_enterprise_document.document
     *
     * @return the value of supervision_enterprise_document.document
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public String getDocument() {
        return document;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supervision_enterprise_document.document
     *
     * @param document the value for supervision_enterprise_document.document
     *
     * @mbg.generated Sun May 17 09:37:05 CST 2020
     */
    public void setDocument(String document) {
        this.document = document == null ? null : document.trim();
    }
}