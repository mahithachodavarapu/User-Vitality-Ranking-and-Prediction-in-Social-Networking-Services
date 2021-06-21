<!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		
		<title>HOME</title>


    <link href="css/bootstrap.min.css" rel="stylesheet">

     <link href="css/custom.css" rel="stylesheet">

   

</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>


		<section id="slider">
		<!--slider-->
		<div class="container">
			<div class="row" style="margin: 75px; border: 2px solid #fbfaf9;padding: 0px;">
				<div class="col-sm-12">
					<!--  -->





<div id="side-carousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#side-carousel" data-slide-to="0" class="active"></li>
						<li data-target="#side-carousel" data-slide-to="1"></li>
						<li data-target="#side-carousel" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							 <img class="img-responsive"
									src="images/sliderpic1.png" alt="">
							
						</div>
						<div class="item">
							<img src="images/sliderpic2.png" class="img-responsive"
										alt="" />
						</div>
						<div class="item">
							<img src="images/sliderpic3.jpg" class="img-responsive"
										alt="" />
						</div>
					</div>
					<a class="left carousel-control" href="#side-carousel"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span> </a>
					<a class="right carousel-control" href="#side-carousel"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span> </a>
				</div>
<!--  -->
				</div>
			</div>
		</div>
		</section>
		<!--/slider-->



	

<jsp:include page="footer.jsp"></jsp:include>



	</body>

</html>
