<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login page</title>
	<script language="text/javaScript" src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body>
	<form action="LoginServlet" name="fields" method="POST">

			Username 		
			<input type="text" id="username" name="username"/><br>				
			Password
			<input type="text" name="password"/><br>
			<input type="checkbox" name="persist"> Remember me <br>
			<input type="submit" value="Submit">			
	</form>
</body>
</html>