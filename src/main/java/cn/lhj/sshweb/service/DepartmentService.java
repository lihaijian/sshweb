package cn.lhj.sshweb.service;

import java.util.List;

import cn.lhj.sshweb.model.Department;

public interface DepartmentService extends BaseServiceI<Department> {
	public List<Department> getAllDepartments();
}
