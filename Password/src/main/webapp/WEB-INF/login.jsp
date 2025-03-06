<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container text-center">
        <div class="row align-items-start">
            <div class="col-md-4 offset-md-4">
            	<jstl:if test="${failed}">
				<div class="alert alert-danger text-center mt-5" role="alert">Accesso negato!</div>
				</jstl:if>
				
                <h1 class="text-center mt-5">Login Page</h1>
                <form method="post">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email address</label> 
						<input name="user" type="email" class="form-control" aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>

	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>