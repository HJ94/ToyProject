<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    


<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>My First Spring Shoppingmall</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">

<!-- Custom styles for this template -->
<link href="css/heroic-features.css" rel="stylesheet">
<style>
	body{
	margin:0;

    padding:0;

    height:100%;
	}
	
	.container{
		position:relative;

    min-height:100%;
	}
	
			/* .footer{
			position:absolute;
			bottom:0;
			width:100%;
			height:40px; */
		}
	
	
</style>
</head>

<body>
	<jsp:include page="headerpage.jsp"></jsp:include>


	<!-- Page Content -->
	<div class="container">
		
		
		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3">Shoppingmall</h1>
			<p class="lead">스포츠 쇼핑몰입니다.<br> 다양한 스포츠 의류와 신발이 있습니다! <br> 둘러보세요!</p>
		</header>

		<!-- Page Features -->
		<div class="row text-center">
			<c:forEach items="${mainproduct}" var="mainproduct">
			<div class="col-lg-3 col-md-6 mb-4">
				<div class="card h-100">
					<a href="product_detail?pseq=${mainproduct.pseq}">
					<img class="card-img-top" src="resources/image/${mainproduct.image}" width="250" height="290">
					</a>
					<div class="card-body">
						<h4 class="card-title">${mainproduct.name}</h4>
						<p class="card-text">${mainproduct.content}</p>
					</div>
					<div class="card-footer">
						<p class="card-text">
						<fmt:formatNumber value="${mainproduct.price}"
						type="currency"/>
						</p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
	<div class="footer">
	<jsp:include page="footerpage.jsp"></jsp:include>
	</div>
</body>
</html>
