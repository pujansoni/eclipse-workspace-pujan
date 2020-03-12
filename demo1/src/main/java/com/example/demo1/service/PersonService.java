package com.example.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo1.dao.PersonDao;
import com.example.demo1.model.Person;

@Service
public class PersonService {
	
	private final PersonDao personDao;
	
	// The @Autowired means that we are injecting in actual constructor. It means we are autowiring in the PersonDao interface
	// We have multiple implementation of the PersonDao interface. So to distinguish between them we use the @Qualifier
	@Autowired
	public PersonService(@Qualifier("fake") PersonDao personDao) {
		this.personDao = personDao;
	}
	
	// Here we have the option of providing the id or not
	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
}
