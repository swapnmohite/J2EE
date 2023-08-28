<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*" %>
<jsp:include page="StudentInfo.html"></jsp:include>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    long contact = Long.parseLong(request.getParameter("contact"));
    String jdbcUrl = "jdbc:mysql://localhost:3306/studentinfo";
    String dbUsername = "root";
    String dbPassword = "root";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
        String insertQuery = "INSERT INTO studentinfo (name, email, address, contact) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, address);
        preparedStatement.setLong(4, contact);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Data Saved</title>
</head>
<body>
<br>
    <h1 align="center">Data Saved to Database</h1>
</body>
</html>
