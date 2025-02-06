<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Indovina il numero!</title>
</head>
<body>
	<h1>${info}</h1>
	<form>
		<label>Inserisci un numero:</label>
		<input name="num">
		<button type="submit">Conferma</button>
	</form>
	<a href="?"><button>Rigenera</button></a>
</body>
</html>