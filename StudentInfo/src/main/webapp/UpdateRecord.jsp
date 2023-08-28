<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Record</title>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
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
            String updateQuery = "UPDATE studentinfo SET name=?, email=?, address=?, contact=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, address);
            preparedStatement.setLong(4, contact);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            
            response.sendRedirect("DisplayData.jsp"); // Redirect to display updated data
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</body>
</html>
