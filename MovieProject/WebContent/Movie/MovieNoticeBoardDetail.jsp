<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="movie.dao.*"%>
<%@ page import="movie.dto.*"%>
<%@ page import="webapp.*"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-
GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<style>
	.head{
		text-align : center;
		
	}

</style>

</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp" />
	</div>
	<br>
	<br>
	<center><h1>자유게시판</h1></center>
	<br>



	<c:choose>
		<c:when test="${sessionScope.movieuser != null}">
			<c:set var="movieuser" value="${sessionScope.movieuser}" />

			<c:forEach var="movienoticeboarddetail"
				items="${movienoticeboarddetail}">

				<br>
				<div class="container" role="main">
					<div class="mb-3">
						<input type="hidden" value="${movienoticeboarddetail.recommend}">
					</div>
					<div class="mb-3">
						<input type="hidden" value="${movienoticeboarddetail.nseq}">
					</div>
					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="subject" id="title"
							value="${movienoticeboarddetail.subject}" readonly>
					</div>
					<div class="mb-3">
						<label for="content">내용</label>
						<textarea class="form-control" rows="10" name="content"
							id="content" readonly>${movienoticeboarddetail.content}</textarea>
					</div>
					<div class="mb-3">
						<label for="tag">TAG</label> <input type="text"
							class="form-control" name="tag" id="tag"
							value="${movienoticeboarddetail.tag}" readonly>
					</div>
					<button type="button"
						onclick="location.href='/webapp/MovieController?command=movienoticeboardlist'"
						class="btn btn-sm btn-primary" id="btnList">목록</button>
						<button type="button"
						onclick="location.href='/webapp/MovieController?command=movienoticeboardrecommendation&nseq=${movienoticeboarddetail.nseq}&recommend=${movienoticeboarddetail.recommend}&subject=${movienoticeboarddetail.subject}'"
						class="btn btn-sm btn-primary" id="btnList">추천</button>
					<c:if test="${movieuser.id eq movienoticeboarddetail.id}">
						<button type="button"
							onclick="location.href='/webapp/Movie/MovieNoticeBoardModify.jsp'"
							class="btn btn-sm btn-primary">수정</button>
						<button type="button"
							onclick="location.href='/webapp/MovieController?command=movienoticeboarddelete&subject=${movienoticeboarddetail.subject}'"
							class="btn btn-sm btn-primary">삭제</button>
					</c:if>

				</div>
				<!-- <button>추천</button> -->
				<br>
				<br>
				<hr>

				<div class="container" role="main">
					<button type="button"
						onclick="location.href='/webapp/MovieController?command=moviereplyshow&subject=${movienoticeboarddetail.subject}'"
						class="btn btn-sm btn-primary">${reples}개의 댓글 보기</button>
				</div>
				<center>
					<h3>댓글</h3>
				</center>

				<div class="container" role="main">
					<form
						action="/webapp/MovieController?command=moviereplyinsert&subject=${movienoticeboarddetail.subject}"
						method="post">
						<div class="mb-3">
							<label for="content">댓글</label>
							<textarea class="form-control" rows="3" name="replytxt"
								id="replytxt"></textarea>
							<button type="submit" class="btn btn-sm btn-primary" id="btnList">댓글
								달기</button>
						</div>
					</form>


					<c:forEach var="reply" items="${reply}">

						<div class="mb-3">
							<label for="content">작성자 : ${reply.id}(${reply.indate})</label>
							<textarea class="form-control" rows="3" name="content"
								id="content" readonly>"${reply.replytxt}</textarea>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>
</body>
</html>