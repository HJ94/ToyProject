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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
body {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

.head {
	text-align: center;
}
</style>
</head>
<body>
	<div class="head">
		<jsp:include page="/Movie/MovieHeader.jsp" />
	</div>
	<br>
	<center>
		<h1>Q&A</h1>
	</center>
	<form action="/webapp/MovieController?command=movieqnaanswer"
		method="post">
		
					
				
		<div class="container" role="main">
		<c:forEach var="adminqnareply" items="${adminqnareply}">
			<div class="mb-3">
				<label for="title">번호</label> <input type="text"
					class="form-control" name="qseq" id="qseq"
					value="${adminqnareply.qseq}" readonly>
			</div>
			<div class="mb-3">
				<label for="tag">ID</label> <input type="text" class="form-control"
					name="id" id="tag" value="${adminqnareply.id}" readonly>
			</div>
			<div class="mb-3">
				<label for="title">제목</label> <input type="text"
					class="form-control" name="subject" id="title"
					value="${adminqnareply.subject}" readonly>
			</div>
			<div class="mb-3">
				<label for="content">내용</label>
				<textarea class="form-control" rows="10" name="content" id="content"
					readonly>${adminqnareply.content}</textarea>
			</div>
			<div class="mb-3">
				<label for="content">답변 달기</label>
				<textarea class="form-control" rows="10" name="reply" id="reply"></textarea>
			</div>
			<div class="mb-3">
				<label for="title">작성날짜</label> <input type="text"
					class="form-control" name="indate" id="title"
					value="${adminqnareply.indate}" readonly>
			</div>
			</c:forEach>
		</div>
		<button type="submit">답변 달기</button>
	</form>
</body>
</html>