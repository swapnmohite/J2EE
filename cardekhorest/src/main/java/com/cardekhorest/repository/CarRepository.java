package com.cardekhorest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cardekhorest.pojo.CarPOJO;

@Repository
@Transactional
public class CarRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	public CarPOJO addCar(CarPOJO pojo) {
		openConnection();
		try {
			transaction.begin();
			manager.persist(pojo);
			transaction.commit();
			return pojo;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace(); // Handle the exception properly in your application
			return null;
		} finally {
			closeConnection();
		}
	}

	public CarPOJO searchCar(int id) {
		openConnection();
		try {
			return manager.find(CarPOJO.class, id);
		} finally {
			closeConnection();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CarPOJO> searchAllCars() {
		openConnection();
		try {
			String jpql = "SELECT c FROM CarPOJO c";
			query = manager.createQuery(jpql, CarPOJO.class);
			return query.getResultList();
		} finally {
			closeConnection();
		}
	}

	public CarPOJO removeCar(int id) {
		openConnection();
		try {
			CarPOJO carToRemove = manager.find(CarPOJO.class, id);
			if (carToRemove != null) {
				transaction.begin();
				manager.remove(carToRemove);
				transaction.commit();
			}
			return carToRemove;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace(); // Handle the exception properly in your application
			return null;
		} finally {
			closeConnection();
		}
	}

	public CarPOJO updateCar(CarPOJO pojo) {
		openConnection();
		try {
			transaction.begin();
			manager.merge(pojo);
			transaction.commit();
			return pojo;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace(); // Handle the exception properly in your application
			return null;
		} finally {
			closeConnection();
		}
	}

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("REST");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
}
