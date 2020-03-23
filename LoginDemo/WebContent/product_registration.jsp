<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Thekanu</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link rel="stylesheet" href="Css and Js\bootstrap.min.css">
  
  
  <script type="text/javascript" src="Css and Js\jquery.min.js"></script>
  <script type="text/javascript" src="Css and Js\map.js"></script>
<style>

</style>
</head>
<body >

<div>
	<%@include file="navbar.jsp" %>	
</div>

<div class="jumbotron center" style="background-color: transparent;">
	
	<div class="container" style="border: solid 1px;">
		
			<div class="row">

				<!--          Spacing                       -->
				<div class="col-md-1"></div>

				<!--md-10 -->
				<div class="col-md-10">
					

					
					<h3 style="text-align:center;">Enter Kayak details</h3>		

					<form   method="post" action="" style="font-size: 1.20em;font-family:'Open Sans',Tahoma,Arial,helvetica,sans-serif'">

					<!-- Details   -->
							
						<div class="row" style="margin-top: 1rem">
							<div class="form-group input-group-sm col-md-12">
								<label> Kayak name</label>
								<input class="form-control" type="text" maxlength="100" id="Kayak_name" name="Kayak_name" >
							</div>
						</div>
				

				
						<div class="row">
							<div class="form-group input-group-sm col-md-12">
								<label> Kayak Description</label>
								<input class="form-control" type="text" maxlength="100" id="Kayak_description" name="Kayak_description" >
							</div>
						</div>

						<!------------------------------Contact Info---------------------------------------------------->

			<div class="jumbotron" style="background-color:transparent;padding: 0px;">

				<div class="row">
					<div class="col-md-3 input-group-sm" style="margin-top:.75em">
							<label for="Capacity"> Capacity </label>
							<input class="form-control" type="number" id="Capacity" maxlength="5" placeholder="Enter in digit" name="Capacity">			
											
					</div>
					
					<div class="col-md-3 input-group-sm" style="margin-top:.75em">
					
					</div>
						
						<div class="col-md-6 input-group-sm" style="margin-top:.75em">
							<label for="Contact">Mobile no.</label>
							<input class="form-control" type="text" id="Contact" maxlength="10" placeholder="Enter 10 digit Mobile No." name="Contact">						
						</div>
				</div>

				<div class="row">				

				
						
						<div class="col-md-6 input-group-sm" style="margin-top:.75em">
							<label for="Email_ID">Email ID</label>
							<input class="form-control" type="Email" id="Email_ID" placeholder="Enter Email ID" name="Email_ID">	
						</div>
					
				</div>

				

			</div><!-----end of------>

			<!------------------------ Address--------------------------------------------------------------------->

				<label><b>Address:</b></label>

			<div class="row">

				<div class="form-group input-group-sm col-sm-12">

					<label for="Street">Street</label>
					<input class="form-control" type="text" id="Street" name="Street">

				</div>
			</div>
			

				<div class="row" >					
					<div class="col-md-5">

						<select class="form-control" placeholder="Select City" name="City">

							<span style="text-align:center"><option>Select city</option></span>
							<option value="University Area"> Toronto</option>
							<option value="Navrangpura"> Windsor </option>
							<option value="Naranpura"> Ottawa </option>
							<option value="Vijay_Cross_Road"> Vancover </option>
						
						</select>
						
					</div>
<!------------------------------------
					<div class="col-sm-4">

						<div class="dropdown">
							<button class="form-control  dropdown-toggle" type="button" data-toggle="dropdown" id="dropdown0">
								Select Area								
							</button>

							<div class="form-group dropdown-menu" aria-labelledby="dropdown0">
								<a href="#" class="dropdown-item"> abc </a>

								
							</div>
							
						</div>
						
					</div>

<!---------------------------------------->
					
					<div class="col-md-6 form-group input-group-sm form-inline">
							<label for="Pincode">Pincode</label>
							<input class="form-control form-inline " type="text" placeholder="No Spacing" id="Pincode" name="Pincode">				
					</div>
											
					
				</div>

				<!-- IMAGES -->

				<div class="jumbotron col-sm-12 " style="background-color: transparent;padding: 0px;margin-top:.75em ">
					<div class="row">
				
					<label class="col-sm-6" style="font-size: 20px"> <span><b>UPLOAD IMAGES</b></span></label>

						<div class="col-sm-6">

							<div class="custom-file">
								<input type="file" class="custom-file-input" id="images">
							</div>
						</div>
				
					</div>
				</div>

				<!-- PRICING -->


				<div class="row" style="margin-top: 1em;">

					<div class="col-md-4" style="margin-bottom: 10px">
			
					
						<div class="form-inline">
						
							<label> Select Price </label>

						</div>

					<div class="row">
						
						<div class="custom-checkbox custom-control custom-control-inline col-sm-6">
							<input type="checkbox" class="custom-control-input" id="CustomCheck0" name="Price" value="Hour">  
							<label class="custom-control-label" for="CustomCheck0">Per/Hour </label>
						</div>	

						<div class="col-sm-6 form-group input-group-sm form-inline">
							<input class="form-control form-inline " type="text" placeholder="$/Hr" id="Price_Hour" name="Price_Hour">				
						</div>


					</div>

					<div class="row">
						
						<div class="custom-checkbox custom-control custom-control-inline col-sm-6">
							<input type="checkbox" class="custom-control-input" id="CustomCheck1" name="Price" value="Day" >  
							<label class="custom-control-label" for="CustomCheck1"> Per/Day </label>
						</div>

						<div class="col-sm-6 form-group input-group-sm form-inline">
							<input class="form-control form-inline " type="text" placeholder="$/Day" id="Price_Day" name="Price_Day">				
						</div>


					</div>

					<div class="row">
						
						<div class="custom-checkbox custom-control custom-control-inline col-sm-6">
							<input type="checkbox" class="custom-control-input" id="CustomCheck1" name="Price" value="Week" >  
							<label class="custom-control-label" for="CustomCheck2"> Per/Week </label>
						</div>

						<div class="col-sm-6 form-group input-group-sm form-inline">
							<input class="form-control form-inline " type="text" placeholder="$/Week" id="Price_Week" name="Price_Week">				
						</div>


					</div>

					
					
					
									
				</div>
			</div>
				
			</div>
					</form>

				</div> <!-- col md 10 -->




					<div class="col-md-1"></div>
			</div><!-- row -->
	</div><!-- container -->
		
</div> <!-- jumbotron -->
<div>
	<%@include file="footer.jsp" %>
</div>
	</body>
</html>