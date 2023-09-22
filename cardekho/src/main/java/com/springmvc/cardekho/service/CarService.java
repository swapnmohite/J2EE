package com.springmvc.cardekho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.cardekho.pojo.CarPOJO;
import com.springmvc.cardekho.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(String name, String brand, String fuel, long price) {
		CarPOJO pojo = new CarPOJO(); // Create a new CarPOJO and set its properties
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setFuel(fuel);
		pojo.setPrice(price);

		// Call the repository to save the car
		CarPOJO savedCar = repository.addCar(pojo);
		return savedCar;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO car = repository.searchCar(id);
		return car;
	}

	public List<CarPOJO> findAllCars() {
		List<CarPOJO> cars = repository.findAllCars();
		return cars;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO car = repository.removeCar(id);
		return car;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuel, long price) {
		CarPOJO existingCar = repository.searchCar(id);

		if (existingCar != null) {
			// Update the existing car's properties
			existingCar.setName(name);
			existingCar.setBrand(brand);
			existingCar.setFuel(fuel);
			existingCar.setPrice(price);

			// Save the updated car
			CarPOJO updatedCar = repository.updateCar(existingCar);
			return updatedCar;
		}

		return null; // Car with the given id does not exist
	}
}
