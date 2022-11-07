package com.fabflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabflix.entity.AddMovie;
import com.fabflix.entity.Database;
import com.fabflix.service.EmployeeService;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/database")
	public ResponseEntity<Database> getTopRatedMovies() {

		return ResponseEntity.ok(employeeService.getDatabaseMetadata());
	}

	@PostMapping("/movie")
	public ResponseEntity<String> addMovie(@RequestBody AddMovie movie) {
		return ResponseEntity.ok(employeeService.addMovie(movie));
	}

}
