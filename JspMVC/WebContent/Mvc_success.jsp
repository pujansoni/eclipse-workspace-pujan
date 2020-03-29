<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.test.servlet.TestBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
	<%  
	TestBean testguru=(TestBean)request.getAttribute("gurubean");  
	out.print("Welcome, "+testguru.getEmail());  
	%>
</body>
</html>