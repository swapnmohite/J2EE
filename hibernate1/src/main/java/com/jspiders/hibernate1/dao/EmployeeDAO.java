package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmployeeDAO {
	private static EntityManagerFactory entityManagerfactory;
	private static EntityManager entityManager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		entityManagerfactory = Persistence.createEntityManagerFactory("employee");
		entityManager = entityManagerfactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}

	private static void closeConnection() {
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerfactory != null) {
			entityManagerfactory.close();
		}
	}

	public static void main(String[] args) {

		try {
			openConnection();
			EmployeeDTO employee = new EmployeeDTO();
			employee.setId(1);
			employee.setName("John Doe");
			employee.setEmail("john.doe@example.com");
			employee.setContact(1234567890L);
			employee.setAddress("123 Main Street");
			entityManager.persist(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

}