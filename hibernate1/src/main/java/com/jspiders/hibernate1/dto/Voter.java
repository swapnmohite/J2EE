package com.jspiders.hibernate1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Voter {
	private String address;
	@Id
	private int id;
	private String name;
	@OneToOne
	@JoinColumn
	private VotingCard votingCard;

}
