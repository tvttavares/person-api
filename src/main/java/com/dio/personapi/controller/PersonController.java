package com.dio.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.model.Person;
import com.dio.personapi.response.MessageResponse;
import com.dio.personapi.service.PersonService;

@RestController
@RequestMapping("/api/people")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Person> listAll() {
		return personService.listAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponse createPerson(@RequestBody @Valid Person person) {
		return personService.createPerson(person);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Person listAll(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		personService.delete(id);
	}
}
