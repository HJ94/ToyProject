<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
	body{	
		margin-left : auto;
		margin-right : auto;
		text-align : center;
	}

</style>
</head>
<body>
	<jsp:include page="/Movie/AdminHeader.jsp"/>
	<h1>������ ������</h1>
	<br>
	<br>	
	<h3>ȸ�� ���</h3>
	<table class="table table-hover"> 
		<th>��ȣ</th>
		<th>���̵�</th>
		<th>�н�����</th>
		<th>�̸�</th>
		<th>�̸���</th>
		<th>��ȭ��ȣ</th>
		<th>���� ������</th>
		<th>����</th>
		<th>����</th>
		<tr>
	<c:forEach var="admin" items="${admin}">
			<tr>
		<td>${admin.no}</td>
		<td>${admin.id}</td>
		<td>${admin.pw}</td>
		<td>${admin.name}</td>
		<td>${admin.email}</td>
		<td>${admin.phone}</td>
		<td>${admin.createdate}</td>
		<td><button type="button" onclick="location.href='/webapp/MovieController?command=adminuserdetail&id=${admin.id}'">����</button></td>
		<td><button type="button" onclick="location.href='/webapp/MovieController?command=adminuserdelete&id=${admin.id}'">����</button></td>
		</tr>
	</c:forEach>
		</tr>
	</table>
</body>
</html>