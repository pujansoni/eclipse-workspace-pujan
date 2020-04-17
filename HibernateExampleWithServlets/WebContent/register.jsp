<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
</head>
<body>

	<h1>EMPLOYEEEEE CRUD</h1>

	<form action="/HibernateExampleWithServlets/emp" method="post">
		<table align="center">

			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${employee.employeeName }"></td>
			</tr>
			<tr>
				<td>NIC</td>
				<td><input type="text" name="nic" value="${employee.nic }"></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="designation" value="${employee.designation }"></td>
			</tr>
			<tr>
				<td>Company</td>
				<td><input type="text" name="company" value="${employee.company }"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${employee.email}"></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" value="new" name="action">
					<input type="hidden" value="${employee.employeeId}" name="employeeId">
				</td>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form>
</body>
</html>