<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${students}" var="s">
		${s.name} <br/>
	</c:forEach>
	
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/ems?autoReconnect=true&useSSL=false" user="root" password="root"/>
	<sql:query var="rs" dataSource="${db}">select * from students</sql:query>
	<c:forEach items="${rs.rows}" var="student">
		<c:out value="{student.rollno}"></c:out>
		<c:out value="{student.name}"></c:out>
		<c:out value="{student.marks}"></c:out>
	</c:forEach>
	
	<c:set var="str" value="Pujan Soni, student at the universtiy of windsor"/>
	<c:forEach items="${fn:split(str, ' ')}" var="s">
		<br>
		${s}
	</c:forEach>
</body>
</html>