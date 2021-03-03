<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="headerpage.jsp"></jsp:include>
	<div class="container">

		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3">Shoppingmall</h1>
			<p class="lead">
				스포츠 쇼핑몰입니다.<br> 다양한 스포츠 의류와 신발이 있습니다! <br> 둘러보세요!
			</p>
		</header>

		<!-- Page Features -->
		<div class="row text-center">
			<c:forEach items="${bestproduct}" var="bestproduct">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-100">
						<a href="product_detail?pseq=${bestproduct.pseq}"> <img
							class="card-img-top" src="resources/image/${bestproduct.image}"
							width="250" height="290">
						</a>
						<div class="card-body">
							<h4 class="card-title">${bestproduct.name}</h4>
							<p class="card-text">${bestproduct.content}</p>
						</div>
						<div class="card-footer">
							<fmt:formatNumber value="${bestproduct.price}" type="currency" />
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="footerpage.jsp"></jsp:include>

</body>
</html>