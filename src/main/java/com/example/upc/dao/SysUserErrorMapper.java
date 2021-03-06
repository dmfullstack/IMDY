package com.example.upc.dao;

import com.example.upc.dataobject.SysUserError;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SysUserErrorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_error
     *
     * @mbg.generated Wed Jun 10 22:52:23 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_error
     *
     * @mbg.generated Wed Jun 10 22:52:23 CST 2020
     */
    int insert(SysUserError record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_error
     *
     * @mbg.generated Wed Jun 10 22:52:23 CST 2020
     */
    int insertSelective(SysUserError record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_error
     *
     * @mbg.generated Wed Jun 10 22:52:23 CST 2020
     */
    SysUserError selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_error
     *
     * @mbg.generated Wed Jun 10 22:52:23 CST 2020
     */
    int updateByPrimaryKeySelective(SysUserError record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_error
     *
     * @mbg.generated Wed Jun 10 22:52:23 CST 2020
     */
    int updateByPrimaryKey(SysUserError record);

    SysUserError selectByUserId(@Param("uid") Integer uid, @Param("startTime") String startTime, @Param("endTime") String endTime);
    int deleteAll();
}