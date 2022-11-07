package com.fabflix.entity;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {

	private HttpStatus httpStatus;
	private String errorMessage;
	private List<String> errors;

}
