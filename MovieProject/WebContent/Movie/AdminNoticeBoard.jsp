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

</style>

</head>
<body>
	<jsp:include page="/Movie/AdminHeader.jsp"/>
	<h1>관리자 페이지</h1>
	<br>
	<br>	
	<h3>자유게시판 목록</h3>
	<table class="table table-hover"> 
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>아이디</th>
		<th>작성 날짜</th>
		<th>변경</th>
		<th>삭제</th>
		<tr>
	<c:forEach var="adminnoticeboard" items="${adminnoticeboard}">
			<tr>
		<td>${adminnoticeboard.nseq}</td>
		<td style="width:20%">${adminnoticeboard.subject}</td>
		<td style="width:30%">${adminnoticeboard.content}</td>
		<td>${adminnoticeboard.id}</td>
		<td>${adminnoticeboard.indate}</td>
		<td><button type="button" onclick="location.href='/webapp/MovieController?command=adminnoticeboarddetail&nseq=${adminnoticeboard.nseq}'">변경</button></td>
		<td><button type="button" onclick="location.href='/webapp/MovieController?command=adminnoticeboarddelete&nseq=${adminnoticeboard.nseq}'">삭제</button></td>
		</tr>
	</c:forEach>
		</tr>
	</table>
	<br>
	<br>
	<table class="table table-hover">
		
		
	
	</table>

</body>
</html>