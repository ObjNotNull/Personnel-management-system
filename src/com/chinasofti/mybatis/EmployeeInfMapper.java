package com.chinasofti.mybatis;

import com.chinasofti.pojo.EmployeeInf;

public interface EmployeeInfMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated Tue Jun 15 13:00:02 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated Tue Jun 15 13:00:02 CST 2021
     */
    int insert(EmployeeInf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated Tue Jun 15 13:00:02 CST 2021
     */
    int insertSelective(EmployeeInf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated Tue Jun 15 13:00:02 CST 2021
     */
    EmployeeInf selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated Tue Jun 15 13:00:02 CST 2021
     */
    int updateByPrimaryKeySelective(EmployeeInf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_inf
     *
     * @mbggenerated Tue Jun 15 13:00:02 CST 2021
     */
    int updateByPrimaryKey(EmployeeInf record);
}