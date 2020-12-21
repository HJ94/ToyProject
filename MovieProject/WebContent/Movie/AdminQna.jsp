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
	<h3>Q&A 목록</h3>
	<table class="table table-hover"> 
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>아이디</th>
		<th>답변 여부</th>
		<th>작성 날짜</th>
		<tr>
	<c:forEach var="adminqna" items="${adminqna}">
			<tr>
		<td>${adminqna.qseq}</td>
		<td>${adminqna.subject}</td>
		<td>${adminqna.content}</td>
		<td>${adminqna.id}</td>
		<td>
		<c:if test="${adminqna.rep eq 1}">
			NO<button type=button onclick="location.href='/webapp/MovieController?command=movieadminqnareply&subject=${adminqna.subject}'">답변 달기</button>
		</c:if>
		<c:if test="${adminqna.rep eq 2}">
			YES
		</c:if>
		</td>
		<td>${adminqna.indate}</td>
		</tr>
	</c:forEach>
		</tr>
	</table>
</body>
</html>