<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		background-color : #000000;
		text-align: center;
		margin: 0px auto;
		height : auto;
	}
	a{
		text-decoration : none;
		padding-left : 10px;
	}

	.head{
		margin : auto;
		text-align : center;
		}
	.menu{
		margin-top : 40px;
	}


</style>
</head>
<body>
	<div class="head">
	<jsp:include page="MovieHeader.jsp"/>
	</div>
	<br>
	<h1 style="color:white;">이런 영화 어때?</h1>
	<p style="color:white;">공포부터 로맨스까지 영화 추천해드릴게요!</p>
	<br>
	<br>

		<ul>
			<li><a href="/webapp/MovieController?command=moviehorror"><img src="/webapp/image/horroricon.jpg" width="400px"></a>><li>
			<li><a href="/webapp/MovieController?command=movieaction"><img src="/webapp/image/actionicon2.png" width= "300px"></a></li>
			<li><a href="/webapp/MovieController?command=moviecomedy"><img src="/webapp/image/comedy.png" width="300px"></a></li>
			<li><a href="/webapp/MovieController?command=moviesf"><img src="/webapp/image/ufoicon.png" width="300px"></a></li>
			<li><a href="/webapp/MovieController?command=movieromance"><img src="/webapp/image/heart.jpg" width="300px"></a></li>
		</ul>


</body>
</html>