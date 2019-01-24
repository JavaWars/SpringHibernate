package com.my.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.spring.dao.interfaces.SubjectDAO;
import com.my.spring.model.Person;
import com.my.spring.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

	private SubjectDAO subjectDAO;

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	
	@Override
	@Transactional
	public void addSubject(Subject subject) {
		subjectDAO.add(subject);
	}

	@Override
	@Transactional
	public void updateSubject(Subject subject) {
		subjectDAO.update(subject);
	}

	@Override
	@Transactional
	public List<Subject> listSubjects() {
		return subjectDAO.list();
	}

	@Override
	@Transactional
	public Subject getSubjectById(int id) {
		return subjectDAO.getById(id);
	}

	@Override
	@Transactional
	public void removeSubject(int id) {
		subjectDAO.remove(id);
	}

	@Override
	@Transactional
	public int getTotalSubjectCount() {
		//TODO create this method
		return 0;
	}

}
