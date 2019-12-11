<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LogIn" method="POST">
		<input type="text"  name="username"/>
		<input type="text" name="password"/>
		<input type="submit" value="Log In" />
	</form>
	<form action="SignUp" method="POST">
		<input type="text"  name="hoten"  placeholder = "Họ Tên"/>
		<input type="text"  name="sdt"  placeholder = "Số điện thoại"/>
		<input type="text"  name="email"  placeholder = "Email"/>
		<input type="password" name="password"  placeholder = "Password"/>
		<input type="submit" value="Sign Up" />
	</form>
</body>
</html>