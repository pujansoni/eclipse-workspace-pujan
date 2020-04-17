<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Example</title>
</head>
<body>
<a href = "/HibernateExampleWithServlets/emp?action=new">New Register</a>
	<table align="center">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>NIC</td>
			<td>Designation</td>
			<td>Company</td>
			<td>Email</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		
		<c:forEach items="${employees }" var="emp">
			<tr>
				<td>${emp.employeeId }</td>
				<td>${emp.employeeName }</td>
				<td>${emp.nic }</td>
				<td>${emp.designation }</td>
				<td>${emp.company }</td>
				<td>${emp.email }</td>
				<td><a href = "/HibernateExampleWithServlets/emp?action=update&id=${emp.employeeId }">Update</a></td>
				<td><a href = "/HibernateExampleWithServlets/emp?action=delete&id=${emp.employeeId }">Delete</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>