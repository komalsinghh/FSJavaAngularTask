<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="js/a.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>

	<nav
		class="navbar navbar-expand-lg d-flex justify-content-around navbar-light bg-light">

		<div class="m-auto text-dark fw-bold  fs-5  ps-5 ">Add Book
			Details</div>
		<div class="login text-dark  d-flex">
			<button type="submit" class="me-4 p-0 pe-3 ps-3 border-1 rounded-2"
				onclick="window.location.href='./logout'">logout</button>
		</div>
	</nav>


	<div class="container-fluid ">
		<div class="row py-2">

			<div class="col-12 p-3 me-4 d-flex ">
				<form action="addBookForm" method="post">
					<div class="fs-5 h5">Please enter Book details to add to
						Library</div>
					<input value="" name="id" type="hidden" />
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Book code</label>
						</div>
						<div class="col-8">
							<input type="text" name="bookCode" required value="" />
						</div>
					</div>
					<div class="row ">
						<div class="col-3">
							<label class="form-label">Name</label>
						</div>
						<div class="col-7 ">
							<input type="text" name="bookName" required value="" />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Author</label>
						</div>
						<div class="col-8">
							<input type="text" name="bookAuthor" required value="" />
						</div>
					</div>
					<%
					LocalDate data_added = LocalDate.now();
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM yyyy");
					String date = data_added.format(myFormatObj);
					%>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Date</label>
						</div>
						<div class="col-8">
							<input type="text" name="date" required readonly
								value="<%=date%>" />
						</div>
					</div>
					<div class="col-3 py-1 "
						style="width: 140px; margin-left: 100px; margin-top: 14px;">
						<button type="submit" class=" border-1 rounded-2">Add
							Book</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>