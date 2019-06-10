package cn.edu.uestc.aone.web.helloworld.model.po.rdb;

/**
 * MyBatis Department持久化对象
 * Created by Carter Peng 2018/10/14
 */
public class Department {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.department_ID
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    private Integer departmentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.department_name
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    private String departmentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.department_fullname
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    private String departmentFullname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.department_ID
     *
     * @return the value of department.department_ID
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_ID
     *
     * @param departmentId the value for department.department_ID
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.department_name
     *
     * @return the value of department.department_name
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_name
     *
     * @param departmentName the value for department.department_name
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.department_fullname
     *
     * @return the value of department.department_fullname
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    public String getDepartmentFullname() {
        return departmentFullname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_fullname
     *
     * @param departmentFullname the value for department.department_fullname
     *
     * @mbg.generated Sat Jun 30 21:35:27 CST 2018
     */
    public void setDepartmentFullname(String departmentFullname) {
        this.departmentFullname = departmentFullname == null ? null : departmentFullname.trim();
    }
}