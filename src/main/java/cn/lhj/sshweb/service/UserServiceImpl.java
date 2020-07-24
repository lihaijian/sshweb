package cn.lhj.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.sshweb.dao.UserDao;
import cn.lhj.sshweb.model.User;

@Service(value = "userService")
public class UserServiceImpl extends BaseService<User> implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

}
