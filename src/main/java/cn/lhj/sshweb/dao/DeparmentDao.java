package cn.lhj.sshweb.dao;

import java.util.List;

import cn.lhj.sshweb.model.Department;

public interface DeparmentDao extends BaseDaoI<Department>{
	public List<Department> getAll();
}
