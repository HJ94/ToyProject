<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="movie.dao.*" %>
<%@ page import="movie.dto.*" %>
<%@ page import="webapp.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	body{
		margin : 0px auto;
		width : 100%;
		
	}
	.a{
		color:#ffffff;
	}
	.head{
		background-color : #000000;	
	}
	a:hover{ 
	text-decoration:none !important
	}
	 a:visited { 
	 color: white; text-decoration: none;
	 font-family: 'Nanum Myeongjo', serif;
	}

	ul{
		text-align : center;
		
	}
	li{
		display:inline-block;
		margin-left : 20px;
		height : 10px;
	}

</style>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.admininfo !=null}">
			<c:set var= "admininfo" value="${sessionScope.admininfo}"/>
			<c:if test="${!empty sessionScope.admininfo}">
				<span style="color : white; float: right; margin :0px auto; font-size:20px;"><a>${admininfo.name}님 반갑습니다.</a> <a style="color: white;" href="/webapp/MovieController?command=movielogout">로그아웃</a>
					</span>
			</c:if>
		</c:when>
	</c:choose>
	<div class="head">
		<br> 
		<br>
		<ul>
			<li><a href="/webapp/MovieController?command=moviemain">메인페이지</a></li>
			<li><a href="/webapp/MovieController?command=movieadminmain">회원 관리</a></li>
			<li><a href="/webapp/MovieController?command=movieadminnoticeboard">자유게시판 관리</a></li>
			<li><a href="/webapp/MovieController?command=movieadminreview ">영화 리뷰 관리</a></li>
			<li><a href="/webapp/MovieController?command=movieadminqna">Q&A 관리</a></li>
			
		
		</ul>
	
	</div>
</body>
</html>