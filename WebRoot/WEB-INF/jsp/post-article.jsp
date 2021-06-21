<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>POST-ARTICLE</title>

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
		<link rel="stylesheet" href="css/w3.css" type="text/css"></link>
	</head>

	<body>

		<jsp:include page="header.jsp"></jsp:include>



		<div class="container">
			<div class="row">
				<div class="col-sm-3">
				<br />
				<jsp:include page="profile.jsp"></jsp:include>
				</div>
				<div class="col-sm-6">
				<form:form commandName="postArticleCmd" 
						class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
						<h3 class="w3-center">
						
							<span class="label label-warning"
								style="font-family: Times New Roman;"> <span
								class="glyphicon glyphicon-star-empty"></span> Article  <span
								class="glyphicon glyphicon-star-empty"></span> </span>
						</h3>

						<br>
${resMsg} 
						
						<div class="form-group">
							<label for="articleHead">
								<span class="glyphicon glyphicon-tag"></span> Article head
							</label>
							<input type="text" class="form-control" name="articleHead" id="articleHead"
								id="formGroupExampleInput1" >
						</div>
						<div class="form-group">
							<label for="articleBody">
								<span class="glyphicon glyphicon-pencil"></span> Article body
							</label>
							<textarea class="form-control" name="articleBody" id="articleBody" rows="12"></textarea>
						</div>




						<button type="submit" class="btn btn-primary btn-block">
							<span class="glyphicon glyphicon-send"></span> Post Article 
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
