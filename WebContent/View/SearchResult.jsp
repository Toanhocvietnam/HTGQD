<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach var="rs" items="${searchResult}">
			<li>${rs}</li>
		</c:forEach>
	</ul>
</body>
</html>