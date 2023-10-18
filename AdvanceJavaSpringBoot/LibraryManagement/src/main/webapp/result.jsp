<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
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
	if(session.getAttribute("uname" )==null){
		response.sendRedirect("index.jsp");
	}
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>

	<nav class="navbar navbar-light bg-light">
		<h2>Library</h2>

		<form method=post action="logout" class="logout">
			<input type="submit" class="btn btn-outline-primary" value="Logout">
		</form>

	</nav>

	<h2 class="text-center">Book Details</h2>


	<div class="container-fluid" style="height: 62vh;">
		<div class="row p-4">
			<table
				class="table table-bordered border-dark border-2 table-responsive-sm">
				<thead class="thead-dark ">
					<tr class="text-center border-2 ">
						<th scope="col" class="border-2 ">Book Code</th>
						<th scope="col" class="border-2 ">Name</th>
						<th scope="col" class="border-2 ">Author</th>
						<th scope="col" class="border-2 ">Date</th>
						<th scope="col" class="border-2 ">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${book_list}" var="p">
						<tr>
							<td class="text-center"><c:out value="${p.getBookCode()}" /></td>
							<td class="text-center"><c:out value="${p.getBookName()}" /></td>
							<td class="text-center"><c:out value="${p.getBookAuthor()}" /></td>
							<td class="text-center"><c:out value="${p.getDate()}" /></td>
							<td class="text-center ">

								<form method=post action=editBook class="edit">
									<input type="hidden" name="code" value="${p.getBookCode()}" />
									<input type=submit name="edit" class="btn btn-outline-primary"
										value="Edit">
								</form>
								<form method=post action=deleteBook class="delete">
									<input type="hidden" name="code" value="${p.getBookCode()}" />
									<input type=submit name="delete" class="btn btn-outline-danger "
										value="Delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="text-center">
      <button type="button" class="btn btn-primary text-center mt-4"
			onclick="window.location.href='AddBook.jsp'">Add Book</button>
    </div>
	
</body>
</html>