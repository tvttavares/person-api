package com.dio.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.personapi.dto.response.MessageResponseDTO;
import com.dio.personapi.model.Person;
import com.dio.personapi.service.PersonService;

@RestController
@RequestMapping("/api/people")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public String getPerson() {
		return "API Test";
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
}
