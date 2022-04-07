<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Nikodem Blog</title>
<meta charset="utf-8">
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

	<div class="container mt-3">
		<div class="row">
			<div class="col">

				<c:if test="${not empty error}">

					<div class="alert alert-danger" role="alert">${error}</div>

				</c:if>

				<form action="LoginServlet" method="post">
					<div class="mb-3 mt-3">
						<label for="username" class="form-label">Username:</label> <input
							type="text" class="form-control" id="username"
							placeholder="Enter Username" name="username">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password:</label> <input
							type="password" class="form-control" id="password"
							placeholder="Enter password" name="password">
					</div>

					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>


</body>
</html>
