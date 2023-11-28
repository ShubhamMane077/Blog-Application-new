package com.excelar.blog.payloads;

import lombok.Data;

@Data
public class ApiResponse {

	private String message;
	private boolean success;
}
