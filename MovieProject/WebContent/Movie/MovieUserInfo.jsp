<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-
GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Insert title here</title>
<style>
	img{
	margin: auto;
	display: flex;
	flex-direction: row;
	justify-content: center;
	}

</style>

</head>
<body>
	<br>
	<center><h2>내 정보 수정</h2></center>
	<br>

		<img src="/webapp/image/man.png">
		<br>
		<div class="container" role="main">
			<form action="/webapp/MovieController?command=movieuserinfoupdate" method="post">
			<c:forEach var="userinfo" items="${userinfo}">
			<div class="mb-3">
				<label for="title">회원 번호</label> <input type="text"
					class="form-control" name="no" id="title"
					value="${userinfo.no}" readonly>
			</div>
			<div class="mb-3">
				<label for="title">ID</label> <input type="text"
					class="form-control" name="id" id="title"
					value="${userinfo.id}" readonly>
			</div>
			<div class="mb-3">
				<label for="tag">PW</label> <input type="text" class="form-control"
					name="pw" id="tag" value="${userinfo.pw}">
			</div>
			<div class="mb-3">
				<label for="tag">NAME</label> <input type="text" class="form-control"
					name="name" id="tag" value="${userinfo.name}" readonly>
			</div>
			<div class="mb-3">
				<label for="tag">EMAIL</label> <input type="text" class="form-control"
					name="email" id="tag" value="${userinfo.email}" >
			</div>
			<div class="mb-3">
				<label for="tag">PHONE</label> <input type="text" class="form-control"
					name="phone" id="tag" value="${userinfo.phone}">
			</div>
			<button type="button"
				onclick="location.href='/webapp/MovieController?command=moviemain'"
				class="btn btn-sm btn-primary" id="btnList">돌아가기</button>
				<button type="submit" class="btn btn-sm btn-primary">수정</button>
				<button type="button" onclick="location.href='/webapp/MovieController?command=movieuserdelete&id=${userinfo.id}'" class="btn btn-sm btn-primary">탈퇴</button>
				</c:forEach>
			</form>
		</div>
		<!-- <button>추천</button> -->

</body>
</html>