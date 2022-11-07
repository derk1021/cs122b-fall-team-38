package com.fabflix.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Genres {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	@NotNull
	private long id;

	@NotBlank
	@NotNull
	@Size(max = 32)
	private String name = "";

	@ManyToMany(mappedBy = "genres")
	@JsonIgnore
	private List<Movie> movies;

}
