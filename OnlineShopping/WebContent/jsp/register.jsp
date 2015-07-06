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
		<h1>Welcome...</h1>
	</div>
	<div align="center">Please fill the form to register</div>
	<form action="/OnlineShopping/getvalue" method="post">
		<div align="center">
			username: <input type="text" name = "username"
				style="margin-top: 10px; margin-left: 52px; margin-bottom: 5px;">
		</div>
		<div align="center">
			email_id: <input type="text" name = "email"
				style="margin-top: 10px; margin-left: 57px; margin-bottom: 5px;">
		</div>
		
		<div align="center">
			mobile_no: <input type="text" name = "mobile"
				style="margin-top: 10px; margin-left: 45px; margin-bottom: 5px;">
		</div>
		<div align="center">
			password: <input type="password" name = "password"
				style="margin-top: 10px; margin-left: 53px; margin-bottom: 5px;">
		</div>
		<div align="center">
			<input type="submit"
				style="margin-top: 10px; margin-left: 10px; margin-bottom: 5px;">
		</div>
	</form>
</body>
</html>