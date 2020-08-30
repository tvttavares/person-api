package com.dio.personapi.utils;

import com.dio.personapi.model.Phone;
import com.dio.personapi.model.PhoneTypeEnum;

public class PhoneUtils {

	private static final String PHONE_NUMBER = "1199999-9999";
	private static final PhoneTypeEnum PHONE_TYPE = PhoneTypeEnum.MOBILE;
	private static final long PHONE_ID = 1L;

	public static Phone createFakeEntity() {
		return Phone.builder().id(PHONE_ID).number(PHONE_NUMBER).type(PHONE_TYPE).build();
	}
}