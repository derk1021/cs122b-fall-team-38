package com.fabflix.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "employees")
public class Employee {

	@Id
	private String email;

	@Size(max = 100)
	private String password;

	private String fullname;

}
