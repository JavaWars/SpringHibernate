package com.my.spring.dao.interfaces;

import java.util.List;

import com.my.spring.model.Person;

public interface PersonDAO {
	
	public void add(Person p);
	public void update(Person p);
	public List<Person> list();
	public Person getById(int id);
	public void remove(int id);
}
