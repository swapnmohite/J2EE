package com.jspiders.hibernate1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class VotingCard {

	private String cardNumber;
	private String dateOfIssue;
	@Id
	private int id;
	@OneToOne(mappedBy = "votingCard")
	private Voter voter;

}
