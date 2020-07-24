package cn.lhj.sshweb.dao;

import java.util.List;

import cn.lhj.sshweb.model.User;

public interface UserDao extends BaseDaoI<User>{
	public List<User> getAll();
}
