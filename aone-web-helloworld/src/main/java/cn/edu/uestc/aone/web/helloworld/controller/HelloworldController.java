package cn.edu.uestc.aone.web.helloworld.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.uestc.aone.web.helloworld.service.DepartmentGetService;
import cn.edu.uestc.aone.web.helloworld.model.vo.DepartmentBase;

/**
 * 有关于事项处理的Controller
 * Created by Carter Peng 2018/10/14
 */
@Controller
// 响应URL路径以"/helloworld"开头的请求
@RequestMapping(value = "/helloworld")
public class HelloworldController {
	// Spring自动实例化一个DepartmentGetService对象
	@Autowired
	private DepartmentGetService departmentListGetService;

	/**
	 * 获取部门列表
	 * @return List<DepartmentBase>
	 */
	// ResponseBody将Return对象进行格式转换（本项目配置为JSON格式）作为HTTP响应正文返回
	@ResponseBody
	// 映射请求参数，该方法响应URL地址以“/department/list”的GET请求
	@RequestMapping(value = "/department/list", method = RequestMethod.GET)
	private List<DepartmentBase> getDepartmentList() {
		List<DepartmentBase> departments = departmentListGetService.getDepartmentList();
		return departments;
	}

	/**
	 * 获取部门信息
	 * @return DepartmentBase
	 */
	@ResponseBody
	@RequestMapping(value = "/department/info", method = RequestMethod.GET)
	private DepartmentBase getDepartmentInfo(Integer departmentId) {
		DepartmentBase department = departmentListGetService.getDepartment(departmentId);
		return department;
	}

	/**
	 * 响应index页面
	 * @param model 向视图传递的参数Map
	 * @return 负责响应的页面名
	 */
	@RequestMapping("/index")
	public String toIndex(ModelMap model) {
		model.addAttribute("tittle", "affair page");
		return "/html/index.html";
	}

	/**
	 * 响应一个JSP示例页面
	 * @param model 向视图传递的参数Map
	 * @return 负责响应的页面名
	 */
	@RequestMapping("/jspTemplate")
	public String toTemplate(ModelMap model) {
		model.addAttribute("title", "Aone Hello World Web App");
		return "/html/jspTemplate.jsp";
	}
}
