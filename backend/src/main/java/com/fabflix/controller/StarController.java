package com.fabflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabflix.entity.Movie;
import com.fabflix.entity.Stars;
import com.fabflix.service.StarService;

@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class StarController {

	@Autowired
	StarService starService;

	@GetMapping("/star/{starId}")
	public ResponseEntity<Stars> getStarDetails(@PathVariable(name = "starId") String starId) {
		return ResponseEntity.ok(starService.getStarDetailsByStarId(starId));
	}

	@GetMapping("/star/{starId}/movie")
	public ResponseEntity<List<Movie>> getMovieDetails(@PathVariable(name = "starId") String starId) {
		return ResponseEntity.ok(starService.getMovieDetails(starId));
	}

	@PostMapping("/star")
	public ResponseEntity<Stars> addNewStar(@RequestBody Stars star) {
		return ResponseEntity.ok(starService.addStar(star));
	}
}
