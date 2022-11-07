package com.fabflix.service;

import com.fabflix.entity.AddMovie;
import com.fabflix.entity.Database;
import com.fabflix.entity.Employee;
import com.fabflix.exception.InvalidCredentialsException;

public interface EmployeeService {

	boolean loginEmployee(Employee employee) throws InvalidCredentialsException;

	Database getDatabaseMetadata();

	String addMovie(AddMovie movie);

}
