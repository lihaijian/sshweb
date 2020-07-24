package cn.lhj.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.sshweb.dao.DeparmentDao;
import cn.lhj.sshweb.model.Department;

@Service(value = "departmentService")
public class DepartmentServiceImpl extends BaseService<Department> implements DepartmentService{
	@Autowired
	private DeparmentDao deparmentDao;
	@Override
	public List<Department> getAllDepartments() {
		return deparmentDao.getAll();
	}

}
