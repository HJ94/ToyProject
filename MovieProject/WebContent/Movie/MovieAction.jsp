<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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
	<jsp:include page="/Movie/MovieHeader.jsp"/>	
	<h1 style="color:white">Action</h1>
	<br>
	<br>
	<c:forEach var="actionlist" items="${actionlist}">
		<div class="row" style="margin: auto; float:left;">
			<div class="thumbnail">
				<img src="action/${actionlist.mimage}" style="width: 330px; padding:20px; margin-left: 40px; ">
				<div class="caption">
					<h3 style ="color:white">${actionlist.mname}</h3>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>