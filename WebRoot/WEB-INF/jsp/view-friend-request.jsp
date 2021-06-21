
<%@page import="com.anand.dto.AccountDto"%>
<%@page import="java.util.List"%><!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>FRIEND-REQUEST</title>

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
	</head>

	<body>
	<%
		AccountDto ad = (AccountDto) session.getAttribute("USERPROFILE");
	%>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="row">
			<div class="col-xs-12">
				<br />
			</div>
		</div>

		<div class="container-fluid">

			<!-- Left Column -->
			<div class="col-sm-3">

				<!-- Text Panel -->
<jsp:include page="profile.jsp"></jsp:include>

			</div>
			<!--/Left Column-->

			<!-- Center Column -->
			<div class="col-sm-6"
				style="box-shadow: 0 0 4px 1px rgba(1, 1, 1, 0.2);">
				<br />
			

				<div class="list-group">
			<b class="list-group-item active">  <span
				class="glyphicon glyphicon-user"></span> Friend request </b>


<%
AccountDto ss=new AccountDto();
List<AccountDto> userList=(List<AccountDto>)request.getAttribute("userList");
if(userList!=null &&userList.size()>0){
%>
<b class="list-group-item">
<%
for(AccountDto profile:userList){
 %>
			 <span class="glyphicon"><img
						src="images/<%=profile.getPicture()%>" class="girl img-responsive img-thumbnail"
						style="max-width: 100px;" /> </span> <label>
					<span style="color: black;"> <%=profile.getFullName() %></span>
					<br />
					<%=profile.getAddress()%> 
				</label> <br /> 
				<a href="friend-request.htm?userid=<%=profile.getEmail()%>&requestCode=2&frid=<%=profile.getSerialNumber()%>" class="btn btn-default btn-sm" style="margin: 2px;">+ Accept</a> 
					<hr/>
					
					<%}%>
					</b>
					<%}else{%>
					<b class="list-group-item" style="color: red;"> <span
				class="glyphicon glyphicon-warning-sign"></span> 
no friend request </b>
					<%} %>

		</div>
			</div>
			<!--/Center Column-->


			<!-- Right Column -->
			<div class="col-sm-3">




				<!-- Carousel -->



			</div>
			<!--/Right Column -->

		</div>
		<!--/container-fluid-->

		<jsp:include page="footer.jsp"></jsp:include>

	</body>

</html>