<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="movie.dao.*"%>
<%@ page import="movie.dto.*"%>
<%@ page import="webapp.*"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
body {
	margin: 0px auto;
} 

.a {
	color: #ffffff;
}

.head {
	background-color: #000000;
	width : 100%;
}

a:hover {
	text-decoration: none !important;
}

a:visited {
	color: white;
	text-decoration: none;
	font-family: 'Nanum Myeongjo', serif;
}
 
ul {
	margin-left : 20px;
	background-color: #000000;
}

li {
	display: inline-block;
	flex-direction: row;
	height: 100px;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span style="float:left; margin:5px 0px 0px 5px;"><img src="/webapp/image/popcon.png" onclick="location.href='/webapp/MovieController?command=moviemain'" width="100px" height="100px"></span>
	<c:choose>
		<c:when test="${sessionScope.movieuser != null}">
			<c:set var="movieuser" value="${sessionScope.movieuser}" />
			<c:if test="${!empty sessionScope.movieuser}">
				<span
					style="color: white; float: right; margin: 0px auto; font-size: 20px;"><a>${movieuser.name}님
						반갑습니다.&emsp;</a> <a style="color: white;"
					href="/webapp/MovieController?command=movielogout">[로그아웃]</a> 
					<a style="color: white;"
					href="/webapp/MovieController?command=movieuserinfo&id=${movieuser.id}">/[내
						정보 보기]</a> 
					<a style="color: white;"
					href="/webapp/MovieController?command=moviewishlistshow&id=${movieuser.id}">/[보관함]</a>	
					</span>
					
			</c:if>
		</c:when>
	</c:choose>
	<br>
	<div class="head">
		<br>
		
		<ul>
			<c:if test="${empty sessionScope.movieuser}">
			<a href="/webapp/MovieController?command=login">로그인&emsp;</a>
			<li><a href="/webapp/MovieController?command=join">회원가입&emsp;</a></li>
			</c:if>
			<li><a href="/webapp/MovieController?command=adminlogin">관리자&emsp;</a></li>			
			<li><a href="/webapp/MovieController?command=movieboxoffice">BoxOffice&emsp;</a></li>
			<li><a href="/webapp/MovieController?command=moviepremovie">개봉예정영화&emsp;</a></li>
			<li><a href="/webapp/MovieController?command=recommend">영화추천&emsp;</a></li>
			<li><a href="/webapp/MovieController?command=movienoticeboardlist">자유게시판&emsp;</a></li>
			<li><a href="/webapp/MovieController?command=moviereviewlist">영화리뷰&emsp;</a></li>
			<li><a href="/webapp/MovieController?command=movieqnalist">QnA&emsp;</a></li>
			<li><a href="/webapp/MovieController?command=theaters">영화관</a></li>
		</ul>
	</div>




</body>
</html>