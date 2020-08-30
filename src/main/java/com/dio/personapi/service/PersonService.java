package com.dio.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.model.Person;
import com.dio.personapi.repository.PersonRepository;
import com.dio.personapi.response.MessageResponse;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@PostMapping
	public MessageResponse createPerson(Person personToSave) {
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponse.builder().message("Created person with ID: " + savedPerson.getId()).build();

	}

	public List<Person> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream().collect(Collectors.toList());
	}

	public Person findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return person;
	}

	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepository.deleteById(id);
	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
}
