<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Form</title>
		<link rel="stylesheet" type="text/css" href="../HTMLProject/css/style.css">
		<script language="JavaScript" src="../HTMLProject/js/script.js"></script>
	</head>
	<body>
		<% String flag = request.getParameter("flag"); %>
		<form action="InsertServlet" method="POST" class="form" name="fields" onsubmit="return !!(checkAll() & valiPhone());">
			<fieldset>
				<legend>Form dang ki hoc:</legend>
				First name:
				<div style="width: 250px; float: right">
					<input  type="file" name="pic" onchange="readURL(event);"> 
					<img style="max-width: 150px;" id="output">
				</div> <br>
				<input class="name" type="text" name="fname" required><br>
				<input type="checkbox" name="persist">Remember first name <br>
				Last name: <br>
				<input class="name" type="text" name="lname" required> <br>
				Phone number <br/>
				(<input class="phone" type="text" name="areacode" id="areacode" size="3" maxlength="3" required>)
				<input class="phone" type="text" name="phonenumber1" id="phonenumber1" size="3" maxlength="3" required>-<input  class="phone" type="text" name="phonenumber2" id="phonenumber2" size="4" maxlength="4" required> <br>
				<input type="radio" id="gender" name="gender" value="male"> Male<br>
  				<input type="radio" id="gender" name="gender" value="female"> Female<br>
  				<textarea class="text" name="description" placeholder="Description"></textarea> <br>
				<input type="checkbox" id="vehicle" name="vehicle" value="bike"> By Bike<br>
				<input type="checkbox" id="vehicle" name="vehicle" value="car"> By Car<br>
				<input class="submit" type="submit" value="Submit">
			</fieldset>
		</form>
	</body>
</html>