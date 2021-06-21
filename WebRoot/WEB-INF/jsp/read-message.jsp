
<%@page import="java.util.Map"%>
<%@page import="com.anand.dto.MessageDto"%><!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>MESSAGE</title>

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

					<h3 class="w3-center">

						<span class="label label-warning"
							style="font-family: Times New Roman;"> <span
							class="glyphicon glyphicon-star-empty"></span> Message <span
							class="glyphicon glyphicon-star-empty"></span> </span>
					</h3>


<%
Map<String, MessageDto> inbox=(Map)session.getAttribute("INBOX");
                            
String key=(String)session.getAttribute("MID");
                        MessageDto    dto=inbox.get(key);
 %>

	<div class="form-group">
						<label for="articleHead">
								<span class="glyphicon glyphicon-user"></span> From :
						</label>
						<label
							style="text-align: justify; font-family: cursive; font-size: 15px; color: black;"
							id="articleHead">
							
<br/>
<%=dto.getFromEmail() %>
						</label>
					</div>

	<div class="form-group">
						<label for="articleHead">
								<span class="glyphicon glyphicon-calendar"></span> Date : 
						</label>
						<label
							style="text-align: justify; font-family: cursive; font-size: 15px; color: black;"
							id="articleHead">
							
<br/>
<%=dto.getPostDate() %>
						</label>
					</div>


					<div class="form-group">
						<label for="articleHead">
							<span class="glyphicon glyphicon-tag"></span> Message head:
						</label>
						<label
							style="text-align: justify; font-family: cursive; font-size: 15px; color: blue;"
							id="articleHead">
							
<br/>

<%=dto.getSubject()%>
						</label>
					</div>
					<div class="form-group">
						<label for="articleBody">
							<span class="glyphicon glyphicon-comment"></span> Message body:
						</label>
						<label
							style="text-align: justify; font-family: serif; font-size: 14px; color: black;"
							id="articleHead">
							<br/>
							
<%=dto.getMessage() %>
						</label>
					</div>





					<br>

				</div>
				<div class="col-sm-3">
				</div>

			</div>

		</div>

		<jsp:include page="footer.jsp"></jsp:include>

	</body>

</html>
