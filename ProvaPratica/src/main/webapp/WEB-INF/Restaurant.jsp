<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!-- BERGAMASCO JACOPO, 5AIA, A.S. 2024-2025 -->
<html data-bs-theme="dark">
<head>
	<meta charset="UTF-8">
	<title>Ristorante</title>
	<link href='css/bootstrapcss/bootstrap.min.css' rel='stylesheet' type='text/css' />
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="">${student}</a>
		</div>
	</nav>
	<!-- Navbar END -->

	<div class="p-3 mb-2 bg-success-subtle text-success-emphasis">
		<h1>${title}</h1>
	</div>


	<div class="container text-center">
		<div class="row align-items-start">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mt-5">Prenotazione</h1>

				<!-- Alert -->
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>

				<c:if test="${empty error && success}">
					<div class="alert alert-success" role="alert">Elemento inserito correttamente!</div>
				</c:if>

				<!-- Alert END -->

				<!-- Form -->
				<form method="POST">
					<div class="mb-3">
						<label for="name" class="form-label">Nome</label>
						<input name="name" type="text" class="form-control" id="name" required>
					</div>
					<div class="mb-3 mt-5">
						<label for="place" class="form-label">Seleziona il posto</label> 
						<select name="place" id="place" class="form-select" aria-label="Seleziona il posto">
							<option value="0" selected>Sala grande</option>
							<option value="1">Sala piccola</option>
							<option value="2">Terrazza coperta</option>
							<option value="3">Gazebo</option>
						</select>
					</div>

					<div class="mb-3">
						<label for="clients" class="form-label">Numero persone</label>
						<input name="clients" type="number" min="0" class="form-control" id="clients" aria-describedby="clientsHelp" required>
					</div>

					<div class="mb-3">
						<label for="telephone" class="form-label">Recapito telefonico</label>
						<input name="telephone" type="number" min="0" class="form-control" id="telephone" aria-describedby="telephoneHelp" required>
					</div>



					<div class="mb-3">
						<button type="submit" class="btn btn-primary">Prenota</button>
					</div>
				</form>
				<!-- Form END -->

			</div>
		</div>
	</div>




	<!-- Table -->
	<c:choose>
	<c:when test="${!prenotazioni.isEmpty()}">
		<h1 class="text-center mt-5">Prenotazioni</h1>
		<div class="col-md-6 offset-md-3"> <!-- Il tag viene chiuso in linea 135 -->
			<div class="mb-3 mt-5">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">Nome</th>
							<th scope="col">Telefono</th>
							<th scope="col">Persone</th>
							<th scope="col">Posto</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prenotazione" items="${prenotazioni}">
							<tr>
								<td><c:out value="${prenotazione.getNome()}" /></td>
								<td><c:out value="${prenotazione.getTel()}" /></td>
								<td><c:out value="${prenotazione.getClienti()}" /></td>
								<td><c:out value="${prenotazione.getNomePosto()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- Table END -->
			<div class="container text-center mb-3 mt-5">
				<form method="POST">
					<button class="btn btn-primary" name="cancel" value="true" id="cancelbooking">Annulla</button>
				</form>
			</div>
	</c:when>
	<c:otherwise>
		<div class="col-md-6 offset-md-3"> <!-- Il tag viene chiuso in linea 135 -->
	</c:otherwise>
	</c:choose>
		
		<div class="mb-3 mt-5">
			<div class="text-bg-info p-3 mt-5">
				<h3>Posti disponibili:</h3>
			</div>
			<div class="p-3 mb-2 bg-primary-subtle text-primary-emphasis">
				<h4>Sala grande: ${capienze[0]}</h4>
				<h4>Sala piccola: ${capienze[1]}</h4>
				<h4>Terrazza coperta: ${capienze[2]}</h4>
				<h4>Gazebo: ${capienze[3]}</h4>
			</div>
		</div>
	</div> <!-- In base alle condizioni del choose, il tag viene aperto in linea 89 o in linea 120 -->



	<script src='js/jquery-3.6.0.min.js' type='text/javascript'></script>
	<script src='js/bootstrapjs/bootstrap.bundle.min.js' type='text/javascript'></script>
</body>
</html>