package com.jspiders.hibernate1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Aadharcard {

	@Id
	private int id;
	private long aadharnumber;
	private String dateofissue;

}
