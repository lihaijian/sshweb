package cn.lhj.sshweb.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> implements BaseDaoI<T>{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> getTClass(){
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void insert(T t) {
		getSession().save(t);
	}
	
	public void delete(int id) {
		getSession().delete(getOne(id));
	}
	
	public void update(T t) {
		getSession().update(t);
	}
	
	public T getOne(int id) {
		return getSession().load(getTClass(), id);
	}
}
