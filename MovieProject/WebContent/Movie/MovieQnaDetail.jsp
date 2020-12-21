<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	body{
		margin-left : auto;
		margin-right : auto;
		text-align :center;
		background-color: #000000;
	}

</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp"/>
	</div>
	<center><h1>1:1문의</h1></center>
	<c:choose>
		<c:when test="${sessionScope.movieuser != null}">
			<c:set var="movieuser" value="${sessionScope.movieuser}" />
				<c:forEach var="qnadetail" items="${qnadetail}">
				<br>
				<div class="container" role="main">
					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="subject" id="title"
							value="${qnadetail.subject}" readonly>
					</div>
					<div class="mb-3">
						<label for="content">문의 내용</label>
						<textarea class="form-control" rows="5" name="content"
							id="content" readonly>${qnadetail.content}</textarea>
					</div>
					<button type="button" onclick="location.href='/webapp/MovieController?command=movieqnalist'" class="btn btn-sm btn-primary" id="btnList">목록</button>
					<br>
					<br>
					<div class="mb-3">
						<label for="content">문의 답변</label>
						<textarea class="form-control" rows="5" name="content"
							id="content" readonly>${qnadetail.reply}</textarea>
					</div>
				</div>
		</c:forEach>
		</c:when>
	</c:choose>
</body>
</html>