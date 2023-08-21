package com.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo3 {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverpath = "com.mysql.cj.jdbc.Driver";
	private static String dburl = "jdbc:mysql://localhost:3306/scott";
	private static String user = "root";
	private static String password = "root";
	private static String query;

	public static void main(String[] args) {
		try {

			// 1.Load the driver
			Class.forName(driverpath);

			// 2.open the connection
			connection = DriverManager.getConnection(dburl, user, password);

			// 3.create the statement
			statement = connection.createStatement();
			query = "select * from student";
			resultSet = statement.executeQuery(query);

			// 4. process the result set
			while (resultSet.next()) {
				System.out
						.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5.close the connection
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
