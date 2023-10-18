<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.assignment3.entities.ProductDetails"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.nagarro.assignment3.utils.FactoryProvider"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/a.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("username") == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<nav
		class="navbar navbar-expand-lg d-flex justify-content-around navbar-light bg-light">

		<div class="m-auto text-dark fw-bold  fs-5  ps-5 ">Product
			Management Tool</div>
		<div class="login text-dark  d-flex">
			<label class=" p-1 me-3"> Hi ${username} </label>
			<button type="submit" class="me-4 p-0 pe-3 ps-3 border-1 rounded-2"
				onclick="window.location.href='./logout'">logout</button>
		</div>
	</nav>
	
	<%
		int id = Integer.parseInt(request.getParameter("id").trim());
		Session sesion = FactoryProvider.getFactory().openSession();
		ProductDetails productDetails = sesion.get(ProductDetails.class,id);
	%>
	<div class="container-fluid ">
		<div class="row py-2">

			<div class="col-12 p-3 me-4 d-flex ">
				<form action="UpdateProductDetails" method="post">
					<div class="fs-5 h5">Please enter product details to add to
						stock</div>
						<input value="<%=productDetails.getProductId() %>" name="id" type="hidden"/>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Title</label>
						</div>
						<div class="col-8">
							<input type="text" name="title" required  value="<%=productDetails.getTitle() %>"/>
						</div>
					</div>
					<div class="row ">
						<div class="col-3">
							<label class="form-label">Quantity</label>
						</div>
						<div class="col-7 ">
							<input type="number" name="quantity" required value="<%=productDetails.getQuantity() %>"/>
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Size</label>
						</div>
						<div class="col-8">
							<input type="number" name="size" required value="<%=productDetails.getSize() %>"/>
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Image</label>
						</div>
						<div class="col-5">
							<input type="file" name="image" id="imgUpload" accept="image/*"
								required />
						</div>
					</div>
					<div class="col-3 py-1 "
						style="width: 140px; margin-left: 100px; margin-top: 14px;">
						<button type="submit" class=" border-1 rounded-2">Update
							Product</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
</body>
</body>
</html>