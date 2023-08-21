package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.Aadharcard;
import com.jspiders.hibernate1.dto.Person;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entitytransaction;

	private static void openconnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("person");
		entityManager = entityManagerFactory.createEntityManager();
		entitytransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entitytransaction != null) {
			if (entitytransaction.isActive()) {
				entitytransaction.rollback();
			}
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

	public static void main(String[] args) {
		openconnection();
		entitytransaction.begin();

		Person person = new Person();
		person.setId(1);
		person.setName("Rahil");
		person.setEmail("rahul123@gmail.com");

		Aadharcard aadharcard = new Aadharcard();
		aadharcard.setId(1);
		aadharcard.setAadharnumber(295140623282L);
		aadharcard.setDateofissue("07082023");

		person.setAadharcard(aadharcard);

		// Persisting the objects
		entityManager.persist(person);
		entityManager.persist(aadharcard);

		entitytransaction.commit();
		closeConnection();
	}
}
