<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
	<head>

		<script
			src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>
		<script type="text/javascript">
var url = 'about.htm';
$(window).load(function() {
	$("#displayarea").load(url + "?condation=no");
})
$(document).ready(
		function() {
			$("a").click(
					function() {

						var link = $('a').attr('href');

						if (link.indexOf("?") != -1) {
							var query = link.split("?")[1];

							eval("query = {"
									+ query.replace(/&/ig, "\",").replace(
											/=/ig, ":\"") + "\"};");

							if (query.page&&query.name)
								alert(unescape(query.page+" "+query.name));
							else
								alert('No page parameter');
								
								
								

						} else {
							alert('No querystring');
						}

						/*	var brand = 'a';							
								$.ajaxSetup( {
									cache : false
								});
								condation = "?condation=yes&" + condation;
								
								alert(condation);
								
							//	$("#displayarea").load(url + condation);

							} else {
								alert("Please select an option from the filter");
							}*/

					});
		});
</script>
	</head>

	<body>


		<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">

						<form>
							<!--shipping-->

							<div class="brands_products">
								<h2>
									Brands
								</h2>
								<div class="brands-name">
									<ul class="nav nav-pills nav-stacked">

										<li>
											<a href="a.htm?page=2345&name=asasf"><input type="checkbox" name="brand"
													value="ab" /> ab</a>
											<a href="#"><input type="checkbox" name="brand"
													value="cd" /> cd</a>
											<a href="#"><input type="checkbox" name="brand"
													value="ef" /> ef</a>
										</li>

									</ul>
								</div>
							</div>




							<button type="button" class="btn btn-default"
								style="background: #FE980F; border: medium none; border-radius: 0; color: #FFFFFF; display: block; font-family: 'Roboto', sans-serif; padding: 6px 25px;">
								Apply
							</button>
						</form>
						<!--/shipping-->

					</div>
				</div>


				<div class="col-sm-9 padding-right" id="displayarea"></div>

			</div>
		</div>
		</section>


		<!-- footer code add -->

	</body>
</html>