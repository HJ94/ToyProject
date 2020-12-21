<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="EUC-KR">
<title>Insert title here</title>

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
	<c:if test="${sessionScope.movieuser == null}">
			<script type="text/javascript">
				alert('로그인 후 이용 가능합니다.');
				location.href='MovieLogin.jsp';
			</script>
	</c:if>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp"/>
	</div>
	<br>
	<h1>1:1문의</h1>
	<br>
	<h5>자세한 사항은 본인이 작성한 글만 볼 수 있습니다.</h5>
	<br>
	<c:choose>
		<c:when test="${sessionScope.movieuser != null}">
		<c:set var="movieuser" value="${sessionScope.movieuser}" />
		<table class="table table-hover">
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>답변여부</th>
		<th>등록일</th>
		
		<c:forEach var="qnalist" items="${qnalist}">
		<tr>
		<td>${qnalist.qseq}</td>
		<td>
		<c:if test="${sessionScope.movieuser.id == qnalist.id}">
		<a href="/webapp/MovieController?command=movieqnadetail&subject=${qnalist.subject}" style="color:#000000;">${qnalist.subject}</a>
		</c:if>
		<c:if test="${sessionScope.movieuser.id != qnalist.id}">
			비밀 글입니다.
			<!-- <script type="text/javascript">
			alert('본인이 작성한 문의만 볼 수 있습니다.');
			return false;
		</script> -->
		</c:if></td>
		<td>
		<c:if test="${sessionScope.movieuser.id == qnalist.id}">
		${qnalist.content}
		</c:if>
		<c:if test="${sessionScope.movieuser.id != qnalist.id}">
		****
		</c:if>
		</td>
		<td>${qnalist.id}</td>
		<td><c:if test="${qnalist.rep == 2}">
		YES
		</c:if>
		<c:if test="${qnalist.rep==1}">
		NO
		</c:if>
		</td>
		<td>${qnalist.indate}</td>
		</tr>
		</c:forEach>
		</table>
		</c:when>
		</c:choose>
		<button type="button" onclick="location.href='MovieQna.jsp'" class="btn btn-outline-primary">문의하기</button>
	
</body>
</html>