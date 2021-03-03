<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>아이디 중복확인</h1>
	</center>
	<br>
	<br>
	<div style="text-align: center;">
		<form method="post" action="idcheck">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
				아이디 : <input type="text" name="id" maxlength="10" autofocus> 
				<input type="submit" value="중복확인">
		</form>

	</div>
</body>
</html>