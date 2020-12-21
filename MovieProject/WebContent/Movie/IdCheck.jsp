<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center><h1>아이디 중복확인</h1></center>
	<br>
	<br>
	<div style="text-align: center;">
		<form method="post" action="/webapp/MovieController?command=idcheck">
		아이디 : <input type="text" name="id" maxlength="10" autofocus>
		<input type="submit" value="중복확인">
		</form>
	
	</div>
</body>
</html>