package cn.lhj.sshweb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import cn.lhj.sshweb.model.Department;
import cn.lhj.sshweb.model.User;
import cn.lhj.sshweb.service.DepartmentService;

public class UserConvert implements Converter<String, User>{

	@Autowired
	private DepartmentService departmentService;
	@Override
	public User convert(String source) {
		if(source!=null) {
			String[] strs = source.split(",");
			User user = new User();
			user.setId(Integer.parseInt(strs[0]));
			user.setUsername(strs[1]);
			user.setDpt(departmentService.getOne(Integer.parseInt(strs[2])));
			return user;
		}
		return null;
	}
	
}
