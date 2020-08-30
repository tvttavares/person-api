package com.dio.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.dio.personapi.model.Person;

public class PersonUtils {

	private static final String FIRST_NAME = "Thiago";
	private static final String LAST_NAME = "Tavares";
	private static final String CPF_NUMBER = "123.321.654-89";
	private static final long PERSON_ID = 1L;
	public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

	public static Person createFakeEntity() {
		return Person.builder().id(PERSON_ID).firstName(FIRST_NAME).lastName(LAST_NAME).cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE).phones(Collections.singletonList(PhoneUtils.createFakeEntity())).build();
	}

}
