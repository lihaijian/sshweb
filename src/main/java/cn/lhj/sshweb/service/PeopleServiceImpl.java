package cn.lhj.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.sshweb.dao.PeopleDao;
import cn.lhj.sshweb.model.People;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService{

	public PeopleServiceImpl() {
		System.out.println("peopleService init ");
	}
	@Autowired
	private PeopleDao peopleDao;
	@Override
	public List<People> getAll() {
		// TODO Auto-generated method stub
		return peopleDao.getAll();
	}
	
}
