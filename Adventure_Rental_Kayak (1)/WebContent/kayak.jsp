<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="webthemez">
    <title>Product Details</title>
	<!-- core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.transitions.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
	<link href="css/magnific-popup.css" rel="stylesheet">  
	<link href="css/gallery-1.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="../images/ico/favicon.ico">
    <script src="CssandJs/display_product.js"></script>
</head>
<body id="home">
    <%@include file= "navbar.jsp" %>
    
    <section id="hero-text" class="wow fadeIn">
        <div class="container">
            <div class="row">
                <div class="">
                    <h2>Eddyline Caribbean 12 Sit-On-Top Kayak</h2>
                    <h3>Type : Sit-On-Top Kayaks</h3>
                    <p>Great primary stability and your gears are easily accessible.</p>
                </div>
                <div class="col-sm-3 text-right" style="display:none">
                    <a class="btn btn-primary btn-lg" href="#pricing">Plans!</a>
                </div>
            </div>
        </div>
    </section>
    
    <section id="main-slider">
        <div class="o">
            <div class="col-md-6 item" style="background-image: url(images/1.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
							<div class="">
                                <div class=""> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 item" style="background-image: url(images/Untitled2.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
							<div class="">
                                <div class=""> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <section id="services" >
		<div class="container">
	    	<div class="section-header">
	        	<h2 class="section-title text-center wow fadeInDown">Features</h2>
	        </div>
	        <div class="row">
            	<div class="features">
            		<div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="0ms">
	            		<h4 class="media-heading">Length			: 13 feet</h4>
	            		<h4 class="media-heading">Width				: 34"</h4>
	            		<h4 class="media-heading">Weight Capacity 	: 200-250lbs(Approx 2-people)</h4>
	                </div>
            	</div>
            </div>
        </div>
    </section>
    
    <section id="services" style="padding-top:0;">
		<div class="container">
	    	<div class="section-header">
	        	<h2 class="section-title text-center wow fadeInDown">Details</h2>
	        </div>
	        <div class="row">
            	<div class="features">
            		<div class="col-md-9 col-sm-9 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="0ms">
						<h4 class="media-heading">Status : Available</h4>
						<h4 class="media-heading">Availability: 2020-04-01 to 2020-05-15</h4>
	            		<h4 class="media-heading">Location : <a href="https://goo.gl/maps/e5ht1JFbq6fTz8w27">River Canard Canoe</a></h4>
	            		<h4 class="media-heading">Pricing : $15/hr</h4>
	            		<div class="wrapper text-center">
		            		<button type="submit" class="btn btn-primary seller-btn" onclick="changeButton()" style="position:absolute;margin:8px;">Notify Seller (If you are interested)</button>
	            		</div>
	                </div>
            	</div>
            </div>
        </div>
    </section>
    
	<%@include file="footer.jsp" %>
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/mousescroll.js"></script>
    <script src="../js/smoothscroll.js"></script>
    <script src="../js/jquery.prettyPhoto.js"></script> 
    <script src="../js/jquery.inview.min.js"></script>
    <script src="../js/wow.min.js"></script>
 
    <script type="text/javascript" src="../js/jquery.isotope.min.js"></script><!-- Gallery Filter -->
	<script type="text/javascript" src="../js/jquery.magnific-popup.min.js"></script><!-- Gallery Popup -->
	 
    <script src="../js/custom-scripts.js"></script>
</body>
</html>