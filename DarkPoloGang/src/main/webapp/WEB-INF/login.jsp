<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<div class ="operations">
	<c:choose>
	<c:when test="${!logged}">
	<form method="POST">
		<input type="text" name="username" placeholder="Username" required>
		<input type="password" name="pwd" placeholder="PWD" required>
		<button>|OK|</button>
	</form>
	</c:when>
	<c:otherwise>
	<form method="post">
		<input type="hidden" name="logout" value="true">
		<button>Logout</button>
	</form>
	</c:otherwise>
	</c:choose>
	${errorMessaggio}
	
	
	<table>
		<c:forEach var="value" items="${accounti}">
			<tr>
				<td><c:out value="${value.getNome()}"/></td>
				<td><c:out value="${value.getCognome()}"/></td>
				<td><c:out value="${value.getEmail()}"/></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>