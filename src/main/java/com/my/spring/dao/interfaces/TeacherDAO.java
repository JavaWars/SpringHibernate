package com.my.spring.dao.interfaces;

import java.util.List;

import com.my.spring.model.Teacher;

public interface TeacherDAO  {
	public void add(Teacher element);
	public void update(Teacher element);
	public List<Teacher> list();
	public Teacher getById(int id);
	public void remove(int id);
}
