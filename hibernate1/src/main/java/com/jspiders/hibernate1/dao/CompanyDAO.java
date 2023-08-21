package com.jspiders.hibernate1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.Company;
import com.jspiders.hibernate1.dto.Employee;

public class CompanyDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openconnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("company");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
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
		entityTransaction.begin();

		Company company = new Company();
		company.setId(1);
		company.setName("Infosys");
		company.setAddress("Pune");
		company.setEmail("infosys@infosys.com");

		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Ramesh");
		emp1.setEmail("ramesh@infosys.com");
		emp1.setSalery(35000.00);

		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Suresh");
		emp2.setEmail("suresh@infosys.com");
		emp2.setSalery(30000.00);

		Employee emp3 = new Employee();
		emp3.setId(3);
		emp3.setName("mahesh");
		emp3.setEmail("Mahesh@infosys.com");
		emp3.setSalery(25000.00);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);

		company.setEmployees(employees);

		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(emp3);
		entityManager.persist(company);

		entityManager.persist(company);

		entityTransaction.commit();
		closeConnection();
	}

}
