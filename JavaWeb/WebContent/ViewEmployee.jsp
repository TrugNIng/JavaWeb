<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="controller.ViewServlet"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=ISO-8859-1">
<title>View Employee</title>
</head>
<body>
	<a href='#'>Add New Employee</a>
	<h1>Employees List</h1>
	<% 	Employee e = new Employee();
		List<Employee> list = (List<Employee>)request.getAttribute("employee");
		request.setAttribute("list",list);
	%>
	<table border='1' width='100%'> 
    	<tr>
    		 <th>Employee Id</th>
    		 <th>First Name</th>
    		 <th>Last Name</th>
    		 <th>Phone Number</th>
    		 <th>Gender</th>
    		 <th>Vehicle</th>
    		 <th>Edit</th>
    		 <th>Delete</th>
    	</tr>  
    	<c:forEach items="${list.e}" var="e">
    	<tr>
     		 <td>${e.getId()}</td>
     		 <td>${e.getfName()}></td>
     		 <td>${e.getlName()}></td>
     		 <td>${e.getPhoneNumber()}></td>
     		 <td>${e.getGender()}></td>
     		 <td>${e.getVehicle()}></td>
     		 <td><a href="#">Edit</a></td>
     		 <td><a href="#">Delete</a></td>
     	</tr> 
    	</c:forEach> 
    </table>  
</body>
</html>