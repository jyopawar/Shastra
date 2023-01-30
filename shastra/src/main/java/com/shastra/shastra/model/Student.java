package com.shastra.shastra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private double phone;
	private String email;

}
