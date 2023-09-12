<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display Data</title>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
        body {
             font-family: 'Inter', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            
        }

        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
            background-color: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .delete-btn {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 5px  10px;
            border-radius: 4px;
            cursor: pointer;            
        }

        .delete-btn:hover {
            background-color: #c82333;
        }

        .center {
            text-align: center;
            display : flex;
            justify-content: space-evenly;
            align-items: center;
        } 
        .edit-btn {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 4px;
            cursor: pointer;
        }

        .edit-btn:hover {
            background-color: #218838;
        }
        .back a{
        text-decoration: none;
        }
    </style>
</head>
<body>
    <h1 align="center">Display Data</h1>
    <table align="center" border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Contact</th>
            <th>Actions</th> <!-- New column for buttons -->
        </tr>

        <%
            String jdbcUrl = "jdbc:mysql://localhost:3306/studentinfo";
            String dbUsername = "root";
            String dbPassword = "root";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                String selectQuery = "SELECT * FROM studentinfo";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    long contact = resultSet.getLong("contact");

                    %>
                    <tr>
                        <td><%= name %></td>
                        <td><%= email %></td>
                        <td><%= address %></td>
                        <td><%= contact %></td>
                        <td class="center">
                            <form action="EditRecord.jsp" method="post">
                                <input type="hidden" name="id" value="<%= id %>">
                                <button class="edit-btn" type="submit">Edit</button>
                            </form>
                            <form action="DeleteRecord.jsp" method="post">
                                <input type="hidden" name="id" value="<%= id %>">
                                <button class="delete-btn" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <%
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
    <div class="back" align="center">
        <a href="StudentInfo.html">Go Back</a>
    </div>
</body>
</html>