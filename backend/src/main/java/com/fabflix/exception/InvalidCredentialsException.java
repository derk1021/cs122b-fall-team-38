package com.fabflix.exception;

import org.springframework.stereotype.Service;

@Service
public class InvalidCredentialsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
		super("Wrong email Or Password");
    }
}
