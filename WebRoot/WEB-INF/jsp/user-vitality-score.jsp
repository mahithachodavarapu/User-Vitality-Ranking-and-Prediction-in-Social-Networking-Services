
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Random"%>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>USER-SCORE</title>

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
		<style type="text/css">
.mail-box {
	border-collapse: collapse;
	border-spacing: 0;
	display: table;
	table-layout: fixed;
	width: 100%;
}

.mail-box aside {
	display: table-cell;
	float: none;
	height: 100%;
	padding: 0;
	vertical-align: top;
}

.mail-box .sm-side {
	background: none repeat scroll 0 0 #e5e8ef;
	border-radius: 4px 0 0 4px;
	width: 25%;
}

.mail-box .lg-side {
	background: none repeat scroll 0 0 #fff;
	border-radius: 0 4px 4px 0;
	width: 75%;
}

.mail-box .sm-side .user-head {
	background: none repeat scroll 0 0 #00a8b3;
	border-radius: 4px 0 0;
	color: #fff;
	min-height: 80px;
	padding: 10px;
}

.user-head .inbox-avatar {
	float: left;
	width: 65px;
}

.user-head .inbox-avatar img {
	border-radius: 4px;
}

.user-head .user-name {
	display: inline-block;
	margin: 0 0 0 10px;
}

.user-head .user-name h5 {
	font-size: 14px;
	font-weight: 300;
	margin-bottom: 0;
	margin-top: 15px;
}

.user-head .user-name h5 a {
	color: #fff;
}

.user-head .user-name span a {
	color: #87e2e7;
	font-size: 12px;
}

a.mail-dropdown {
	background: none repeat scroll 0 0 #80d3d9;
	border-radius: 2px;
	color: #01a7b3;
	font-size: 10px;
	margin-top: 20px;
	padding: 3px 5px;
}

.inbox-body {
	padding: 20px;
}

.btn-compose {
	background: none repeat scroll 0 0 #ff6c60;
	color: #fff;
	padding: 12px 0;
	text-align: center;
	width: 100%;
}

.btn-compose:hover {
	background: none repeat scroll 0 0 #f5675c;
	color: #fff;
}

ul.inbox-nav {
	display: inline-block;
	margin: 0;
	padding: 0;
	width: 100%;
}

.inbox-divider {
	border-bottom: 1px solid #d5d8df;
}

ul.inbox-nav li {
	display: inline-block;
	line-height: 45px;
	width: 100%;
}

ul.inbox-nav li a {
	color: #6a6a6a;
	display: inline-block;
	line-height: 45px;
	padding: 0 20px;
	width: 100%;
}

ul.inbox-nav li a:hover,ul.inbox-nav li.active a,ul.inbox-nav li a:focus
	{
	background: none repeat scroll 0 0 #d5d7de;
	color: #6a6a6a;
}

ul.inbox-nav li a i {
	color: #6a6a6a;
	font-size: 16px;
	padding-right: 10px;
}

ul.inbox-nav li a span.label {
	margin-top: 13px;
}

ul.labels-info li h4 {
	color: #5c5c5e;
	font-size: 13px;
	padding-left: 15px;
	padding-right: 15px;
	padding-top: 5px;
	text-transform: uppercase;
}

ul.labels-info li {
	margin: 0;
}

ul.labels-info li a {
	border-radius: 0;
	color: #6a6a6a;
}

ul.labels-info li a:hover,ul.labels-info li a:focus {
	background: none repeat scroll 0 0 #d5d7de;
	color: #6a6a6a;
}

ul.labels-info li a i {
	padding-right: 10px;
}

.nav.nav-pills.nav-stacked.labels-info p {
	color: #9d9f9e;
	font-size: 11px;
	margin-bottom: 0;
	padding: 0 22px;
}

.inbox-head {
	background: none repeat scroll 0 0 #41cac0;
	border-radius: 0 4px 0 0;
	color: #fff;
	min-height: 80px;
	padding: 20px;
}

.inbox-head h3 {
	display: inline-block;
	font-weight: 300;
	margin: 0;
	padding-top: 6px;
}

.inbox-head .sr-input {
	border: medium none;
	border-radius: 4px 0 0 4px;
	box-shadow: none;
	color: #8a8a8a;
	float: left;
	height: 40px;
	padding: 0 10px;
}

.inbox-head .sr-btn {
	background: none repeat scroll 0 0 #00a6b2;
	border: medium none;
	border-radius: 0 4px 4px 0;
	color: #fff;
	height: 40px;
	padding: 0 20px;
}

.table-inbox {
	border: 1px solid #d3d3d3;
	margin-bottom: 0;
}

.table-inbox tr td {
	padding: 12px !important;
}

.table-inbox tr td:hover {
	cursor: pointer;
}

.table-inbox tr td .fa-star.inbox-started,.table-inbox tr td .fa-star:hover
	{
	color: #f78a09;
}

.table-inbox tr td .fa-star {
	color: #d5d5d5;
}

.table-inbox tr.unread td {
	background: none repeat scroll 0 0 #f7f7f7;
	font-weight: 600;
}

ul.inbox-pagination {
	float: right;
}

ul.inbox-pagination li {
	float: left;
}

.mail-option {
	display: inline-block;
	margin-bottom: 10px;
	width: 100%;
}

.mail-option .chk-all,.mail-option .btn-group {
	margin-right: 5px;
}

.mail-option .chk-all,.mail-option .btn-group a.btn {
	background: none repeat scroll 0 0 #fcfcfc;
	border: 1px solid #e7e7e7;
	border-radius: 3px !important;
	color: #afafaf;
	display: inline-block;
	padding: 5px 10px;
}

.inbox-pagination a.np-btn {
	background: none repeat scroll 0 0 #fcfcfc;
	border: 1px solid #e7e7e7;
	border-radius: 3px !important;
	color: #afafaf;
	display: inline-block;
	padding: 5px 15px;
}

.mail-option .chk-all input[type="checkbox"] {
	margin-top: 0;
}

.mail-option .btn-group a.all {
	border: medium none;
	padding: 0;
}

.inbox-pagination a.np-btn {
	margin-left: 5px;
}

.inbox-pagination li span {
	display: inline-block;
	margin-right: 5px;
	margin-top: 7px;
}

.fileinput-button {
	background: none repeat scroll 0 0 #eeeeee;
	border: 1px solid #e6e6e6;
}

.inbox-body .modal .modal-body input,.inbox-body .modal .modal-body textarea
	{
	border: 1px solid #e6e6e6;
	box-shadow: none;
}

.btn-send,.btn-send:hover {
	background: none repeat scroll 0 0 #00a8b3;
	color: #fff;
}

.btn-send:hover {
	background: none repeat scroll 0 0 #009da7;
}

.modal-header h4.modal-title {
	font-family: "Open Sans", sans-serif;
	font-weight: 300;
}

.modal-body label {
	font-family: "Open Sans", sans-serif;
	font-weight: 400;
}

.heading-inbox h4 {
	border-bottom: 1px solid #ddd;
	color: #444;
	font-size: 18px;
	margin-top: 20px;
	padding-bottom: 10px;
}

.sender-info {
	margin-bottom: 20px;
}

.sender-info img {
	height: 30px;
	width: 30px;
}

.sender-dropdown {
	background: none repeat scroll 0 0 #eaeaea;
	color: #777;
	font-size: 10px;
	padding: 0 3px;
}

.view-mail a {
	color: #ff6c60;
}

.attachment-mail {
	margin-top: 30px;
}

.attachment-mail ul {
	display: inline-block;
	margin-bottom: 30px;
	width: 100%;
}

.attachment-mail ul li {
	float: left;
	margin-bottom: 10px;
	margin-right: 10px;
	width: 150px;
}

.attachment-mail ul li img {
	width: 100%;
}

.attachment-mail ul li span {
	float: right;
}

.attachment-mail .file-name {
	float: left;
}

.attachment-mail .links {
	display: inline-block;
	width: 100%;
}

.fileinput-button {
	float: left;
	margin-right: 4px;
	overflow: hidden;
	position: relative;
}

.fileinput-button input {
	cursor: pointer;
	direction: ltr;
	font-size: 23px;
	margin: 0;
	opacity: 0;
	position: absolute;
	right: 0;
	top: 0;
	transform: translate(-300px, 0px) scale(4);
}

.fileupload-buttonbar .btn,.fileupload-buttonbar .toggle {
	margin-bottom: 5px;
}

.files .progress {
	width: 200px;
}

.fileupload-processing .fileupload-loading {
	display: block;
}

* html .fileinput-button {
	line-height: 24px;
	margin: 1px -3px 0 0;
}

*+html .fileinput-button {
	margin: 1px 0 0;
	padding: 2px 15px;
}

@media ( max-width : 767px) {
	.files .btn span {
		display: none;
	}
	.files .preview * {
		width: 40px;
	}
	.files .name * {
		display: inline-block;
		width: 80px;
		word-wrap: break-word;
	}
	.files .progress {
		width: 20px;
	}
	.files .delete {
		width: 60px;
	}
}

ul {
	list-style-type: none;
	padding: 0px;
	margin: 0px;
}
</style>
	</head>

	<body>

		<jsp:include page="header.jsp"></jsp:include>
		<div class="row">
			<div class="col-xs-12">
				<br />
			</div>
		</div>

		<div class="container-fluid">

			<!-- Left Column -->
			<div class="col-sm-3">
				<jsp:include page="profile.jsp"></jsp:include>


			</div>
			<!--/Left Column-->

			<!-- Center Column -->
			<div class="col-sm-8"
				style="box-shadow: 0 0 4px 1px rgba(1, 1, 1, 0.2);">
				<br />


				<!-- Articles -->
				<div class="row">
					<div class="col-xs-12">


						<form class="form-inline" action="dashboard.htm">
							<input type="hidden" name="page" value="user-vitality-score">
							<div class="form-group">
								<label for="fromDate">
									From date
									<span class="glyphicon glyphicon-calendar"></span>
								</label>
								<input type="date" class="form-control" id="fromDate"
									name="fromDate">
							</div>
							<div class="form-group">
								<label for="toDate">
									To date
									<span class="glyphicon glyphicon-calendar"></span>
								</label>
								<input type="date" class="form-control" id="toDate"
									name="toDate">
							</div>
							<button type="submit" class="btn btn-info">
								<span class="glyphicon glyphicon-search"></span> Result
							</button>
						</form>

						<br />
						<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-record"></span> User vitality score
						</button>

						${timeperiod}
						<table class="table table-inbox table-hover">
							<thead>
								<tr class="unread">
									<td class="inbox-small-cells">
										<i class="fa fa-star inbox-started"></i>
									</td>
									<td class="view-message">
										<span class="glyphicon glyphicon-sort-by-order"></span> Sr.No.
									</td>
									<td class="view-message">
										<span class="glyphicon glyphicon-user"></span> User
									</td>

									<td class="view-message">
										<span class="glyphicon glyphicon-dashboard"></span> Score
									</td>	
									<td class="view-message"> &lambda; =0
									</td>	
									<td class="view-message text-right"> &lambda; =1
									</td>
								</tr>
							</thead>
							<tbody>
								<%
									Map<String, Set<String>> groupMembers = (Map<String, Set<String>>) session
											.getAttribute("GROUPMEMBERS");
									Map<String, Integer> groupIntraction = (Map<String, Integer>) session
											.getAttribute("GROUPINTRACTION");

									Map<String, Integer> groupIntractionPrevious = (Map<String, Integer>) session
											.getAttribute("GROUPINTRACTIONPrevious");
									session.setAttribute("GROUPINTRACTION", null);
									session.setAttribute("GROUPINTRACTIONPrevious", null);
									try {
										if (groupMembers != null && groupIntraction != null
												&& groupIntractionPrevious != null) {
											int i = 0;
											int inration = 0;
											int prevInration = 0;
											int groupmember = 1;
											
									float part1=0.1f;
									float part2=0.1f;
									
									DecimalFormat df = new DecimalFormat();
df.setMaximumFractionDigits(2);
											for (String key : groupMembers.keySet()) {
												i = i + 1;

												if (groupMembers.get(key) != null) {
													groupmember = groupMembers.get(key).size();
												} else {
													groupmember = 1;
												}

												if (groupmember < 1) {
													groupmember = 1;
												}

												if (groupIntraction.get(key) != null) {
													inration = groupIntraction.get(key);
												} else {
													inration = 0;
												}

												if (groupIntractionPrevious.get(key) != null) {
													prevInration = groupIntraction.get(key);
												} else {
													prevInration = 0;
												}
												
												
									if(prevInration==0){
									part1=0.1f;
									}else{
									part1=(1.0f*inration)/prevInration;
									}
									part2=(1.0f*inration)/groupmember;
									 
								%>
								<tr class="">
									<td class="inbox-small-cells">
										<i class="fa fa-star inbox-started"></i>
									</td>
									<td class="view-message dont-show">
										<%=i%>
									</td>
									<td class="view-message">
										<a href="#"> <%=key%></a>
									</td>
									<td class="view-message inbox-small-cells"> (1-&lambda;)(<%=inration%>/<%=prevInration %>)+(<%=inration%>/<%=groupmember%>)</td>
									<td class="view-message inbox-small-cells"> <%=df.format((1-0)*part1+part2)%> </td>
									<td class="view-message text-right"> <%=df.format((1-1)*part1+part2)%></td>


								</tr>
								<%
									}
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								%>
							</tbody>
						</table>
						<br />
					</div>
				</div>
			</div>
			<!--/Center Column-->


			<!-- Right Column -->
			<div class="col-sm-1">




				<!-- Carousel -->



			</div>
			<!--/Right Column -->

		</div>
		<!--/container-fluid-->

		<jsp:include page="footer.jsp"></jsp:include>

	</body>

</html>
