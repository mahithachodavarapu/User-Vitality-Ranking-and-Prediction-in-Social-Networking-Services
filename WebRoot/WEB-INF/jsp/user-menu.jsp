<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
<div class="container">
	<!-- Logo and responsive toggle -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="user-home.htm"> <span
			class="glyphicon glyphicon-fire"></span> </a>
	</div>
	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="navbar">
		<ul class="nav navbar-nav">
			<li>
				<a href="user-home.htm">Home</a>
			</li>
			<li class="dropdown">
				<a href="user-home.htm" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Article <span class="caret"></span> </a>
				<ul class="dropdown-menu" aria-labelledby="about-us">
					<li>
						<a href="post-article.htm">Post new article</a>
					</li><!--
					<li>
						<a href="#">View posted articles</a>
					</li>
				--></ul>
			</li>
			<li class="dropdown">
				<a href="user-home.htm" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Message <span class="caret"></span> </a>
				<ul class="dropdown-menu" aria-labelledby="about-us">
					<li>
						<a href="send-message.htm">Compose message</a>
					</li>
					<li>
						<a href="inbox.htm">Inbox</a>
					</li>
					<!--<li>
						<a href="#">Sent message</a>
					</li>
				--></ul>
			</li>
			<li class="dropdown">
				<a href="user-home.htm" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Friend <span class="caret"></span> </a>
				<ul class="dropdown-menu" aria-labelledby="about-us">
					<li>
						<a href="view-friend-request.htm">Friend request</a>
					</li>
					<li>
						<a href="view-friends.htm">All friend</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="logout.htm"><span class="glyphicon glyphicon-log-out"></span>
					Logout</a>
			</li>
		</ul>
		<form class="navbar-form navbar-right" action="search-friends.htm">
			<div class="form-group">
				<input type="text" class="form-control" name="searchName" id="searchName">
			</div>
			<button type="submit" class="btn btn-default">
			<span class="glyphicon glyphicon-search"></span> <i>search friends</i>
			</button>
		</form>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container -->
</nav>