package com.jspiders.hibernate1.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Company {

	@Id
	private int id;
	private String name;
	private String address;
	private String email;
	@OneToMany
	private List<Employee> employees;
}
