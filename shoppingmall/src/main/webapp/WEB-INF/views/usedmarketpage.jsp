<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<style>
body{
	margin : 0;
	padding : 0;
	height: 100%;
}
.wrap {
	width: 60%;
	margin: 0px auto;
}
.footer{
	width: 100%;
	left : 0;
	bottom : 0;
	padding : 0 0;
	text-align : center;
	position: absolute;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link
	href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="headerpage.jsp" />
	<br>
	<br>
	<br>

	<div class="wrap">

		<center><h1>중고장터</h1></center>
		<br>
		<table class="table">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
			<tr>
				<c:forEach var="list" items="${viewAll}">
					<tr>
						<td>${list.bseq}</td>
						<td><a
							href="usedmarket_detail?bseq=${list.bseq}"
							style="color: #000000;">${list.subject}</a></td>
						<td>${list.id}</td>
						<td>${list.indate}</td>
						<td>${list.hit}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	

	<c:choose>
		<c:when test="${sessionScope.memberId == null}">
			<script type="text/javascript">
				alert('로그인 후 이용 가능합니다.');
				location.href = 'http://localhost:8090/shopping/main';
			</script>
		</c:when>
		<c:when test="${sessionScope.memberId != null}">
			<c:set var="memberId" value="${sessionScope.memberId}" />
			<c:if test="${!empty memberId}">
				<center>
					<button type="button"
						onclick="location.href='http://localhost:8090/shopping/usedmarketwrite'"
						class="btn btn-outline-primary">글쓰기</button>
				</center>
			</c:if>
		</c:when>
	</c:choose>
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="boardList?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage}">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage}">
					<a href="boardList?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="boardList?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
	</div>
	
	<div class="footer">
	<jsp:include page="footerpage.jsp" />
	</div>

</body>
</html>