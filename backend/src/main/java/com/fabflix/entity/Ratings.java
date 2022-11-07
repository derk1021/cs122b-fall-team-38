package com.fabflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Ratings {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@NotBlank
//	@NotNull
//	private long Id;

	@NotBlank
	@NotNull
	@Column(name = "movieId")
	@Id
	private String movieId;

	@NotBlank
	@NotNull
	private float rating;

	@NotBlank
	@NotNull
	private int numVotes;

}
