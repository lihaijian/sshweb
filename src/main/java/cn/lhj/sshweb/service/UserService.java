package cn.lhj.sshweb.service;

import java.util.List;

import cn.lhj.sshweb.model.User;

public interface UserService extends BaseServiceI<User>{
	public List<User> getAllUsers();
}
