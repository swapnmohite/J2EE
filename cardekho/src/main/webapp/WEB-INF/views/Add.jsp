<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% String msg=(String) request.getAttribute("msg"); %>
<jsp:include page="NavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Car Details</title>
    <style type="text/css">
        
        

        h1 {
            text-align: center;
            color: #333;
        }

        fieldset {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 5px;
            background-color: #f9f9f9;
            width: 400px;
        }

        legend {
            color: #fff;
            background-color: #333;
            padding: 5px 10px;
            border-radius: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table tr {
            border-bottom: 1px solid #ddd;
        }

        table td {
            padding: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #555;
        }

        /* Custom styling for the container and text inputs */
        .container {
            background-color: #f7f7f7;
            border: 2px solid #333;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        input[type="text"] {
            background-color: #f9f9f9;
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    
        <fieldset>
            <legend>Add Car Details</legend>
            <form action="" method="post">
                <table>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Brand</td>
                        <td><input type="text" name="brand"></td>
                    </tr>
                    <tr>
                        <td>Fuel Type</td>
                        <td><input type="text" name="fuel"></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="price"></td>
                    </tr>
                </table>
                <input type="submit" value="ADD">
            </form>
        </fieldset>
        <%
        if (msg != null) {
        %>
        <h1><%=msg%></h1>
        <%
        }
        %>
   
</body>
</html>
