<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
	<!-- <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"> -->
    
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Register</title>
	
	<link rel="stylesheet" href="../Css and Js/font-awesome.min.css">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../Css and Js/navbar_page.css">
    
    <script src="<c:url value="../js/jquery.min.js"/>"></script>
    <script src="<c:url value="../js/jquery.validate.min.js"/>"></script>
    <script src="<c:url value="../js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="../js/form-validation.js"/>"></script>
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<br>
	<br>
	<div class="container">
		<form method="post" action="" id="register_user">
			<div class="jumbotron">
		   		<div class="row">
			        <div class="form-group col-sm-12">
			        	<h2 class="text-center">Register</h2>
			        </div>
		   		</div>
		   		<div class="row">
			        <div class="form-group col-sm-8 offset-sm-2">
			            <input type="text" name="firstname" id="firstname" class="form-control input-lg" placeholder="First Name" required="required">
			        </div>
		        </div>
		   		<div class="row">
			        <div class="form-group col-sm-8 offset-sm-2">
			            <input type="text" name="user_lastname" class="form-control input-lg" placeholder="LastName" required="required">
			        </div>
		        </div>
				<div class="row">
			        <div class="form-group col-sm-8 offset-sm-2">
			            <input type="text" name="user_email" class="form-control input-lg" placeholder="Username/E-mail" required="required">
			        </div>
		        </div>
		        <div class="row">
			        <div class="form-group col-sm-8 offset-sm-2">
			            <input type="password" name="user_password" class="form-control input-lg" placeholder="Password" required="required">
			        </div>
		        </div>
		        <div class="row">
			        <div class="form-group col-sm-8 offset-sm-2">
			            <input type="password" name="user_retypepassword" class="form-control input-lg" placeholder="Retype-Password" required="required">
			        </div>
		        </div>
		        <div class="row">
			        <div class="form-group col-sm-8 offset-sm-2">
			            <button type="submit" class="btn btn-primary btn-block input-lg">Register</button>
			        </div>
		        </div>
			</div>
		</form>
	</div>      
	<%@ include file="footer.jsp" %>
</body>
</html>