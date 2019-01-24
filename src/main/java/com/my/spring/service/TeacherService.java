package com.my.spring.service;

import java.util.List;

import com.my.spring.model.Subject;
import com.my.spring.model.Teacher;

public interface TeacherService {

	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
	public List<Teacher> listTeacher();
	public Teacher getTeacherById(int id);
	public void removeTeacher(int id);
	public int getTeachersCount();
	public int getTeachersForSubject(Subject subject);
	
}
