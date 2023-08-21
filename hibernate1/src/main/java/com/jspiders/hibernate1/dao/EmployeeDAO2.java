package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmployeeDAO2 {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction transaction;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("employee");

		try {
			openConnection();
			EmployeeDTO employee = new EmployeeDTO();
			employee.setId(2);
			employee.setName("ms dhoni");
			employee.setEmail("mahi@gmail.com");
			employee.setContact(1234567890L);
			employee.setAddress("123 wakad Pune");
			em.persist(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private static void openConnection() {
		em = emf.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
	}

	private static void closeConnection() {
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
		if (em != null) {
			em.close();
		}
		if (emf != null) {
			emf.close();
		}
	}

}
