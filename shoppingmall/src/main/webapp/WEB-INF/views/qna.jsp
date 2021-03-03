<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
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
<meta charset="EUC-KR">
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
	<center><h1>Q&A</h1></center>
	<br>
	<c:if test="${sessionScope.memberId == null}">
	<script type="text/javascript">
				alert('로그인 후 이용 가능합니다.');
				location.href = 'http://localhost:8090/shopping/main';
			</script>
	</c:if>
	<div class="wrap">
		<table class="table">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<tr>
				<c:forEach var="qnalist" items="${qnalist}">
					<tr>
						<td>${qnalist.qseq}</td>
						<c:if test="${sessionScope.memberId == qnalist.id}">
						<td><a
							href="qna_detail?qseq=${qnalist.qseq}"
							style="color: #000000;">${qnalist.subject}</a></td>
						</c:if>
						<c:if test="${sessionScope.memberId != qnalist.id}">
						<td>비밀글입니다.</td>
						</c:if>
						<td>${qnalist.id}</td>
						<td>${qnalist.indate}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<c:choose>
		<c:when test="${sessionScope.memberId != null}">
			<c:set var="memberId" value="${sessionScope.memberId}" />
			<c:if test="${!empty memberId}">
				<center>
					<button type="button"
						onclick="location.href='http://localhost:8090/shopping/qnawrite'"
						class="btn btn-outline-primary">문의하기</button>
				</center>
			</c:if>
		</c:when>
		</c:choose>
	</div>

	<%-- <c:choose>
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
 --%>
	<div class="footer">
	<jsp:include page="footerpage.jsp" />
	</div>

</body>
</html>