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
		text-align : center;
		background-color : #000000;
		height : auto;
	}
	.head{
		text-align:center;
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
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp"/>
	</div>
	
	<h1 style ="color:white;"> BOX Office</h1>
	<p style="color:white;">현재 상영중인 1위부터 10위까지의 영화입니다.</p>
	<br>
	<br>
	<c:forEach var="boxoffice" items="${boxoffice}">
		<div class="row" style="margin: auto; float:left;">
			<div class="thumbnail">
				<a href="https://movie.daum.net${boxoffice.url}"><img src="${boxoffice.image}" style="width: 400px; padding:20px; margin-left: 50px; "></a>
				<div class="caption">
					<h3 style ="color:white">${boxoffice.title}</h3>
				</div>
			</div>
		</div>

	</c:forEach>
</body>
</html>