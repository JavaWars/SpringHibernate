package com.my.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.spring.dao.interfaces.TeacherDAO;
import com.my.spring.model.Subject;
import com.my.spring.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherDAO teacherDAO;

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	@Transactional
	public void addTeacher(Teacher teacher) {
		teacherDAO.add(teacher);
	}

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		teacherDAO.update(teacher);
	}

	@Override
	@Transactional
	public List<Teacher> listTeacher() {
		return teacherDAO.list();
	}

	@Override
	@Transactional
	public Teacher getTeacherById(int id) {
		return teacherDAO.getById(id);
	}

	@Override
	@Transactional
	public void removeTeacher(int id) {
		teacherDAO.remove(id);
	}

	@Override
	@Transactional
	public int getTeachersCount() {
		return 0;
	}

	@Override
	@Transactional
	public int getTeachersForSubject(Subject subject) {
		return 0;
	}

}
