package com.jspiders.hibernate1.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "school_info")
public class School {

	@Column(name = "school_address")
	private String address;
	@Id
	@Column(name = "school_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "school_name")
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Student> students;
}
