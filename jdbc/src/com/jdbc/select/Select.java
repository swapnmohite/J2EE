package com.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Load or register the class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2.Enable connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "root");

		// 3. create statement
		Statement statement = connection.createStatement();

		// 4.Execute query method to fetch the data
		String query = "Select * from emp";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.print(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			System.out.println();
		}

		// 5. Close the connection
		connection.close();

	}

}