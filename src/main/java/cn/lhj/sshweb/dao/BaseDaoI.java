package cn.lhj.sshweb.dao;

public interface BaseDaoI<T> {
	public void insert(T t);

	public void delete(int id);

	public void update(T t);

	public T getOne(int id);
}
