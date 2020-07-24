package cn.lhj.sshweb.service;

public interface BaseServiceI<T> {
	public void insert(T t);

	public void delete(int id);

	public void update(T t);

	public T getOne(int id);
}
