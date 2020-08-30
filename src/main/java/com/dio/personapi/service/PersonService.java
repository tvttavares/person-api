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

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

 	private PersonRepository personRepository;

	@PostMapping
	public MessageResponse createPerson(Person personToSave) {
		Person savedPerson = personRepository.save(personToSave);
		return createMessageResponse(savedPerson.getId(), "Created person with ID: ");
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

	public MessageResponse updatePerson(Long id, Person person) throws PersonNotFoundException {
		verifyIfExists(id);
		Person updatedPerson = personRepository.save(person);
		return createMessageResponse(updatedPerson.getId(), "Updated person with ID: ");
	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

	private MessageResponse createMessageResponse(Long id, String message) {
		return MessageResponse.builder().message(message + id).build();
	}
}
