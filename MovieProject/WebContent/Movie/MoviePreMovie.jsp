<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	body{
		margin : 0px auto;
		width : 100%;
		text-align : center;
		background-color : #000000;
		height : auto;
	}
	.row{
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
		
</style>

</head>
<body>

	<jsp:include page="/Movie/MovieHeader.jsp"/>
	
	<br>
	<h1 style="color :white;">개봉 예정 영화</h1>
	<p style="color:white;">곧 개봉할 영화들이에요.</p>
	<br>
	<br>
	<c:forEach var ="premovie" items="${premovie}">
		<div class="row" style="margin: auto; float:left;">
			<div class="thumbnail">
			
				<a href="https://movie.daum.net${premovie.url}"><img src="${premovie.image}" style="width: 400px; padding:20px; margin-left: 50px;"></a>
				<c:if test="${empty premovie.image}">
      			<img src="/webapp/image/no3.png" style="width: 400px; height: 555px; padding:20px; margin-left: 50px;">
      			</c:if>
				<div class="caption">
					<h3 style="color:white;">${premovie.title}</h3>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>