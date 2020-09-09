package com.example.upc.dataobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class FormatDisinfection {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.id
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.unit
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private Integer unit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.area
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private Integer area;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.name
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @NotBlank(message = "物品名称不能为空")
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.amount
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @NotNull(message = "数量不能为空")
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.date
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "消毒日期不能为空")
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.ca_id
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private Integer caId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.person
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private String person;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.start1
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @NotNull(message = "开始时不能为空")
    private Integer start1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.start2
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @NotNull(message = "开始分不能为空")
    private Integer start2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.end1
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @NotNull(message = "结束时不能为空")
    private Integer end1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.end2
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @NotNull(message = "结束分不能为空")
    private Integer end2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.way
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    @NotBlank(message = "消毒方式不能为空")
    private String way;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.remark
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.operator
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.operator_ip
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private String operatorIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column format_disinfection.operator_time
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    private Date operatorTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.id
     *
     * @return the value of format_disinfection.id
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.id
     *
     * @param id the value for format_disinfection.id
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.unit
     *
     * @return the value of format_disinfection.unit
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.unit
     *
     * @param unit the value for format_disinfection.unit
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.area
     *
     * @return the value of format_disinfection.area
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.area
     *
     * @param area the value for format_disinfection.area
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.name
     *
     * @return the value of format_disinfection.name
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.name
     *
     * @param name the value for format_disinfection.name
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.amount
     *
     * @return the value of format_disinfection.amount
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.amount
     *
     * @param amount the value for format_disinfection.amount
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.date
     *
     * @return the value of format_disinfection.date
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.date
     *
     * @param date the value for format_disinfection.date
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.ca_id
     *
     * @return the value of format_disinfection.ca_id
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getCaId() {
        return caId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.ca_id
     *
     * @param caId the value for format_disinfection.ca_id
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.person
     *
     * @return the value of format_disinfection.person
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public String getPerson() {
        return person;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.person
     *
     * @param person the value for format_disinfection.person
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.start1
     *
     * @return the value of format_disinfection.start1
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getStart1() {
        return start1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.start1
     *
     * @param start1 the value for format_disinfection.start1
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setStart1(Integer start1) {
        this.start1 = start1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.start2
     *
     * @return the value of format_disinfection.start2
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getStart2() {
        return start2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.start2
     *
     * @param start2 the value for format_disinfection.start2
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setStart2(Integer start2) {
        this.start2 = start2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.end1
     *
     * @return the value of format_disinfection.end1
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getEnd1() {
        return end1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.end1
     *
     * @param end1 the value for format_disinfection.end1
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setEnd1(Integer end1) {
        this.end1 = end1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.end2
     *
     * @return the value of format_disinfection.end2
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Integer getEnd2() {
        return end2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.end2
     *
     * @param end2 the value for format_disinfection.end2
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setEnd2(Integer end2) {
        this.end2 = end2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.way
     *
     * @return the value of format_disinfection.way
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public String getWay() {
        return way;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.way
     *
     * @param way the value for format_disinfection.way
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setWay(String way) {
        this.way = way == null ? null : way.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.remark
     *
     * @return the value of format_disinfection.remark
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.remark
     *
     * @param remark the value for format_disinfection.remark
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.operator
     *
     * @return the value of format_disinfection.operator
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.operator
     *
     * @param operator the value for format_disinfection.operator
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.operator_ip
     *
     * @return the value of format_disinfection.operator_ip
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public String getOperatorIp() {
        return operatorIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.operator_ip
     *
     * @param operatorIp the value for format_disinfection.operator_ip
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp == null ? null : operatorIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column format_disinfection.operator_time
     *
     * @return the value of format_disinfection.operator_time
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public Date getOperatorTime() {
        return operatorTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column format_disinfection.operator_time
     *
     * @param operatorTime the value for format_disinfection.operator_time
     *
     * @mbg.generated Tue Sep 08 21:58:30 CST 2020
     */
    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }
}