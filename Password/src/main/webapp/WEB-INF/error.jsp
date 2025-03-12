<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home page</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container text-center">
        <div class="row align-items-start">
            <div class="col-md-4 offset-md-4">
            	<div class="alert alert-danger text-center md-4 mt-4">
					<h4>Hai rotto tutto!</h4>
					${error}
            	</div>
            </div>
        </div>
    </div>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>