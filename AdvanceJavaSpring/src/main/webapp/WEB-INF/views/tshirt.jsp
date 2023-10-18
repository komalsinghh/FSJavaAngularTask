<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tshirts</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
body {
	background-color: #B0DBEE;
}
</style>
</head>
<body>
<%
    	response.setHeader("Cache-Control" , "no-cache, no-store, must-revalidate");
 	%>
	<div class="container-fluid ">
		<div class="row py-2">

			<div class="col-12 p-3 me-4 d-flex ">
				<form action="search" method="post">
					<div class="fs-5 h5">Please fill the following details.</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Color</label>
						</div>
						<div class="col-8">
							<input type="text" name="color" required />
						</div>
					</div>
					<div class="row ">
						<div class="col-3">
							<label class="form-label">Gender</label>
						</div>
						<div class="col-7 ">
							<select name="gender">
								<option>M</option>
								<option>F</option>
								<option>U</option>
							</select>
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Size</label>
						</div>
						<div class="col-8">
							<select name="size">
								<option>S</option>
								<option>M</option>
								<option>L</option>
								<option>XL</option>
								<option>XXL</option>
							</select>
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Sort by</label>
						</div>
						<div class="col-5">
							<select name="preference">
								<option>Rating</option>
								<option>Price</option>
							</select>
						</div>
					</div>
					<div class="col-3 py-1 "
						style="width: 240px; margin-left: 100px; margin-top: 14px;">
						<button type="submit" class=" border-1 rounded-2">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid" style="height: 62vh;">
		<div class="row p-4">
			<c:if test="${empty tshirts}">
				<h3>No, Products to show.</h3>
			</c:if>
			<table
				class="table table-bordered border-dark border-2 table-responsive-sm">
				<thead class="thead-dark ">
					<tr class="text-center border-2 ">
						<th scope="col" class="border-2 ">Id</th>
						<th scope="col" class="border-2 ">Name</th>
						<th scope="col" class="border-2 ">Color</th>
						<th scope="col" class="border-2 ">Gender</th>
						<th scope="col" class="border-2 ">Size</th>
						<th scope="col" class="border-2 ">Price</th>
						<th scope="col" class="border-2 ">Rating</th>
						<th scope="col" class="border-2 ">Availability</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${tshirts}">
						<tr>
							<td><c:out value="${p.getTshirtId()}" /></td>
							<td><c:out value="${p.getModelName()}" /></td>
							<td><c:out value="${p.getTshirtColor()}" /></td>
							<td><c:out value="${p.getTshirtGender()}" /></td>
							<td><c:out value="${p.getTshirtSize()}" /></td>
							<td><c:out value="${p.getTshirtPrice()}" /></td>
							<td><c:out value="${p.getTshirtRating()}" /></td>
							<td><c:out value="${p.getTshirtAvailability()}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>