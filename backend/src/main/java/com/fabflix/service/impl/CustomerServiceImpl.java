package com.fabflix.service.impl;

import javax.persistence.EntityNotFoundException;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabflix.entity.Customer;
import com.fabflix.entity.Login;
import com.fabflix.exception.EntityAlreadyExistsException;
import com.fabflix.exception.InvalidCredentialsException;
import com.fabflix.repository.CustomerRepository;
import com.fabflix.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository dao;

	@Autowired
	StrongPasswordEncryptor encryptor;

	@Override
	public Customer registerCustomer(Customer login) throws EntityAlreadyExistsException {
		Customer existingUser = dao.findByEmail(login.getEmail());
		if (existingUser != null) {
			throw new EntityAlreadyExistsException("User");
		} else {
			login.setPassword(encryptor.encryptPassword(login.getPassword()));
			existingUser = dao.save(login);
		}
		return existingUser;
	}

	@Override
	public boolean loginCustomer(Login login) throws InvalidCredentialsException {
		Customer customer = dao.findByEmail(login.getEmail());
		System.out.println(login);
		if (customer == null) {
			throw new EntityNotFoundException("Email Id does not exist. Please Register");
		}
		if (encryptor.checkPassword(login.getPassword(), customer.getPassword())) {
			return true;
		} else {
			throw new InvalidCredentialsException();
		}
	}

}
