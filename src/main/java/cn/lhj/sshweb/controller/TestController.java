package cn.lhj.sshweb.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lhj.sshweb.model.Department;
import cn.lhj.sshweb.model.User;
import cn.lhj.sshweb.service.DepartmentService;
import cn.lhj.sshweb.service.UserService;
import javassist.expr.NewArray;

@Controller
public class TestController {
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/testUser")
	public String testUser() {
		Department dpt = new Department();
		dpt.setDptName("sysu1");

		User user = new User();
		user.setUsername("lhj1");
		user.setDpt(dpt);

		departmentService.insert(dpt);
		userService.insert(user);
		return "testuser";
	}

	/**
	 * 查询全部用户
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getAllUsers(ModelMap modelMap) {
		List<User> users = userService.getAllUsers();
		modelMap.put("users", users);
		return "users";
	}

	/**
	 * 更新用户界面
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String getOneForUpdate(@PathVariable(value = "id") int id, ModelMap modelMap) {
		User user = userService.getOne(id);
		List<Department> dpts = departmentService.getAllDepartments();
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("dpts", dpts);
		return "update";
	}

	/**
	 * 更新用户预处理
	 * 
	 * @param id
	 * @param dptid
	 * @param modelMap
	 */

	// 接收表单参数用requestParam,不是pathvariable
	@ModelAttribute
	public void getUpdateUser(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "dpt.id", required = false) Integer dptid, ModelMap modelMap) {
		System.out.println("in ModelAttribute" + " id=" + id + " dpt.id=" + dptid);
		if (id != null && dptid != null) {
			User user = userService.getOne(id);
			Department dpt = departmentService.getOne(dptid);
			System.out.println(dpt);
			user.setDpt(dpt);
			modelMap.addAttribute("user", user);
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);//必须是符合日期格式，例如没有13月，32日这种，如果不符合，则报错。没有智能。
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));	
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public String updateOneUser(User user) {
		userService.update(user);
		return "redirect:/users";
	}

	/**
	 * 新增用户界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String addUserView(ModelMap modelMap) {
		modelMap.addAttribute("user", new User());
		modelMap.addAttribute("dpts", departmentService.getAllDepartments());
		return "add";
	}

	/**
	 * 新增用户操作。
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String addUser(User user) {
		userService.insert(user);
		return "redirect:/users";
	}
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delUser(@PathVariable(value = "id") Integer id) {
		if (id != null) {
			userService.delete(id);
		}
		return "redirect:/users";
	}
	
	/**
	 * 将输入的user格式化处理。
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/convertuser",method = RequestMethod.POST)
	public String convertUser(User user) {
		System.out.println("user="+user);
		return "redirect:/users";
	}

}
