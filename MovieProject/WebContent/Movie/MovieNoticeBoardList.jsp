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
<script>
	

</script>
<style>
	body{	
		margin-left : auto;
		margin-right : auto;
		text-align : center;
	}
	.btn a{
		word-spacing : 5px;
		color : #000000;
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
		<c:forEach var="noticeboardlist" items="${noticeboardlist}">
			<tr>
			<td>${noticeboardlist.nseq}</td>
			<td><a href="/webapp/MovieController?command=movienoticeboarddetail&subject=${noticeboardlist.subject}&nseq=${noticeboardlist.nseq}" style="color:#000000;">${noticeboardlist.subject}</a></td>
			<td>${noticeboardlist.id}</td>
			<td>${noticeboardlist.indate}</td>
			<td>${noticeboardlist.recommend}</td>
			</tr>
		</c:forEach>
		</tr>
	</table>
	<div class = "btn">
		<a href="/webapp/MovieController?command=noticeboardpage&page=1" style="color:#000000;">1</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=2" style="color:#000000;">2</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=3" style="color:#000000;">3</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=4" style="color:#000000;">4</a>
		<a href="/webapp/MovieController?command=noticeboardpage&page=5" style="color:#000000;">5</a>		
	</div>
	<br>
	<br>
		<c:choose>
		<c:when test="${sessionScope.movieuser == null}">
			<script type="text/javascript">
				alert('로그인 후 이용 가능합니다.');
				location.href='MovieLogin.jsp';
			</script>
		</c:when>
		<c:when test="${sessionScope.movieuser != null}">
			<c:set var="movieuser" value="${sessionScope.movieuser}" />	
				<c:if test="${!empty movieuser}">
				<button type="button" onclick="location.href='MovieNoticeBoard.jsp'" class="btn btn-outline-primary">글쓰기</button>
				</c:if>
			</c:when>
		</c:choose>
		
			<c:if test="${sessionScope.reply != null}">
				<c:remove var="reply" scope="session"/>
			</c:if>
		
</body>
</html>