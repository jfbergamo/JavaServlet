<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Template</title>
<link href='css/bootstrapcss/bootstrap.min.css' rel='stylesheet'
	type='text/css' />
</head>
<body>

	<!-- Navigation bar -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="">${student}</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="App">Add</a></li>
					<li class="nav-item"><a class="nav-link"
						href="App?page=checkout">Checkout</a></li>
					<li class="nav-item"><a class="nav-link disabled">Disabled</a>
					</li>
				</ul>

			</div>
		</div>
	</nav>
	<!-- Navigation bar END -->

	<div class="text-bg-primary p-3">
		<h1>${title}</h1>
	</div>

	<!-- Form -->
	<div class="container text-center">
		<div class="row align-items-start">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mt-5">Form Example</h1>

				<form>
					<div class="mb-3">
						<label for="exampleInputEmail" class="form-label">Email
							address</label> 
						<input name="user" type="email" class="form-control"
							id="exampleInputEmail" aria-describedby="emailHelp" required>
						<div id="emailHelp" class="form-text">We'll never share your
							email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Password</label>
						<input name="password" type="password" class="form-control"
							id="exampleInputPassword1" required>
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check
							me out</label>
					</div>
					<div class="mb-3">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Form END -->

	<!-- Alert -->
	<c:if test="${not empty error}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>

	<c:if test="${not empty warning}">
		<div class="alert alert-warning" role="alert">${warning}</div>
	</c:if>
	
	<div class="alert alert-success" role="alert">Success Alert!</div>

	<div class="alert alert-info" role="alert">Info Alert!</div>

	<!-- Alert END -->

	<!-- Table -->
	<h1 class="text-center mt-5">Table Example</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">Pippo</th>
				<th scope="col">Pluto</th>
				<th scope="col">Paperino</th>
				<th scope="col">Minnie</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td><c:out value="${item}" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Table END -->

	<script src='js/jquery-3.6.0.min.js' type='text/javascript'></script>
	<script src='js/bootstrapjs/bootstrap.bundle.min.js'
		type='text/javascript'></script>
</body>
</html>