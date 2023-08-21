package com.jdbc.operations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class OperationsDemo1 {
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static FileInputStream file;
	private static Properties properties = new Properties();
	private static String filepath = "D:\\Eclipse\\jdbc\\resources\\db_info.properties";
	private static String query;

	public static void main(String[] args) {

		// 1. create a table
		try {
			openConnection();
			query = "CREATE TABLE stud_details (id INT(4) PRIMARY KEY, name VARCHAR(40), email VARCHAR(40), contact VARCHAR(10))";
			result = statement.executeUpdate(query);
			System.out.println("Query executed successfully. Rows affected: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		// 2. insert 5 records
		try {
			openConnection();
			try (Scanner scanner = new Scanner(System.in)) {
				for (int i = 1; i <= 5; i++) {
					System.out.println("Enter details for Record ");
					System.out.print("Enter ID: ");
					int id = scanner.nextInt();
					scanner.nextLine(); // Consume the newline left by nextInt()

					System.out.print("Enter Name: ");
					String name = scanner.nextLine();

					System.out.print("Enter Email: ");
					String email = scanner.nextLine();

					System.out.print("Enter Contact: ");
					String contact = scanner.nextLine();

					// Create the query to insert the record
					query = "INSERT INTO stud_details (id, name, email, contact) VALUES (" + id + ", '" + name + "', '"
							+ email + "', '" + contact + "')";

					result = statement.executeUpdate(query);

					System.out.println("Record " + i + " inserted successfully.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeConnection();
		}

		// 3.// Display the inserted data
		try

		{
			openConnection();

			query = "SELECT * FROM stud_details";
			ResultSet resultSet = statement.executeQuery(query);

			System.out.println("\nInserted Data:");
			System.out.println("ID\tName\tEmail\tContact");
			System.out.println("----------------------------------------");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String contact = resultSet.getString("contact");
				System.out.println(id + "\t" + name + "\t" + email + "\t" + contact);
			}

			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private static void openConnection() {
		try {
			file = new FileInputStream(filepath);
			properties.load(file); // Load the properties from the file
			Class.forName(properties.getProperty("driverPath"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			statement = connection.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}

			if (file != null) {
				file.close();
			}
			if (result != 0) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
