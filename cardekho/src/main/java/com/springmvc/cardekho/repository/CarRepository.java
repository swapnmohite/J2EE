package com.springmvc.cardekho.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springmvc.cardekho.pojo.CarPOJO;

@Repository
public class CarRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("cardekho");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (manager != null) {
			manager.close();
		}
		if (factory != null) {
			factory.close();
		}
	}

	public CarPOJO addCar(CarPOJO car) {
		openConnection();
		transaction.begin();

		manager.persist(car);

		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPOJO searchCar(int id) {
		openConnection();
		transaction.begin();

		CarPOJO car = manager.find(CarPOJO.class, id);

		transaction.commit();
		closeConnection();
		return car;
	}

	public List<CarPOJO> findAllCars() {
		openConnection();
		transaction.begin();
		String jpql = "from CarPOJO";
		query = manager.createQuery(jpql);
		List<CarPOJO> cars = query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}

	public CarPOJO removeCar(int id) {
		openConnection();
		transaction.begin();

		CarPOJO car = manager.find(CarPOJO.class, id);
		if (car != null) {
			manager.remove(car);
		}

		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPOJO updateCar(CarPOJO car) {
		openConnection();
		transaction.begin();

		car = manager.merge(car);

		transaction.commit();
		closeConnection();
		return car;
	}
}
