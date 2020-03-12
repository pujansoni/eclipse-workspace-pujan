package com.example.demo1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.Person;
import com.example.demo1.service.PersonService;
// We can implement the http methods(get, put, post, delete) implementation in the controller. We can do that by using the @RestController annotation
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
	
	private final PersonService personService;
	
	// The @Autowired means that the spring boot injects actual service in the constructor
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	// The @RequestBody annotation shows that we convert the json body that we receive from the postman to an actual Person
	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
}
