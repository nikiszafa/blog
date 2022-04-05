<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Nikodem Blog</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<!-- A grey horizontal navbar that becomes vertical on small screens -->
	<nav class="navbar navbar-expand-sm bg-light">

		<div class="container-fluid">
			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="HomeServlet">About
						me</a></li>
				<li class="nav-item"><a class="nav-link" href="BlogServlet">Blog</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="GalleryServlet">Gallery</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="WeatherServlet">Weather</a>
				</li>

				<c:if test="${empty username}">
					<li class="nav-item"><a class="nav-link" href="LoginServlet">Login</a>
					</li>
				</c:if>

				<c:if test="${not empty username }">
					<li class="nav-item"><a class="nav-link"
						href="ViewProfileServlet">Profile Details</a></li>

					<li class="nav-item"><a class="nav-link" href="AdminServlet">Admin</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
					</li>

				</c:if>

			</ul>
		</div>

	</nav>

	<header class="bg-primary bg-gradient text-white py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-3 text-left text-md-center mb-3">
					<img class="rounded-circle img-fluid"
						src="https://www.looper.com/img/gallery/the-other-back-to-the-future-reference-you-missed-in-rick-and-morty/l-intro-1618319353.jpg"
						alt="Profile Photo" />
				</div>
				<div class="col-md-9">
					<h1>Nikodem</h1>
					<h5>New IT Blogger</h5>
					<p class="border-top pt-3">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Sed odio lacus, sollicitudin in dolor
						at, consequat volutpat ante. Integer quis consequat turpis, quis
						porta orci. Proin tincidunt volutpat faucibus. Suspendisse ac nisl
						purus suspendisse eleifend interdum orci non pharetra.</p>
				</div>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-12 col-md-4 col-sm-12 col-xs-12">
				<div class="card">

					<h2>Warsaw</h2>
					<h3>
						<span>Wind ${currentWeather.windspeed} km/h</span>
					</h3>
					<h3>
						<span>Elevation ${weather.elevation} m</span>
					</h3>
					<h1>Temperature ${currentWeather.temperature} °C</h1>
					<div class="sky">
						<div class="sun"></div>
						<div class="cloud">
							<div class="circle-small"></div>
							<div class="circle-tall"></div>
							<div class="circle-medium"></div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
