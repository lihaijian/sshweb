package cn.lhj.sshweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.lhj.sshweb.model.People;

@Repository("peopleDao")
public class PeopleDaoImpl implements PeopleDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<People> getAll() {
		String hql = "from People";
		System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		List<People> peoples = session.createQuery(hql).list();
		//System.out.println(peoples);
		return peoples;
	}

}
