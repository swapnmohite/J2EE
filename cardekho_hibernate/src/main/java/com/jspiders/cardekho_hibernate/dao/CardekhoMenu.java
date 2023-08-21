package com.jspiders.cardekho_hibernate.dao;

import java.util.List;
import java.util.Scanner;

import com.jspiders.cardekho_hibernate.dto.Car;

public class CardekhoMenu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CarOperation operation = new CarOperation();

		while (true) {
			displayMenu();
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Car newCar = gatherCarDetails(scanner);
				operation.addCarDetails(newCar);
				break;

			case 2:
				Car carToRemove = gatherCarDetails(scanner);
				operation.removeCarDetails(carToRemove);
				break;

			case 3:
				System.out.print("Enter car name to search: ");
				String searchName = scanner.next();
				List<Car> carsByName = operation.searchByName(searchName);
				displayAllCars(carsByName);
				break;

			case 4:
				System.out.print("Enter car brand to search: ");
				String searchBrand = scanner.next();
				List<Car> carsByBrand = operation.searchByBrand(searchBrand);
				displayAllCars(carsByBrand);
				break;

			case 5:
				System.out.print("Enter fuel type to search: ");
				String searchFuelType = scanner.next();
				List<Car> carsByFuelType = operation.searchByFuelType(searchFuelType);
				displayAllCars(carsByFuelType);
				break;

			case 6:
				List<Car> allCars = operation.getAllCarDetails();
				displayAllCars(allCars);
				break;

			case 7:
				System.out.println("Enter the ID of the car you want to edit: ");
				int carIdToEdit = scanner.nextInt();

				Car carToEdit = operation.getCarById(carIdToEdit);

				if (carToEdit != null) {
					Car updatedCarDetails = gatherCarDetails(scanner); // Gather updated details
					carToEdit.setName(updatedCarDetails.getName());
					carToEdit.setBrand(updatedCarDetails.getBrand());
					carToEdit.setFuel_type(updatedCarDetails.getFuel_type());
					carToEdit.setPrice(updatedCarDetails.getPrice());

					operation.editCarDetails(carToEdit); // Call the editCarDetails method
				} else {
					System.out.println("Car not found for editing.");
				}
				break;

			case 8:
				System.out.println("Thank you..!!");
				scanner.close();
				return;

			default:
				System.out.println("\nInvalid choice. Try again..!!");
				break;
			}
		}
	}

	private static void displayMenu() {
		System.out.println("===========MENU==========");
		System.out.println("1. Add Car Details");
		System.out.println("2. Remove Car Details");
		System.out.println("3. Search Car By Name");
		System.out.println("4. Search Car By Brand");
		System.out.println("5. Search Car By Fuel Type");
		System.out.println("6. Search All Cars");
		System.out.println("7. Edit Car Details");
		System.out.println("8. Exit");
		System.out.print("\nEnter your choice : ");
	}

	private static Car gatherCarDetails(Scanner scanner) {
		Car car = new Car();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter car name: ");
		car.setName(scanner.nextLine());

		System.out.print("Enter car brand: ");
		car.setBrand(scanner.nextLine());

		System.out.print("Enter fuel type: ");
		car.setFuel_type(scanner.nextLine());

		System.out.print("Enter car price: ");
		car.setPrice(scanner.nextDouble());

		return car;
	}

	private static void displayAllCars(List<Car> cars) {
		System.out.println("========All Cars========");
		for (Car car : cars) {
			System.out.println(car);
		}
	}
}
