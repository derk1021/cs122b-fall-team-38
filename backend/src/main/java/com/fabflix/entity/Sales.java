package com.fabflix.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
//@Entity
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	@NotNull
	private long id;

//	@NotBlank
//	@NotNull
//	@OneToOne
//	private Customer customer;
//
//	@NotBlank
//	@NotNull
//	@OneToOne
//	private Movie movie;

	@NotBlank
	@NotNull
	private Date saleDate;

}
