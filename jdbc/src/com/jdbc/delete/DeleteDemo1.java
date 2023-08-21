package com.jdbc.delete;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DeleteDemo1 {

	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filepath = "D:\\Eclipse\\jdbc\\resources\\db_info.properties";
	private static String query;

	public static void main(String[] args) {
		try {
			file = new FileInputStream(filepath);
			properties.load(file);
			// 1. Load the driver
			Class.forName(properties.getProperty("driverPath"));
			// 2.open the connection
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			// 3. create statement
			statement = connection.createStatement();
			query = "DELETE from student  WHERE Id = 3";
			result = statement.executeUpdate(query);
			if (result != 0) {
				System.out.println(result + "row's affected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
