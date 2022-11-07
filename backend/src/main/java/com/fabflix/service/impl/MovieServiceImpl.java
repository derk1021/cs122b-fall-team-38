package com.fabflix.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fabflix.entity.Movie;
import com.fabflix.entity.Ratings;
import com.fabflix.repository.MovieRepository;
import com.fabflix.repository.RatingRepository;
import com.fabflix.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public List<Movie> getTopRatedMovies() {

		List<Movie> movies = new ArrayList<>();
		Page<Ratings> topRated = ratingRepository
				.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "rating")));
		for (Ratings i : topRated.getContent()) {
			Optional<Movie> movie = movieRepository.findById(i.getMovieId());
			if (movie.isPresent()) {
				movie.get().setRating(i.getRating());
				movies.add(movie.get());
			}
		}
		return movies;
	}

	@Override
	public Movie getMovieDetails(String movieId) {
		Optional<Movie> movie = movieRepository.findById(movieId);
		if (movie.isEmpty()) {
			throw new EntityNotFoundException("Movie Not Found");
		}
		Movie result = movie.get();
		Optional<Ratings> rating = ratingRepository.findById(result.getId());
		if (rating.isPresent()) {
			result.setRating(rating.get().getRating());
		}

		return result;
	}

}
