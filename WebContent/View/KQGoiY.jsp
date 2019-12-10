<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<th>Email</th>
		<th>SoBanBeChung</th>
		<th>SoBaiBaoVietChung</th>
		<th>SoBaiBaoCungLinhVuc</th>
		<th>Do do Tuong tu Giai Phap Ly Tuong</th>
		
	</tr>
	<c:forEach var="tg" items="${tgList}">
		<tr>
			<td>${tg.getEmail()}</td>
			<td>${tg.getSoBanBeChung()}</td>
			<td>${tg.getSoBaiBaoVietChung()}</td>
			<td>${tg.getSoBaiBaoVeLinhVuc()}</td>
			<td>${tg.getDoDoGiaiPhapLyTuong()}</td>
		</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>