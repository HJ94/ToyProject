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
body {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}
	.search{
		width : 500px;
		margin-left: auto;
		margin-right: auto;
		text-align: center;
	}
</style>

</head>
<body>
	<c:if test="${sessionScope.movieuser == null}">
		<script type="text/javascript">
			alert('로그인 후 이용 가능합니다.');
			location.href = 'MovieLogin.jsp';
		</script>
	</c:if>
	<c:if test="${sessionScope.reply != null}">
		<c:remove var="reply" scope="session" />
	</c:if>
	<jsp:include page="/Movie/MovieHeader.jsp" />
	<br>
	<h1>영화 리뷰</h1>
	<br>
	<br>
	<table class="table table-hover">
		<th>썸네일</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>추천수</th>



		<c:forEach var="reviewsearch" items="${reviewsearch}">
			<tr>
				<td><img
					src="/webapp/imageFolder/${reviewsearch.image}"
					width=100px; height=100px;></td>
				<td><a
					href="/webapp/MovieController?command=moviereviewdetail&subject=${reviewsearch.subject}"
					style="color: #000000;">${reviewsearch.subject}</a></td>
				<td>${reviewsearch.id}</td>
				<td>${reviewsearch.indate}</td>
				<td>${reviewsearch.recommend}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="search" style="float:center;">
		<form action ="/webapp/MovieController?command=reviewsearch" method="post">
		<input id="input-keyword" type="text" class="form-control" aria-label="Recipient's username" name="keyword"
			aria-describedby="basic-addon2"><button  id="btn" class="btn btn-outline-secondary" type="submit">검색</button>
			
		</form>
	</div>
	<div class="btn">
		<a href="/webapp/MovieController?command=moviereviewpage&page=1"
			style="color: #000000;">1</a> <a
			href="/webapp/MovieController?command=moviereviewpage&page=2"
			style="color: #000000;">2</a> <a
			href="/webapp/MovieController?command=moviereviewpage&page=3"
			style="color: #000000;">3</a> <a
			href="/webapp/MovieController?command=moviereviewpage&page=4"
			style="color: #000000;">4</a> <a
			href="/webapp/MovieController?command=moviereviewpage&page=5"
			style="color: #000000;">5</a>
	</div>
	<br>
	<br>
	<button type="button"
		onclick="location.href='/webapp/Movie/MovieReview.jsp'"
		class="btn btn-outline-primary">글쓰기</button>
</body>
</html>