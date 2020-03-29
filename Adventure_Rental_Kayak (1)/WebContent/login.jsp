<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<link rel="stylesheet" href="../Css and Js/font-awesome.min.css"> 
	<link rel="stylesheet" href="../Css and Js/bootstrap.min.css">
	<link rel="stylesheet" href="../Css and Js/navbar_page.css">
	<script src="../Css and Js/jquery.min.js"></script>
 	<script src="../Css and Js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file= "navbar.jsp" %>
	<br>
	<br>
	<div class="container">
		<form method="post" action="LoginServlet">
			<div class="jumbotron">
		   		<div class="row">
			        <div class="form-group col-sm-12">
			        	<h2 class="text-center">Login</h2>
			        </div>
		   		</div>
				<div class="row">
			        <div class="form-group col-sm-8 col-sm-offset-2">
			        	<input type="text" name="userId" class="form-control input-lg" placeholder="Username/E-mail" required="required">
			        </div>
		        </div>
		        <div class="row">
			        <div class="form-group col-sm-8 col-sm-offset-2">
			            <input type="password" name="password" class="form-control input-lg" placeholder="Password" required="required">
			        </div>
		        </div>
		        <div class="row">
			        <div class="form-group col-sm-8 col-sm-offset-2">
			            <button type="submit" class="btn btn-primary btn-block input-lg">Log in</button>
			        </div>
		        </div>
		        <div class="row">
			        <div class="form-group col-sm-8 col-sm-offset-2">
			            <label class="pull-left checkbox-inline input-lg">New User?<a href="register.jsp"> Register</a></label>
			            <a href="#" class="pull-right  input-lg">Forgot Password?</a>
			        </div>
		        </div>
			</div>
		</form>
	</div>      
	<%@ include file="footer.jsp" %>
</body>
</html>