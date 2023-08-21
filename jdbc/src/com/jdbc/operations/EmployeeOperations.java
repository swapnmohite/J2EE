package com.jdbc.operations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class EmployeeOperations {

	private static Connection connection;
	private static Statement statement;
	private static String query;
	private static FileInputStream file;
	private static Properties properties = new Properties();
	private static String filepath = "D:\\Eclipse\\jdbc\\resources\\db_info.properties";

	public static void main(String[] args) {

		try {
			openConnection();

			// 1. Create 'emp_details' table
			query = "CREATE TABLE emp_details (empno INT(4) PRIMARY KEY, ename VARCHAR(40) NOT NULL, job VARCHAR(30), mgr INT(4), hiredate DATE NOT NULL, sal DECIMAL(10,2) NOT NULL, comm DECIMAL(10,2))";
			statement.executeUpdate(query);
			System.out.println("Table 'emp_details' created successfully.");

			// 2. Insert 14 records
			query = "INSERT INTO emp_details (empno, ename, job, mgr, hiredate, sal) VALUES "
					+ "(101, 'John', 'Manager', 100, '2023-01-10', 5000.00), "
					+ "(102, 'Alice', 'Developer', 101, '2023-02-15', 4500.00), "
					+ "(103, 'Bob', 'Designer', 101, '2023-03-20', 4000.00), "
					+ "(104, 'Eva', 'Analyst', 102, '2023-04-25', 3800.00), "
					+ "(105, 'Mike', 'Developer', 102, '2023-05-01', 4200.00), "
					+ "(106, 'Sarah', 'Manager', NULL, '2023-06-10', 5500.00), "
					+ "(107, 'David', 'Designer', 101, '2023-07-15', 4100.00), "
					+ "(108, 'Karen', 'Analyst', 103, '2023-08-20', 3900.00), "
					+ "(109, 'Chris', 'Developer', 103, '2023-09-25', 4300.00), "
					+ "(110, 'Emily', 'Designer', NULL, '2023-10-01', 4000.00), "
					+ "(111, 'Paul', 'Manager', 102, '2023-11-10', 5200.00), "
					+ "(112, 'Julia', 'Developer', 106, '2023-12-15', 4600.00), "
					+ "(113, 'Tom', 'Analyst', 106, '2024-01-20', 4000.00), "
					+ "(114, 'Linda', 'Designer', 106, '2024-02-25', 4100.00)";
			statement.executeUpdate(query);
			System.out.println("14 records inserted successfully.");

			// 3. Display all 14 records
			displayRecords();

			// 4. Update 2 records
			query = "UPDATE emp_details SET sal = 4800.00 WHERE empno = 102";
			statement.executeUpdate(query);
			query = "UPDATE emp_details SET job = 'Senior Developer' WHERE empno = 106";
			statement.executeUpdate(query);
			System.out.println("2 records updated successfully.");

			// 5. Display all 14 records
			displayRecords();

			// 6. Delete 3 records
			query = "DELETE FROM emp_details WHERE empno = 110 OR empno = 113 OR empno = 114";
			statement.executeUpdate(query);
			System.out.println("3 records deleted successfully.");

			// 7. Display all 11 records
			displayRecords();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private static void openConnection() {

		try {
			file = new FileInputStream(filepath);
			properties.load(file);

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void displayRecords() {
		try {
			query = "SELECT * FROM emp_details";
			ResultSet resultSet = statement.executeQuery(query);

			System.out.println("\nDisplaying Records:");
			System.out.println("empno\tename\tjob\tmgr\thiredate\tsal\tcomm");
			System.out.println("---------------------------------------------------------");
			while (resultSet.next()) {
				int empno = resultSet.getInt("empno");
				String ename = resultSet.getString("ename");
				String job = resultSet.getString("job");
				int mgr = resultSet.getInt("mgr");
				Date hiredate = resultSet.getDate("hiredate");
				double sal = resultSet.getDouble("sal");
				double comm = resultSet.getDouble("comm");
				System.out.println(
						empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t" + comm);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
