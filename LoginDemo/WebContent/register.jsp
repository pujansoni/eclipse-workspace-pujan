<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>

		<script src="Css and Js/jquery.min.js"></script>
		<link rel="stylesheet" href="Css and Js/font-awesome.min.css"> 
 		<link rel="stylesheet" href="Css and Js/bootstrap.min.css">
        <link rel="stylesheet" href="Css and Js/navbar_page.css">
  		<script src="Css and Js/bootstrap.min.js"></script>
</head>
<body>
<div>
	<%@ include file="navbar.jsp" %>
</div>
<br>
<br>

<div class="container">
<form method="post" action="UserRegisterServlet">
<div class="jumbotron">
   		<div class="row">
   		<div class="form-group col-sm-2"></div>
        <div class="form-group col-sm-8">
           <a style="text-align: center"><h2>Registration form</h2></a>
        </div>
        <div class="form-group col-sm-2"></div>
   		</div>
   		
   		<div class="row">
		<div class="form-group col-sm-2"></div>
        <div class="form-group col-sm-8">
            <input type="text" name="user_firstname" class="form-control input-lg" placeholder="FirstName" required="required">
        </div>
        <div class="form-group col-sm-2"></div>
        </div>
   		
   		<div class="row">
		<div class="form-group col-sm-2"></div>
        <div class="form-group col-sm-8">
            <input type="text" name="user_lastname" class="form-control input-lg" placeholder="LastName" required="required">
        </div>
        <div class="form-group col-sm-2"></div>
        </div>
   		
   		
   		
		<div class="row">
		<div class="form-group col-sm-2"></div>
        <div class="form-group col-sm-8">
            <input type="text" name="user_email" class="form-control input-lg" placeholder="Username/E-mail" required="required">
        </div>
        <div class="form-group col-sm-2"></div>
        </div>
        
        <div class="row">
        <div class="form-group col-sm-2"></div>
        <div class="form-group col-sm-8">
            <input type="password" name="user_password" class="form-control input-lg" placeholder="Password" required="required">
        </div>
        <div class="form-group col-sm-2"></div>
        </div>
       
        <div class="row">
        <div class="form-group col-sm-2"></div>
        <div class="form-group col-sm-8">
            <input type="password" name="user_retypepassword" class="form-control input-lg" placeholder="Retype-Password" required="required">
        </div>
        
        <div class="form-group col-sm-2"></div>
        </div>
       
        <div class="row">
        <div class="form-group col-sm-2"></div>
        <div class="form-group col-sm-8">
            <button type="submit" class="btn btn-primary btn-block input-lg">Log in</button>
        </div>
        <div class="form-group col-sm-2"></div>
        </div>
        
 
</div>
</form>
</div>      
<div>
	<%@ include file="footer.jsp" %>
</div>

</body>
</html>