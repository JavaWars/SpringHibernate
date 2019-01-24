package com.my.spring.service;

import java.util.List;

import com.my.spring.model.Subject;

public interface SubjectService {
	public void addSubject(Subject p);
	public void updateSubject(Subject p);
	public List<Subject> listSubjects();
	public Subject getSubjectById(int id);
	public void removeSubject(int id);
	public int getTotalSubjectCount();
}
