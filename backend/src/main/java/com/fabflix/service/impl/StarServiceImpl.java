package com.fabflix.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabflix.entity.Movie;
import com.fabflix.entity.Stars;
import com.fabflix.repository.MovieRepository;
import com.fabflix.repository.StarRepository;
import com.fabflix.service.StarService;

@Service
public class StarServiceImpl implements StarService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	StarRepository starRepository;

	@Override
	public Stars getStarDetailsByStarId(String starId) {
		Stars star = starRepository.findById(starId).orElseThrow();
		return star;
	}

	@Override
	public Stars addStar(Stars star) {
		star.setId("nm" + starRepository.findLastId() + 1);
		return starRepository.save(star);
	}

	@Override
	public List<Movie> getMovieDetails(String starId) {
		List<Movie> movies = new ArrayList<>();
		List<Map<String, Object>> rows = starRepository.findMoviesByStarId(starId);
		for (Map<String, Object> m : rows) {
			Movie movie = new Movie();
			movie.setTitle((String) m.get("title"));
			movie.setId((String) m.get("id"));
			movies.add(movie);
		}
		return movies;
	}

}
