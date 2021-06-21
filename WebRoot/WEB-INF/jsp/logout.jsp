

<%
	session.invalidate();
%>
<!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>LOGOUT</title>

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
		<link rel="stylesheet" href="css/w3.css" type="text/css"></link>
	</head>

	<body>

		<jsp:include page="header.jsp"></jsp:include>



		<div class="container">
			<div class="row">
				<div class="col-sm-2">
				</div>
				<div class="col-sm-8">


					<center>

						<br />
						<br />
						<br />
						<br />
							<img src="images/successfully-logged-out.png" class="girl img-responsive"></img>
					
						<br />

						<br />
						<br />
						<br />
						<br />
					</center>


				</div>
				<div class="col-sm-2">
				</div>

			</div>

		</div>

		<jsp:include page="footer.jsp"></jsp:include>

	</body>

</html>
