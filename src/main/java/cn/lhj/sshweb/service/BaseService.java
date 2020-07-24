package cn.lhj.sshweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lhj.sshweb.dao.BaseDao;

public class BaseService<T> implements BaseServiceI<T>{
	
	@Autowired
	private BaseDao<T> baseDao;
	
	@Override
	public void insert(T t) {
		System.out.println("baseDao="+baseDao);
		baseDao.insert(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public T getOne(int id) {
		return baseDao.getOne(id);
	}

}
