package com.my.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.spring.dao.interfaces.TeacherDAO;
import com.my.spring.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

	private static final Logger logger = LoggerFactory.getLogger(TeacherDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void add(Teacher element) {
		Session s=sessionFactory.getCurrentSession();
		s.persist(element);
		logger.debug("new teacher added with id"+element.getId());
	}

	@Override
	public void update(Teacher element) {
		Session s=sessionFactory.getCurrentSession();
		s.update(element);
		logger.debug("new updated with id"+element.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> list() {
		Session s=sessionFactory.getCurrentSession();
		return s.createQuery("from Teacher").list();
	}

	@Override
	public Teacher getById(int id) {
		Session s=sessionFactory.getCurrentSession();
		Teacher t=(Teacher) s.load(Teacher.class, id);
		return t;
	}

	@Override
	public void remove(int id) {
		Session s=sessionFactory.getCurrentSession();
		Teacher t=(Teacher) s.load(Teacher.class, id);
		if (t!=null){
			s.delete(t);
			logger.debug("teacher removed with id"+t.getId());
		}
	}

}
