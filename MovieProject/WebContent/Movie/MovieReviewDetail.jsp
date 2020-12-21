<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-
GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	img{
		display:block;
		margin-left : auto;
		margin-right : auto;
	}
	.head{
		text-align : center;
		margin: 0px auto;
	}
</style>

</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp" />
	</div>
	<center>
		<h1>영화 리뷰</h1>
	</center>
	<c:choose>
		<c:when test="${sessionScope.movieuser != null}">
			<c:set var="movieuser" value="${sessionScope.movieuser}" />
				<c:forEach var="moviereviewdetail" items="${moviereviewdetail}">
			<div class="container" role="main">
					<img src="/webapp/imageFolder/${moviereviewdetail.image}" width="600px;" height="auto;" margin-left="30px;">
					<br>
					<div class="mb-3">
						<label for="title"></label> <input type="hidden"
							class="form-control" name="subject" id="title"
							value="${moviereviewdetail.recommend}" readonly>
					</div>
					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="subject" id="title"
							value="${moviereviewdetail.subject}" readonly>
					</div>
					<div class="mb-3">
						<label for="content">내용</label>
						<textarea class="form-control" rows="15" name="content"
							id="content" readonly>${moviereviewdetail.content}</textarea>
					</div>
					<div class="mb-3">
						<label for="tag">TAG</label> <input type="text"
							class="form-control" name="tag" id="tag"
							value="${moviereviewdetail.tag}" readonly>
					</div>
					<button type="button"
						onclick="location.href='/webapp/MovieController?command=moviereviewlist'"
						class="btn btn-sm btn-primary" id="btnList">목록</button>
					<button type="button"
						onclick="location.href='/webapp/MovieController?command=moviereviewrecommendation&recommend=${moviereviewdetail.recommend}&subject=${moviereviewdetail.subject}'"
						class="btn btn-sm btn-primary" id="btnList">추천</button>
						<button type="button"
						onclick="location.href='/webapp/MovieController?command=moviewishlist&image=${moviereviewdetail.image}&subject=${moviereviewdetail.subject}'"
						class="btn btn-sm btn-primary" id="btnList">보관함에 추가</button>
					<c:if test="${sessionScope.movieuser.id == moviereviewdetail.id}">
						<button type="button"
							onclick="location.href='/webapp/Movie/MovieReviewModify.jsp'"
							class="btn btn-sm btn-primary">수정</button>
						<button type="button"
							onclick="location.href='/webapp/MovieController?command=moviereviewdelete&subject=${moviereviewdetail.subject}'"
							class="btn btn-sm btn-primary">삭제</button>
					</c:if>
			</div>
			<br>
			<br>
			<hr>
			<div class="container" role="main">
				<button type="button"
					onclick="location.href='/webapp/MovieController?command=moviereviewreplyshow&subject=${moviereviewdetail.subject}'"
					class="btn btn-sm btn-primary">${reples}개의 댓글 보기</button>
			</div>
			
			<center>
				<h3>댓글</h3>
			</center>
			<div class="container" role="main">
				<form
					action="/webapp/MovieController?command=moviereviewreplyinsert&subject=${moviereviewdetail.subject}"
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