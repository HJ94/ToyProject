<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-
GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="/Movie/AdminHeader.jsp"/>
	<center><h1>관리자 페이지</h1></center>
	<br>
	<br>	
	<article>

		<div class="container" role="main">

			<center><h3>회원 정보 변경</h3></center>
			<br>
			<c:forEach var="adminuserdetail" items="${adminuserdetail}">
			<form name="form" id="form" role="form" method="post"
				action="/webapp/MovieController?command=adminuserupdate">
				<div class="mb-3">
					<label for="title">번호</label> <input type="text"
						class="form-control" name="no" id="title" value="${adminuserdetail.no}" readonly>
				</div>
				<div class="mb-3">
					<label for="title">아이디</label> <input type="text"
						class="form-control" name="id" id="title" value="${adminuserdetail.id}">
				</div>
				<div class="mb-3">
					<label for="title">패스워드</label> <input type="text"
						class="form-control" name="pw" id="title" value="${adminuserdetail.pw}">
				</div>
				<div class="mb-3">
					<label for="tag">이름</label> <input type="text"
						class="form-control" name="name" id="tag" value="${adminuserdetail.name}">
				</div>
				<div class="mb-3">
					<label for="tag">이메일</label> <input type="text"
						class="form-control" name="email" id="tag" value="${adminuserdetail.email}">
				</div>
				<div class="mb-3">
					<label for="tag">전화번호</label> <input type="text"
						class="form-control" name="phone" id="tag" value="${adminuserdetail.phone}">
				</div>
				<div>
				<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" onclick="location.href='/webapp/MovieController?command=movieadminmain'" class="btn btn-sm btn-primary" id="btnList">목록</button>				</div>
			</form>
			</c:forEach>
		</div>
	</article>
</body>
</html>