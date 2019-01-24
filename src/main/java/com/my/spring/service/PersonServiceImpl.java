package com.my.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.spring.dao.interfaces.PersonDAO;
import com.my.spring.model.Person;
import com.my.spring.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.add(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.update(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.list();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.remove(id);
	}

}
