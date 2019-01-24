package com.my.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.my.spring.dao.interfaces.SubjectDAO;
import com.my.spring.model.Subject;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	private static final Logger logger = LoggerFactory.getLogger(SubjectDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void add(Subject subject) {
		Session s=sessionFactory.getCurrentSession();
		s.persist(subject);
		logger.debug("subject added");
	}

	@Override
	public void update(Subject subject) {
		Session s=sessionFactory.getCurrentSession();
		s.update(subject);
		logger.debug("subject updated");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> list() {
		logger.debug("subject list method called");
		Session s=sessionFactory.getCurrentSession();
		return s.createQuery("from Subject").list();
	}

	@Override
	public Subject getById(int id) {
		Session s=sessionFactory.getCurrentSession();
		Subject sub=(Subject) s.load(Subject.class, id);
		logger.debug("subject returned by id");
		return sub;
	}

	@Override
	public void remove(int id) {
		Session s=sessionFactory.getCurrentSession();
		Subject sub=(Subject) s.load(Subject.class, id);
		if (sub!=null){
			s.delete(sub);
			logger.debug("subject removed by id");	
		}
		else{
			logger.debug("subject with id"+id+" not found in db");
		}
	}

}
