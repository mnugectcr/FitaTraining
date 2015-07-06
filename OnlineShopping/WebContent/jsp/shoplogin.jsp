<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Sign in before you shop!!</h1>
	</div>
	<form action="/OnlineShopping/login" method="post">
		<div align="center">
			username: <input type="text" name="username"
				style="padding: 10px; font-size: medium;">
		</div>
		<div align="center">
			password: <input type="password" name="password"
				style="margin-top: 20px; padding: 10px; font-size: medium;">
		</div>
		<div align="center">
			<input type="submit" value="Sign in"
				style="margin-top: 20px; width: 100px; height: 30px; margin-left: 32px;">
		</div>
		<div align="center" style="margin-top: 20px">
			<a href="/OnlineShopping/register" style="margin-left: 50px;">
				Don't have an account/Register</a>
		</div>


	</form>
</body>
</html>