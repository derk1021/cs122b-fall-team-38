package com.fabflix.service;

import java.util.List;

import com.fabflix.entity.Movie;

public interface MovieService {

	public List<Movie> getTopRatedMovies();

	public Movie getMovieDetails(String movieId);


}
