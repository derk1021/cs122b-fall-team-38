package com.fabflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@NotBlank
	@Size(max = 50)
	private String firstName = "";

	@NotNull
	@NotBlank
	@Size(max = 50)
	private String lastName = "";;

//	@OneToOne
//	@NotNull
//	private CreditCard cc = new CreditCard();

	@NotNull
	@Size(max = 200)
	private String address = "";

	@Column(unique = true)
	@NotNull
	@NotBlank
	@Email
	@Size(max = 50)
	private String email = "";

	@NotNull
	@NotBlank
	private String password;

}
