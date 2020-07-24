package cn.lhj.sshweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.lhj.sshweb.model.Department;

@Repository(value = "departmentDao")
public class DepartmentDaoImpl extends BaseDao<Department> implements DeparmentDao{

	@Override
	public List<Department> getAll() {
		String hql = "from Department";
		return getSession().createQuery(hql).list();
	}

}
