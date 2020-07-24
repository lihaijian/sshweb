package cn.lhj.sshweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.lhj.sshweb.model.User;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public List<User> getAll() {
		String hql = "from User u ";
		return getSession().createQuery(hql).list();	
	}

}
