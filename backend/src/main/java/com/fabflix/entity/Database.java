package com.fabflix.entity;

import java.util.List;

import lombok.Data;

@Data
public class Database {

	private List<String> tables;

	private List<Table> movieDescription;

	private List<Table> starsDescription;

	private List<Table> starsInMoviesDescription;

	private List<Table> genresDescription;

	private List<Table> genresInMoviesDescription;

	private List<Table> customersDescription;

	private List<Table> salesDescription;

	private List<Table> creditCardsDescription;

	private List<Table> ratingsDescription;

	private List<Table> employeesDescription;

}
