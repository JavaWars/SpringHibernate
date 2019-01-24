package com.my.spring.dao.interfaces;

import java.util.List;

import com.my.spring.model.Subject;

public interface SubjectDAO{
	public void add(Subject subject);
	public void update(Subject subject);
	public List<Subject> list();
	public Subject getById(int id);
	public void remove(int id);
}
