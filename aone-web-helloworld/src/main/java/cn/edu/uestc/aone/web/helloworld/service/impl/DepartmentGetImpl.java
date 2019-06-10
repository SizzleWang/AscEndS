package cn.edu.uestc.aone.web.helloworld.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import cn.edu.uestc.aone.web.helloworld.model.vo.DepartmentBase;
import org.springframework.stereotype.Service;

import cn.edu.uestc.aone.web.helloworld.dao.rdb.DepartmentMapper;
import cn.edu.uestc.aone.web.helloworld.model.po.rdb.Department;
import cn.edu.uestc.aone.web.helloworld.service.DepartmentGetService;

/**
 * Department相关业务的服务实现
 * Created by Carter Peng 2018/10/14
 */
@Service
public class DepartmentGetImpl implements DepartmentGetService {
	
	@Resource
	private DepartmentMapper departmentMapper;

	/**
	 * 查询部门列表
	 * @return List<DepartmentBase>
	 */
	@Override
	public List<DepartmentBase> getDepartmentList() {
		// 调用DAO层模块取出数据
		List<Department> departments = departmentMapper.selectAll();
		// 将数据封装成视图对象
		List<DepartmentBase> departmentBases = new ArrayList<>();
		for(Department d : departments){
			DepartmentBase db = new DepartmentBase();
			db.setDepartmentId(d.getDepartmentId());
			db.setDepartmentName(d.getDepartmentName());
			departmentBases.add(db);
		}
		return departmentBases;
	}

	/**
	 * 根据部门id查询部门信息
	 * @param departmentId 部门id
	 * @return 部门基本信息
	 */
	@Override
	public DepartmentBase getDepartment(Integer departmentId) {
		Department department = departmentMapper.selectByPrimaryKey(departmentId);
		DepartmentBase db = new DepartmentBase();
		db.setDepartmentId(department.getDepartmentId());
		db.setDepartmentName(department.getDepartmentName());
		return db;
	}
}
