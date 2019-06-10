package cn.edu.uestc.aone.web.helloworld.model.vo;


/**
 * Department视图对象
 * Created by Carter Peng 2018/10/14
 */
public class DepartmentBase {
    private Integer departmentId;

    private String departmentName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
