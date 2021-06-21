<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.Map"%><!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>SEND-MESSAGE</title>

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

				<form:form commandName="msgCmd"  
						class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
						<h3 class="w3-center">
							<span class="label label-warning"
								style="font-family: Times New Roman;"> <span
								class="glyphicon glyphicon-star-empty"></span> Message <span
								class="glyphicon glyphicon-star-empty"></span> </span>
						</h3>
						<br>
						<label style="color: red;">
							${resMsg}
						</label>

						<div class="form-group">
							<label for="toEmail">
								<span class="glyphicon glyphicon-envelope"></span> To email
							</label>
							<select class="form-control" id="toEmail" name="toEmail">

								<%
									String email = (String) session.getAttribute("USEREMAIL");
									Map<String, Integer> friendList = (Map<String, Integer>) session.getAttribute("MYFRIENDLIST");
									friendList.remove(email);
									System.out.print(email + " : " + friendList);

									for (String key : friendList.keySet()) {
								%>
								<option value="<%=key%>">
									<%=key%>
								</option>
								<%
									}
								%>

							</select>
						</div>
						<div class="form-group">
							<label for="subject">
								<span class="glyphicon glyphicon-tag"></span> Subject
							</label>
							<input type="text" class="form-control" id="subject"
								name="subject">
						</div>
						<div class="form-group">
							<label for="message">
								<span class="glyphicon glyphicon-pencil"></span> Message
							</label>
							<textarea class="form-control" id="message" name="message"
								rows="6"></textarea>
						</div>

						<input type="hidden" name="fromEmail" id="fromEmail"
							value="<%=email%>">

						<button type="submit" class="btn btn-primary btn-block">
							<span class="glyphicon glyphicon-send"></span> Send
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
