<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center><h1>���̵� �ߺ�Ȯ��</h1></center>
	<br>
	<br>
	<div style="text-align: center;">
		<form method="post" action="/webapp/MovieController?command=idcheck">
		���̵� : <input type="text" name="id" maxlength="10" autofocus>
		<input type="submit" value="�ߺ�Ȯ��">
		</form>
	
	</div>
</body>
</html>