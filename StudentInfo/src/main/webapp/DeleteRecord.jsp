<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*" %>

<%
    int idToDelete = Integer.parseInt(request.getParameter("id"));
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/studentinfo";
    String dbUsername = "root";
    String dbPassword = "root";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
        String deleteQuery = "DELETE FROM studentinfo WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, idToDelete);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        response.sendRedirect("DisplayData.jsp"); // Redirect back to the display page
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
