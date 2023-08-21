package com.jspiders.cardekho_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jspiders.cardekho_hibernate.dto.Car;

public class CarOperation {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public CarOperation() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public void addCarDetails(Car car) {
		openConnection();
		entityTransaction.begin();

		try {
			entityManager.persist(car); // Save the car entity to the database
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace(); // Handle or log the exception
		} finally {
			closeConnection();
		}
	}

	public void removeCarDetails(Car car) {
		openConnection();
		entityTransaction.begin();

		try {
			// Find the car entity by ID or other unique identifier
			Car carToRemove = entityManager.find(Car.class, car.getCar_id());

			if (carToRemove != null) {
				entityManager.remove(carToRemove);
				entityTransaction.commit();
			}
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace(); // Handle or log the exception
		} finally {
			closeConnection();
		}
	}

	public List<Car> searchByName(String name) {
		openConnection();

		try {
			// Implement a query to search for cars by name
			String queryString = "SELECT c FROM Car c WHERE c.name = :name";
			TypedQuery<Car> query = entityManager.createQuery(queryString, Car.class);
			query.setParameter("name", name);
			return query.getResultList();
		} finally {
			closeConnection();
		}
	}

	public List<Car> searchByBrand(String brand) {
		openConnection();

		try {
			// Implement a query to search for cars by brand
			String queryString = "SELECT c FROM Car c WHERE c.brand = :brand";
			TypedQuery<Car> query = entityManager.createQuery(queryString, Car.class);
			query.setParameter("brand", brand);
			return query.getResultList();
		} finally {
			closeConnection();
		}
	}

	public List<Car> searchByFuelType(String fuelType) {
		openConnection();

		try {
			// Implement a query to search for cars by fuel type
			String queryString = "SELECT c FROM Car c WHERE c.fuel_type = :fuel_type";
			TypedQuery<Car> query = entityManager.createQuery(queryString, Car.class);
			query.setParameter("fuel_type", fuelType);
			return query.getResultList();
		} finally {
			closeConnection();
		}
	}

	public List<Car> getAllCarDetails() {
		openConnection();

		try {
			// Implement a query to retrieve all car details
			String queryString = "SELECT c FROM Car c";
			TypedQuery<Car> query = entityManager.createQuery(queryString, Car.class);
			return query.getResultList();
		} finally {
			closeConnection();
		}
	}

	public void editCarDetails(Car updatedCar) {
		openConnection();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		try {
			// Retrieve the existing car entity using its ID or other identifier
			Car existingCar = entityManager.find(Car.class, updatedCar.getCar_id());

			if (existingCar != null) {
				// Update the existing car entity with new details
				existingCar.setName(updatedCar.getName());
				existingCar.setBrand(updatedCar.getBrand());
				existingCar.setFuel_type(updatedCar.getFuel_type());
				existingCar.setPrice(updatedCar.getPrice());

				entityManager.merge(existingCar);
				entityTransaction.commit();
			} else {
				System.out.println("Car not found for editing.");
			}
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace(); // Handle or log the exception
		} finally {
			closeConnection();
		}
	}

	public Car getCarById(int carId) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Car.class, carId);
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}