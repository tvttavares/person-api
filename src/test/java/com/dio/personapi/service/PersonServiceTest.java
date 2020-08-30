package com.dio.personapi.service;

import static com.dio.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.personapi.model.Person;
import com.dio.personapi.repository.PersonRepository;
import com.dio.personapi.response.MessageResponse;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;

	@InjectMocks
	private PersonService personService;

	@Test
	void testGivenPersonThenReturnSuccessSavedMessage() {
		Person expectedSavedPerson = createFakeEntity();

		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

		MessageResponse expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
		MessageResponse successMessage = personService.createPerson(expectedSavedPerson);

		assertEquals(expectedSuccessMessage, successMessage);
	}

	private MessageResponse createExpectedSuccessMessage(Long savedPersonId) {
		return MessageResponse.builder().message("Person successfully created with ID: " + savedPersonId).build();
	}

}