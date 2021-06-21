
<%@page import="com.anand.dto.AccountDto"%>
<%@page import="java.util.List"%>
<%@page import="com.anand.dto.ArticleDto"%><!DOCTYPE html>

<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>USER-HOME</title>

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
				<!-- Alert -->
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close" style="text-align: center;">
						<span aria-hidden="true">&times;</span>
					</button>
					<center>
						<span class="glyphicon glyphicon-star-empty"> </span>
						<strong> Hi <%=ad.getFullName()%> </strong>
						<span class="glyphicon glyphicon-star-empty"> </span>
					</center>
					
				</div>

<center>
					${likeMsg}
					</center>

				<!-- Articles -->

<%
List<ArticleDto> articles=(List<ArticleDto>)session.getAttribute("ARTICILES");

for(ArticleDto article:articles){
 %>
				<div class="row">
					<article class="col-xs-12">
					<p>
						<button class="btn btn-warning">
							<%=article.getFullName()%>
						</button>
					</p>
					<h2>
							<%=article.getArticleHead() %>
					</h2>
					<p style="text-align: justify;">
							<%=article.getArticleBody() %>
					</p>
					
					<ul class="list-inline">
						<li>
							<a href="#" class="btn btn-info btn-sm"><%=article.getPostArticleDate() %></a>
						</li>
						<li>
							<a href="like.htm?aid=<%=article.getArticleSerialNumber().trim()%>&author=<%=article.getEmail().trim()%>&reader=<%=ad.getEmail().trim()%>" class="btn btn-info btn-sm"> <span
								class="glyphicon glyphicon-thumbs-up"></span> Like </a>
						</li>
					</ul>
					</article>
				</div>
				<hr>
				<%} %>
				<img src="images/end_art.png" class="img-responsive"></img>
				<br/>
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
