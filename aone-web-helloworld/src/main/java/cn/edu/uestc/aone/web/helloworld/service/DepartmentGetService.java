package cn.edu.uestc.aone.web.helloworld.service;

import java.util.List;

import cn.edu.uestc.aone.web.helloworld.model.po.rdb.Department;
import cn.edu.uestc.aone.web.helloworld.model.vo.DepartmentBase;

/**
 * Department相关业务的服务接口
 * Created by Carter Peng 2018/10/14
 */
public interface DepartmentGetService {

	/**
	 * 查询部门列表
	 * @return List<DepartmentBase>
	 */
	List<DepartmentBase> getDepartmentList();

	/**
	 * 根据部门id查询部门信息
	 * @param departmentId 部门id
	 * @return 部门基本信息
	 */
	DepartmentBase getDepartment(Integer departmentId);
}
