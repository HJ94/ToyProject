<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.jsoup.Jsoup"%>
<%@ page import="org.jsoup.nodes.Document"%>
<%@ page import="org.jsoup.nodes.Element"%>
<%@ page import="org.jsoup.select.Elements"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
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
<style type="text/css">
body {
	background-color: #000000;
	width: 100%;
	height: auto;

}

.wrap {
	width: 100%;
	height: auto;
	margin: auto;
	text-align: center;
}

.title1 {
	font-size: 45pt;
	text-align: center;
	font-family: 'Nanum Myeongjo', serif;
	color: #ffffff;
}

.input-group {
	width: 400px;
	margin: 50px auto;
}

.btn {
	background-color: #000000;
	color: #ffffff;
}

.wrap2 {
	background-color: #000000;
	width: 900px;
	margin: 50px auto;
	text-align: center;
}

.jumbotron {
	background-color: #000000;
}
.head{
	text-align : center;
}
.col {
	margin: auto;
	display: flex;
	flex-direction: row;
	justify-content: center;
}
.search{
	margin : 0px auto;
	display : block;
}
.wrap3{
	text-align : center;
	display : inline-block;
}
.mainimage{
	margin: auto;
	display: flex;
	flex-direction: row;
	justify-content: center;
}

</style>
<script>
	

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test ="${empty movielist}">
	<%
	response.sendRedirect("/webapp/MovieController?command=moviemain");
	%>	
	</c:if>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp"/>
	</div>
	<div class="wrap">
		<br>
		<br>
		<div class="jumbotron">
			<h1 class="display-3" style="color: #ffffff">MOVIEMOVIE</h1>
			<p style="color: #ffffff">보고 싶은 아무 영화나 검색해보세요!</p>
		</div>
			
		<form action = "/webapp/MovieController?command=moviesearch" method="post">
		<div class="input-group" id="input-movie">
		
			<input id="input-keyword" type="text" class="form-control" autocomplete="off"
				aria-label="Recipient's username" name ="query" aria-describedby="basic-addon2">
			<div class="input-group-append">

				<button onclick="search()" id="btn"
					class="btn btn-outline-secondary" type="submit">검색</button>
			</div>
		</div>
		</form>
		<div class="mainimage">
		<img class='bg'
			src='https://cdn.pixabay.com/photo/2014/04/03/10/33/popcorn-310862_1280.png'
			width="300" height="400">
		</div>	
			
	<br>	
    <br>
	<div class="search">
			<c:if test="${sessionScope.moviesearch != null}">
			<h1 class="display-3" style="color: #ffffff">검색 결과</h1>
			</c:if>
			<c:forEach var="moviesearch" items="${moviesearch}">	
			<div class="row" style="margin :auto; float:left;">
    		<div class="thumbnail">
      		<c:if test="${empty moviesearch.image}">
      		<img src="/webapp/image/no3.png" style="width: 400px; height: 500px; padding:20px; margin-left: 60px;">
      		</c:if>
      		<img src="${moviesearch.image}" style="width: 400px; height: 500px; padding:20px; margin-left: 60px;" >
        	<h3 style="color:white">${moviesearch.title}</h3>
       	 	<p><a href="${moviesearch.link}" class="btn btn-primary" role="button">자세히 보기</a>
      		</div>
      		</div>
      		</c:forEach>
      </div>
	<br>
	<br>
	<br>
	<br>
	<div class="wrap3">
		 <h1 class="display-3" style="color: #ffffff">현재 상영작</h1>
		 <br>
			<c:forEach var="movielist" items="${movielist}" begin="8" end="18">
  				
    			<div class="row" style="margin :auto; float:left;">
    			<div class="thumbnail">
      						<img src="${movielist.image}" style="width: 400px; padding:20px; margin-left: 60px;" >
      			<div class="caption" style="align:center">
        		<h3 style="color:white">${movielist.title}</h3>
        		<p style="color:white">${movielist.actor}</p>
       	 		<p><a href="https://movie.daum.net${movielist.url}" class="btn btn-primary" role="button">자세히 보기</a>
      			</div>
    			</div>
  				</div>
			</c:forEach>
	</div>
</div>
</body>
</html>