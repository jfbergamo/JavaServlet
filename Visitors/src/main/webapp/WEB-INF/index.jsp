<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Conta Visitatori</title>
</head>
<body>
	<h1>${count}</h1>
	<a href="?reset=true"><input type="button" value="Reset"></a>
	<table>
		<j:forEach items="${visitors}" var="visitor">
		<tr>
			<td><j:out value="${visitor}"/></td>	
		</tr>
		</j:forEach>
	</table>
</body>
</html>