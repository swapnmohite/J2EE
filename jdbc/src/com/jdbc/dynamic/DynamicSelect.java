package com.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DynamicSelect {
	private static Connection connection;
	private static FileInputStream file;
	private static String filepath = "D:\\Eclipse\\jdbc\\resources\\db_info.properties";
	private static PreparedStatement preparedStatement;
	private static Properties properties = new Properties();
	private static String query;
	private static ResultSet resultSet;

	public static void main(String[] args) {
		try {
			file = new FileInputStream(filepath);
			properties.load(file);
			Class.forName(properties.getProperty("driverPath"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			query = "select * from student where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out
						.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}
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
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
