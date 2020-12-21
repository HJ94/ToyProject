<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="movie.dao.*"%>
<%@ page import="movie.dto.*"%>
<%@ page import="webapp.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<style>
	.head{
		background-color: #000000;	
	}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-
GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp" />
	</div>
	<center>
		<h1>자유게시판</h1>
	</center>

	<c:choose>
		<c:when test="${sessionScope.movieuser != null}">
			<c:set var="movieuser" value="${sessionScope.movieuser}" />
			<c:forEach var="movienoticeboarddetail"
				items="${movienoticeboarddetail}">

				<br>
				<div class="container" role="main">
					<form action="/webapp/MovieController?command=movienoticeboardmodify" method="post">
					<div class="mb-3">
						<label for="title">번호</label> <input type="text"
							class="form-control" name="nseq" id="title"
							value="${movienoticeboarddetail.nseq}"  readonly>
					</div>
					
					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="subject" id="title"
							value="${movienoticeboarddetail.subject}">
					</div>
					<div class="mb-3">
						<label for="content">내용</label>
						<textarea class="form-control" rows="5" name="content"
							id="content">${movienoticeboarddetail.content}</textarea>
					</div>
					<div class="mb-3">
						<label for="tag">TAG</label> <input type="text"
							class="form-control" name="tag" id="tag"
							value="${movienoticeboarddetail.tag}">
					</div>
					<button type="button" onclick="location.href='/webapp/MovieController?command=movienoticeboardlist'" class="btn btn-sm btn-primary" id="btnList">목록</button>
					<c:if test="${movieuser.id eq movienoticeboarddetail.id}">
						<button type="submit" class="btn btn-sm btn-primary">수정</button>
					</c:if>
					</form>
				</div>
				<!-- <button>추천</button> -->

			</c:forEach>
		</c:when>
	</c:choose>
</body>
</html>