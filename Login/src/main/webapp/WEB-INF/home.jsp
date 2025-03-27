<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="/Login/bootstrap/css/bootstrap.min.css">
</head>
<body>
	
	<div class="container text-center">
		<h1 class="mt-3">Home</h1>
		
		<table>
			<tr>
				<th>Utente<th/>
			<tr/>
			
		</table>
		
		<div class="md-4 mt-4">
            <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#logout">
            	Logout
            </button>
		</div>
    </div>
	
	<!-- Modal -->
	<div class="modal fade" id="logout" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
	        	<h1 class="modal-title fs-5">Conferma</h1>
	        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      	</div>
	      	<div class="modal-body">
				Sei sicuro di voler uscire?
	      	</div>
	      	<div class="modal-footer">
	        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
	        	<a href="/Login/app/logout">
		        	<button type="button" class="btn btn-primary">Si</button>
	        	</a>
	      	</div>
	    </div>
	</div>
	</div>
	
	<script type="text/javascript" src="/Login/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>