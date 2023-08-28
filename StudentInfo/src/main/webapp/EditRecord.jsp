<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Record</title>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
        body {
            font-family: 'Inter', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #218838;
        }

        a {
            color: #007bff;
            text-decoration: none;
            margin-top: 10px;
            display: inline-block;
        }

        a:hover {
            text-decoration: underline;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
    </style>
</head>
<body>
    

    <%
        String jdbcUrl = "jdbc:mysql://localhost:3306/studentinfo";
        String dbUsername = "root";
        String dbPassword = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            int id = Integer.parseInt(request.getParameter("id"));
            String selectQuery = "SELECT * FROM studentinfo WHERE id=?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                long contact = resultSet.getLong("contact");

                %>
                <form align="center" action="UpdateRecord.jsp" method="post">
                <h1 align="center">Edit Record</h1>
                    <table align="center">
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="name" value="<%= name %>"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="email" value="<%= email %>"></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="address" value="<%= address %>"></td>
                        </tr>
                        <tr>
                            <td>Contact</td>
                            <td><input type="text" name="contact" value="<%= contact %>"></td>
                        </tr>
                    </table>
                    <input type="hidden" name="id" value="<%= id %>">
                    <button type="submit">Update</button>
                    <div align="center">
        <a href="DisplayData.jsp">Go Back</a>
    </div>
                </form>
                <%
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    
</body>
</html>