<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
StudentPOJO pojo = (StudentPOJO) request.getAttribute("student");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
margin:0;
padding:0;
box-sizing: border-box;
}
    fieldset table {
        margin: auto;
        text-align: left;
        border-collapse: collapse; /* Collapse table borders */
        width: 100%; /* Make the table fill the fieldset */
    }

    fieldset {
        margin: 15px 520px;
        text-align: center;
    }

    legend {
        color: white;
        background-color: #333;
    }

    table tr:nth-child(even) {
        background-color: #f2f2f2; /* Alternate row background color */
    }

    table th, table td {
        padding: 8px;
        border: 1px solid #ddd; /* Add borders to table cells */
        text-align: center;
    }

    table th {
        background-color: #444;
        color: white;
    }
</style>

</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Search Student Details</legend>
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SEARCH">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (pojo != null) {
		%>
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>