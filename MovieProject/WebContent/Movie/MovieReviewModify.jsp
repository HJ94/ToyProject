<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Insert title here</title>
<style>
	.head{
		background-color: #000000;	
	}

</style>
</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp" />
	</div>
	<center><h1>자유게시판</h1></center>
	
	<c:choose>
		<c:when test="${sessionScope.movieuser != null}">
			<c:set var="movieuser" value="${sessionScope.movieuser}" />
			<c:forEach var="moviereviewdetail" items="${moviereviewdetail}">
				<br>
				<div class="container" role="main">
					<form action="/webapp/MovieController?command=moviereviewmodify" method="post" 
					enctype="multipart/form-data">
					<div class="mb-3">
						<label for="title">번호</label> <input type="text"
							class="form-control" name="no" id="title"
							value="${moviereviewdetail.no}"  readonly>
					</div>
					<div class="mb-3">
						<label for="title">현재 이미지</label> <input type="text"
							class="form-control" name="image" id="title"
							value="/webapp/imageFolder${moviereviewdetail.image}" readonly>
					</div>
					<div class="mb-3">
						<label for="title">이미지 수정</label> <input type="file"
							class="form-control" name="file">
					</div>
					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="subject" id="title"
							value="${moviereviewdetail.subject}">
					</div>
					<div class="mb-3">
						<label for="content">내용</label>
						<textarea class="form-control" rows="5" name="content"
							id="content">${moviereviewdetail.content}</textarea>
					</div>
					<div class="mb-3">
						<label for="tag">TAG</label> <input type="text"
							class="form-control" name="tag" id="tag"
							value="${moviereviewdetail.tag}">
					</div>
					<button type="button" onclick="location.href='/webapp/MovieController?command=moviereviewlist'" class="btn btn-sm btn-primary" id="btnList">목록</button>
					<c:if test="${movieuser.id eq moviereviewdetail.id}">
						<button type="submit" class="btn btn-sm btn-primary">수정</button>
					</c:if>
					</form>
				</div>
				
				
			</c:forEach>
		
		</c:when>
	</c:choose>
</body>
</html>