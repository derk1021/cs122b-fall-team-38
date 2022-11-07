package com.fabflix.entity;

import lombok.Data;

@Data
public class AddMovie {

	private String movieTitle;

	private int movieYear;

	private String movieDirector;

	private String starName;

	private String genreName;
}
