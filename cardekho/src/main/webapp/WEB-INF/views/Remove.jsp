<%@page import="com.springmvc.cardekho.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
List<CarPOJO> students = (List<CarPOJO>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


fieldset table {
	margin: auto;
	text-align: left;
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
			<legend>Remove car Details</legend>
			<form action="./remove" method="post">
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="REMOVE" >
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (students != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>BRAND</th>
				<th>FUEL</th>
				<th>PRICE</th>
			</tr>
			<%
			for (CarPOJO pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getBrand() %></td>
				<td><%=pojo.getFuel() %></td>
				<td><%=pojo.getPrice() %></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>