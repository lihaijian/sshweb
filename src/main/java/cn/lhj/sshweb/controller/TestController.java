package cn.lhj.sshweb.controller;

import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.sshweb.model.Department;
import cn.lhj.sshweb.model.User;
import cn.lhj.sshweb.service.DepartmentService;
import cn.lhj.sshweb.service.UserService;
import javassist.expr.NewArray;

@Controller
public class TestController{
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
	public String addUser(@Valid User user,BindingResult err,ModelMap modelMap) {
		System.out.println("In adduser");
		if(err.getErrorCount()>0) {
			System.out.println("新增的时候参数有不合法的内容,不合法的总数是："+err.getErrorCount());
			for(FieldError fe:err.getFieldErrors()) {
				System.out.println("===="+fe.getField()+":"+fe.getDefaultMessage());
			}
			//modelMap.addAttribute("user", new User());
			modelMap.addAttribute("dpts", departmentService.getAllDepartments());
			return "add";
		}
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
	
	/**
	 * json 测试
	 * @return
	 */
	@RequestMapping(value = "/jsonTestView",method = RequestMethod.GET)
	public String JsonTestView() {
		return "jsonTestView";
	}
	
	/**
	 * requestbody 和responsebody测试
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jsonTest", method = RequestMethod.POST)
	public List<User> JsonTest(){
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	@ResponseBody
	@RequestMapping(value = "/jsonUploadFile",method = RequestMethod.POST)
	public String UploadFile(@RequestBody String text) {
		System.out.println(text);
		return "hahah"+new Date();
	}
	
	/**
	 * 文件上传
	 * @param mark
	 * @param file
	 * @param req
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/UploadFile",method = RequestMethod.POST)
	public String UploadFile(@RequestParam("mark") String mark, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			//System.out.println("---=====IN ");
			String fileName = file.getOriginalFilename();
			String path = req.getServletContext().getRealPath("resources/uploadfiles/");
			File file1 = new File(path,fileName);
			//System.out.println(file1.getParentFile());
			if(!file1.getParentFile().exists()) {
				//System.out.println("mkdir directories");
				file1.getParentFile().mkdirs();
			}
			file.transferTo(file1);
		}
		
		return "redirect:/users";
	}
	
	/**
	 * 下载文件
	 * @param fileName
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "downloadFile")
	public ResponseEntity<byte[]> downloadFile(@RequestParam("fileName") String fileName,HttpServletRequest req) throws IOException {
		String path = req.getServletContext().getRealPath("resources/uploadfiles");
		File file = new File(path,fileName);
		System.out.println(file);
		HttpHeaders headers = new HttpHeaders();
		String downloadFileName = new String(fileName.getBytes("UTF-8"),"UTF-8");
		headers.setContentDispositionFormData("attachment", downloadFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	

}
