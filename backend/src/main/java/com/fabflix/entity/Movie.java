package com.fabflix.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "movies")
public class Movie {

	@Id
	@NotBlank
	@NotNull
	private String id = "";
	
	@NotBlank
	@NotNull
	@Size(max = 100)
	private String title = "";
	
	@NotBlank
	@NotNull
	private int year;

	@NotBlank
	@NotNull
	@Size(max = 100)
	private String director = "";
	
	private float rating = 0;

	@ManyToMany
	@JoinTable(name = "genres_in_movies", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genres> genres;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "stars_in_movies", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "star_id"))
	private List<Stars> stars;
}

