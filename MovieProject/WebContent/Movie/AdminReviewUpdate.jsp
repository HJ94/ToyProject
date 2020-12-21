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
	<jsp:include page="/Movie/AdminHeader.jsp" />
	<center><h1>관리자 페이지</h1></center>
	<br>
	<br>
	<center><h3>영화 리뷰 변경</h3></center>
			<br>
			 
			<div class="container" role="main">
				<form enctype="multipart/form-data" method="post" action="/webapp/MovieController?command=adminreviewupdate">
					<c:forEach var="adminreviewdetail" items="${adminreviewdetail}">
					<div class="mb-3">
						<label for="title">번호</label> <input type="text"
							class="form-control" name="no" id="title"
							value="${adminreviewdetail.no}" readonly>
					</div>
					<div class="mb-3">
						<label for="tag">아이디</label> <input type="text"
							class="form-control" name="id" id="tag"
							value="${adminreviewdetail.id}" readonly>
					</div>
					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="subject" id="title"
							value="${adminreviewdetail.subject}">
					</div>
					<div class="mb-3">
						<label for="content">내용</label>
						<textarea class="form-control" rows="5" name="content">
						${adminreviewdetail.content}</textarea>
					</div>
					<div class="mb-3">
						<label for="tag">현재 이미지</label> <img src=
						"/webapp/imageFolder/${adminreviewdetail.image}">
					</div>
					<div class="mb-3">
						<label for="title">이미지 수정</label> <input type="file"
							class="form-control" name="file">
					</div>
					<div class="mb-3">
						<label for="tag">태그</label> <input type="text"
							class="form-control" name="tag" id="tag"
							value="${adminreviewdetail.tag}">
					</div>
					<div class="mb-3">
						<label for="tag">댓글</label> <input type="text"
							class="form-control" name="reply" id="tag"
							value="${adminreviewdetail.reply}">
					</div>
					<div class="mb-3">
						<label for="tag">작성일</label> <input type="text"
							class="form-control" name="indate" id="tag"
							value="${adminreviewdetail.indate}" readonly>
					</div>
						<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
						<button type="button"
							onclick="location.href='/webapp/MovieController?command=movieadminmain'"
							class="btn btn-sm btn-primary" id="btnList">목록</button>
					</c:forEach>
					
				</form>
			</div>
</body>
</html>