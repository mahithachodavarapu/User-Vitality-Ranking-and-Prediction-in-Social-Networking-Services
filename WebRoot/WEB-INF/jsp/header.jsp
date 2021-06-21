			<% String userType=(String)session.getAttribute("USER");
			if(userType==null){
			%>
			<jsp:include page="menu.jsp"></jsp:include>
			<%
			}else if(userType.equalsIgnoreCase("ADMIN")){
			%>
			<jsp:include page="admin-menu.jsp"></jsp:include>
			<%
			}else if(userType.equalsIgnoreCase("USER")){
			%>
			<jsp:include page="user-menu.jsp"></jsp:include>
			<%
			}else{
			%>
			<jsp:include page="menu.jsp"></jsp:include>
			<%
			}
			 %>