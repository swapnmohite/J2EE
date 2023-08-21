package com.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DynamicUpdate {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filepath = "D:\\Eclipse\\jdbc\\resources\\db_info.properties";
	private static String query;

	public static void main(String[] args) {
		try {
			file = new FileInputStream(filepath);
			properties.load(file);
			Class.forName(properties.getProperty("driverPath"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			query = "UPDATE stud_details SET email = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(2, 6);
			preparedStatement.setString(1, "pawan123@gmail.com");
			result = preparedStatement.executeUpdate();
			System.out.println("row's affected " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (file != null) {
					file.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
