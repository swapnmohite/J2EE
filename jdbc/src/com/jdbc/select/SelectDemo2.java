package com.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo2 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String dburl = "jdbc:mysql://localhost:3306/scott?user=root&password=root";
	private static String query;
	private static String Driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		try {
			// 1.load the Driver class
			Class.forName(Driver);
			// 2. open the connection
			connection = DriverManager.getConnection(dburl);

			// 3. create the statement
			statement = connection.createStatement();
			query = "Select * from student";
			resultSet = statement.executeQuery(query);

			// 4. process the result
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			// 5. close the connection
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
