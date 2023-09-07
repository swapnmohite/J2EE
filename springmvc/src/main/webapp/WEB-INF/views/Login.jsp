<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
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
}

fieldset {
	/*margin: 15px 520px;*/
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}
</style>
</head>
<body>

	<div align="center">
	<%
		if (msg != null) {
		%>
		<h4>
			<%=msg%>
		</h4>
		<%
		}
		%>
		<fieldset>
			<legend>Login Page</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="LOGIN">
			</form>

		</fieldset>
		<a href="http://localhost:8080/springmvc/createAccount">Create
			Account</a>
	</div>

</body>
</html>