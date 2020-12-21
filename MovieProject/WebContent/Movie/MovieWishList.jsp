<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- <!-- JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	body {
	background-color: #000000;
	width: 100%;
	height: auto;
	text-align:center;
}
	.head{
	text-align : center;
}
</style>
</head>
<body>
	<c:if test="${empty wishlist}">
	보관함이 비었습니다.
	</c:if>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp"/>
	</div>
	<br>
	<h1 class="display-3" style="color: #ffffff">영화 보관함</h1>
	<br>
	<br>
	<c:forEach var="wishlist" items="${wishlist}">	
		<div class="row" style="margin :auto; float:left;">
    			<div class="thumbnail">
      				<img src="/webapp/imageFolder/${wishlist.image}" style="width: 400px; padding:20px; margin-left: 60px;" >
      				<div class="caption" style="align:center">
        			<h3 style="color:white">${wishlist.subject}</h3>
       	 			<p><a href="/webapp/MovieController?command=moviereviewdetail&subject=${wishlist.subject}" class="btn btn-primary" role="button">자세히 보기</a>
      				</div>
    			</div>
  		</div>
	</c:forEach>
</body>
</html>