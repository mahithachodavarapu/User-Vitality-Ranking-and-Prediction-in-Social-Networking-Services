
<%@page import="com.anand.dto.AccountDto"%><div
	class="panel panel-default">
	<%
		AccountDto ad = (AccountDto) session.getAttribute("USERPROFILE");
	%>
	<div class="panel-heading">
		<h1 class="panel-title">
			<span class="glyphicon glyphicon-user"></span>
			<%=ad.getFullName()%>
		</h1>
	</div>
	<div class="panel-body">
		<div class="list-group">
			<img src="images/<%=ad.getPicture()%>" alt=""
			class="girl img-responsive img-thumbnail"></img>
			<b class="list-group-item">
			<span
				class="glyphicon glyphicon-phone"></span> <%=ad.getPhone()%></b>
			<b class="list-group-item"><span
				class="glyphicon  glyphicon-education"></span>  <%=ad.getEducation()%> </b>
			<b class="list-group-item"><span
				class="glyphicon glyphicon-globe"></span> <%=ad.getAddress()%> </b>
		</div>
	</div>
</div>