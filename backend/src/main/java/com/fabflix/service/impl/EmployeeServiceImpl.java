package com.fabflix.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabflix.entity.AddMovie;
import com.fabflix.entity.Database;
import com.fabflix.entity.Employee;
import com.fabflix.entity.Table;
import com.fabflix.exception.InvalidCredentialsException;
import com.fabflix.repository.EmployeeRepository;
import com.fabflix.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	StrongPasswordEncryptor encryptor;

	@Override
	public boolean loginEmployee(Employee employee) throws InvalidCredentialsException {
		Employee existingEmployee = employeeRepository.findByEmail(employee.getEmail());
		if (existingEmployee == null) {
			throw new EntityNotFoundException("Email Id does not exist. Please Register");
		}
		if (encryptor.checkPassword(employee.getPassword(), existingEmployee.getPassword())) {
			return true;
		} else {
			throw new InvalidCredentialsException();
		}
	}

	@Override
	public Database getDatabaseMetadata() {
		Database results = new Database();
		List<String> describeTables = employeeRepository.describeTables();
		describeTables.remove("hibernate_sequence");
		results.setTables(describeTables);
		results.setMovieDescription(getTableDescription(employeeRepository.describeMovies()));
		results.setStarsDescription(getTableDescription(employeeRepository.describeStars()));
		results.setStarsInMoviesDescription(getTableDescription(employeeRepository.describeStarsInMovies()));
		results.setGenresDescription(getTableDescription(employeeRepository.describeGenre()));
		results.setGenresInMoviesDescription(getTableDescription(employeeRepository.describeGenresInMovies()));
		results.setCustomersDescription(getTableDescription(employeeRepository.describeCustomers()));
		results.setSalesDescription(getTableDescription(employeeRepository.describeSales()));
		results.setCreditCardsDescription(getTableDescription(employeeRepository.describeCreditCards()));
		results.setRatingsDescription(getTableDescription(employeeRepository.describeRatings()));
		results.setEmployeesDescription(getTableDescription(employeeRepository.describeEmployees()));
		return results;
	}

	private List<Table> getTableDescription(List<Map<String, Object>> rows) {
		List<Table> tableDescription = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			Table table = new Table();
			table.setField((String) row.get("Field"));
			table.setType((String) row.get("Type"));
			table.setNullable((String) row.get("Null"));
			table.setKey((String) row.get("Key"));
			table.setDefaultValue((String) row.get("Default"));
			tableDescription.add(table);
		}
		return tableDescription;
	}

	@Override
	public String addMovie(AddMovie movie) {
		return employeeRepository.addMovie(movie.getMovieTitle(), movie.getMovieYear(), movie.getMovieDirector(),
				movie.getStarName(), movie.getGenreName());
	}

}
