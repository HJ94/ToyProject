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
	body{
		
		margin-left : auto;
		margin-right : auto;
		text-align : center;
	}
	.head{
		background-color: #000000;
	}
	
</style>
</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp"/>
	</div>
	<br>
	<h1>자유게시판</h1>

	<br>
	<br>
	<table class="table table-hover"> 
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>추천수</th>
		<tr>
		<c:forEach var="paging" items="${paging}">
			<tr>
			<td>${paging.nseq}</td>
			<td><a href="/webapp/MovieController?command=movienoticeboarddetail&subject=${paging.subject}" style="color:#000000;">${paging.subject}</a></td>
			<td>${paging.id}</td>
			<td>${paging.indate}</td>
			<td>${paging.recommend}</td>
			</tr>
		</c:forEach>
		</tr>
	</table>
		<a href="/webapp/MovieController?command=noticeboardpage&page=1" style="color:#000000;">1</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=2" style="color:#000000;">2</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=3" style="color:#000000;">3</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=4" style="color:#000000;">4</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=5" style="color:#000000;">5</a>
		
		<br>
		<br>
		<button type="button" onclick="location.href='MovieNoticeBoard.jsp'" class="btn btn-outline-primary">글쓰기</button>
</body>
</html>