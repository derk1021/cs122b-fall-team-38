package com.fabflix.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fabflix.entity.ApiError;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = EntityAlreadyExistsException.class)
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException exception) {
		return new ResponseEntity<Object>(new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage(), null),
                HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<Object> usernameNotFoundException(EntityNotFoundException exception) {
        return new ResponseEntity<Object>(
				new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), Arrays.asList("Entity NotFound !!!")),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> HttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException exception) {
		return new ResponseEntity<Object>(new ApiError(HttpStatus.METHOD_NOT_ALLOWED,
                exception.getMessage() + " Allowed Methods are : " + Arrays.asList(exception.getSupportedMethods()),
                null), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<Object> InvalidCredentialsException(InvalidCredentialsException exception) {
		return new ResponseEntity<Object>(new ApiError(HttpStatus.UNAUTHORIZED, exception.getMessage(),
                Arrays.asList("Wrong UserName or Password !!!")), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ TransactionSystemException.class })
    protected ResponseEntity<Object> handlePersistenceException(final Exception ex, final WebRequest request) {
        Throwable cause = ((TransactionSystemException) ex).getRootCause();
        if (cause instanceof ConstraintViolationException) {

            ConstraintViolationException consEx = (ConstraintViolationException) cause;
            final List<String> errors = new ArrayList<String>();
            for (final ConstraintViolation<?> violation : consEx.getConstraintViolations()) {
                errors.add(violation.getPropertyPath() + ": " + violation.getMessage());
            }

            final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, consEx.getLocalizedMessage(), errors);
            return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getHttpStatus());
        }
        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(),
                Arrays.asList("error occurred"));
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getHttpStatus());
    }
}
