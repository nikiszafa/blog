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

	<div class="container mt-5">
		<div class="row">
			<div class="col">
				<h3>Add Post</h3>
				<form action="AdminServlet" method="post">
					<div class="form-group">
						<label for="title">Title</label> <input maxlength=100 type="text"
							class="form-control" id="title" placeholder="Title" name="title"
							required>
					</div>

					<div class="form-group">
						<label for="autor">Autor</label> <input maxlength=100 type="text"
							class="form-control" id="autor" placeholder="Autor" name="autor"
							required>
					</div>
					<div class="form-group">
						<label for="date">Data</label> <input type="date"
							class="form-control" id="date" value="2022-03-16" name="date"
							required>
					</div>

					<div class="form-group">
						<label for="text">Content</label>
						<textarea maxlength="500" class="form-control" id="text" rows="3"
							name="text" required></textarea>
					</div>
					<div class="form-group">
						<label for="postImg">Image Link</label> <input maxlength=1000
							type="text" class="form-control" id="postImg"
							placeholder="Image Link" name="postImg" required>
					</div>
					<h3></h3>
					<button type="submit" class="btn btn-primary">Add Post</button>

				</form>
			</div>
			<div class="col">
				<h3>Add Card</h3>
				<form action="AddCardServlet" method="post">
					<div class="form-group">
						<label for="title">Title</label> <input maxlength=100 type="text"
							class="form-control" id="title" placeholder="Title" name="title"
							required>
					</div>

					<div class="form-group">
						<label for="imgPath">Img Link</label> <input maxlength=300
							type="text" class="form-control" id="imgPath"
							placeholder="Image Link" name="imgPath" required>
					</div>

					<div class="form-group">
						<label for="content">Content</label> <input maxlength=400
							type="text" class="form-control" id="content"
							placeholder="Content" name="content" required>
					</div>
					<div class="form-group">
						<label for="buttonText">Button Text</label> <input maxlength="100"
							type="text" class="form-control" id="buttonText"
							placeholder="Button Text" name="buttonText" required>
					</div>

					<div class="form-group">
						<label for="buttonLink">Button Link</label> <input maxlength="300"
							type="text" class="form-control" id="buttonLink"
							placeholder="Button Link" name="buttonLink" required>
					</div>
					<h3></h3>
					<button type="submit" class="btn btn-primary">Add Card</button>

				</form>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<form action="UploadServlet" method="post"
					enctype="multipart/form-data">

					<h3></h3>
					<h3>Add Gallery Image</h3>
					<label for="formFile" class="form-label">Upload Gallery
						Image</label> <input class="form-control" type="file" id="formFile"
						name="file">
					<h3></h3>

					<label for="imageDescription">Image Description </label> <input
						maxlength="100" type="text" class="form-control"
						id="imageDescription" placeholder="image Description"
						name="imageDescription" required>

					<button type="submit" class="btn btn-primary">Upload</button>
					<h3></h3>

				</form>

			</div>

			<div class="col"></div>

		</div>
	</div>

</body>
</html>
