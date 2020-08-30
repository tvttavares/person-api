package com.dio.personapi.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {

	private String message;
}
