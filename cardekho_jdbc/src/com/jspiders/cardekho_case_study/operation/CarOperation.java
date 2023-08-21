package com.jspiders.cardekho_case_study.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filepath = "D:/Eclipse/jdbc/resources/db_info.properties";

	private static void openconnection() {

		try {
			file = new FileInputStream(filepath);
			properties.load(file);
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (file != null) {
				file.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCarDetails() {
		try {
			openconnection();
			System.out.println("How many car details you want to add? ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			String insertQuery = "INSERT INTO car (car_id, name, brand, fuel_type, price) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			for (int i = 1; i <= choice; i++) {
				Car car = new Car();
				System.out.print("Enter car id : ");
				car.setCar_id(scanner.nextInt());
				System.out.print("Enter car name : ");
				car.setName(scanner.next());
				System.out.print("Enter car brand : ");
				car.setBrand(scanner.next());
				System.out.print("Enter car fuel type : ");
				car.setFuel_type(scanner.next());
				System.out.print("Enter car price : ");
				car.setPrice(scanner.nextDouble());
				scanner.close();
				preparedStatement.setInt(1, car.getCar_id());
				preparedStatement.setString(2, car.getName());
				preparedStatement.setString(3, car.getBrand());
				preparedStatement.setString(4, car.getFuel_type());
				preparedStatement.setDouble(5, car.getPrice());

				preparedStatement.executeUpdate();
			}

			getAllCarDetails();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			closeConnection();
		}

	}

	public void removeCarDetails() {
		try {
			openconnection();
			System.out.println("How many car you want to Delete? ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			String Deletequery = "DELETE FROM car where car_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(Deletequery);

			for (int i = 1; i <= choice; i++) {
				Car car = new Car();
				System.out.print("Enter car id : ");
				car.setCar_id(scanner.nextInt());

				scanner.close();
				preparedStatement.setInt(1, car.getCar_id());

				preparedStatement.executeUpdate();
			}
			getAllCarDetails();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			closeConnection();
		}

	}

	public void getAllCarDetails() {
		System.out.println();
		System.out.println("all car details");
		try {
			openconnection();

			String Deletequery = "SELECT * FROM car";
			PreparedStatement preparedStatement = connection.prepareStatement(Deletequery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4) + " " + resultSet.getDouble(5));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			closeConnection();
		}

	}

	public void searchByName() {
		try {
			openconnection();
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter car name: ");
				String carName = scanner.nextLine();
				String searchQuery = "SELECT * FROM car WHERE name = ?";
				preparedStatement = connection.prepareStatement(searchQuery);
				preparedStatement.setString(1, carName);
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4) + " " + resultSet.getDouble(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeConnection();
		}

	}

	public void searchByBrand() {
		try {
			openconnection();
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter car brand: ");
				String carBrand = scanner.nextLine();
				String searchQuery = "SELECT * FROM car WHERE brand = ?";
				preparedStatement = connection.prepareStatement(searchQuery);
				preparedStatement.setString(1, carBrand);
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4) + " " + resultSet.getDouble(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeConnection();
		}

	}

	public void searchByFuelType() {
		try {
			openconnection();
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter car Fuel: ");
				String carFuel = scanner.nextLine();
				String searchQuery = "SELECT * FROM car WHERE fuel_type = ?";
				preparedStatement = connection.prepareStatement(searchQuery);
				preparedStatement.setString(1, carFuel);
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4) + " " + resultSet.getDouble(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeConnection();
		}
	}

	public void editCarDetails() {
		try {
			openconnection();
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter car ID: ");
				int carId = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character

				String searchQuery = "SELECT * FROM car WHERE car_id = ?";
				preparedStatement = connection.prepareStatement(searchQuery);
				preparedStatement.setInt(1, carId);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					Car car = new Car();
					car.setCar_id(carId);
					System.out.println("Current car details:");
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getString(4) + " " + resultSet.getDouble(5));

					System.out.println("Enter new car details:");

					System.out.print("Enter new car name: ");
					String newCarName = scanner.nextLine();

					System.out.print("Enter new car brand: ");
					String newCarBrand = scanner.nextLine();

					System.out.print("Enter new fuel type: ");
					String newFuelType = scanner.nextLine();

					System.out.print("Enter new car price: ");
					double newCarPrice = scanner.nextDouble();

					car.setName(newCarName);
					car.setBrand(newCarBrand);
					car.setFuel_type(newFuelType);
					car.setPrice(newCarPrice);

					String updateQuery = "UPDATE car SET name = ?, brand = ?, fuel_type = ?, price = ? WHERE car_id = ?";
					preparedStatement = connection.prepareStatement(updateQuery);
					preparedStatement.setString(1, car.getName());
					preparedStatement.setString(2, car.getBrand());
					preparedStatement.setString(3, car.getFuel_type());
					preparedStatement.setDouble(4, car.getPrice());
					preparedStatement.setInt(5, car.getCar_id());

					int rowsAffected = preparedStatement.executeUpdate();
					if (rowsAffected > 0) {
						System.out.println("Car details updated successfully.");
					} else {
						System.out.println("No car found with the provided ID.");
					}
				} else {
					System.out.println("No car found with the provided ID.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

}
