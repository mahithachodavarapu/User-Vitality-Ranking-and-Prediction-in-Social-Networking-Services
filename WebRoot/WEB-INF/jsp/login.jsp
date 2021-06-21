<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>LOGIN</title>

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
		<link rel="stylesheet" href="css/w3.css" type="text/css"></link>
	</head>

	<body>

		<jsp:include page="header.jsp"></jsp:include>



		<div class="container">
			<div class="row">
				<div class="col-sm-3">
				</div>
				<div class="col-sm-6">



<form:form commandName="loginCmd"  class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
						<h3 class="w3-center">
							<span class="label label-warning"
								style="font-family: Times New Roman;"> <span
								class="glyphicon glyphicon-star-empty"></span> Login <span
								class="glyphicon glyphicon-star-empty"></span> </span>
						</h3>
						<br>
						<label style="color: red;">${resMsg} </label>

						<div class="input-group ">
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-envelope"></span> </span>
							<input class="form-control" type="text" name="email" id="email"
								placeholder="Email address">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-lock"></span> </span>
							<input class="form-control" type="password" name="password" id="password"
								placeholder="Password">
						</div>

						<br>

						<button type="submit" class="btn btn-primary btn-block">
							Login
						</button>
						<br>

				</form:form>
				</div>
				<div class="col-sm-3">
				</div>

			</div>

		</div>

		<jsp:include page="footer.jsp"></jsp:include>

	</body>

</html>
