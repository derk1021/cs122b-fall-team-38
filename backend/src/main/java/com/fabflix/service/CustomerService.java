package com.fabflix.service;

import com.fabflix.entity.Customer;
import com.fabflix.entity.Login;
import com.fabflix.exception.EntityAlreadyExistsException;
import com.fabflix.exception.InvalidCredentialsException;

public interface CustomerService {

	public Customer registerCustomer(Customer login) throws EntityAlreadyExistsException;

	public boolean loginCustomer(Login login) throws InvalidCredentialsException;

}
