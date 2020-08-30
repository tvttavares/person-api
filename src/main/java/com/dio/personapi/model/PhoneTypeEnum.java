package com.dio.personapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneTypeEnum {

	HOME("Home"), MOBILE("Mobile"), COMMECRIAL("Commercial");

	private final String description;
}
