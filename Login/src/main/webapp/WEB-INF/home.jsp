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
        <div class="row align-items-start">
            <div class="col-md-4 offset-md-4">
                <h3 class="text-center mt-5">Cambia password</h3>
                <form method="post">
                    <div class="mb-3">
                        <label for="current" class="form-label">Password attuale</label> 
						<input name="email" type="password" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nuova password</label>
                        <input name="newpw" type="password" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Conferma nuova password</label>
                        <input name="confirm" type="password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
		<div class="md-4 mt-4">
	    	<form method="post">
				<input type="hidden" name="logout" value="yes">
	            <button class="btn btn-danger">
	            	Logout
	            </button>
			</form>
		</div>
    </div>
	
	<script type="text/javascript" src="/Login/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>