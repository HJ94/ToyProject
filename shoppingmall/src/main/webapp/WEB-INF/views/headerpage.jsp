<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">

<!-- Custom styles for this template -->
<link href="css/heroic-features.css" rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="main">Shopping Mall</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="main">����
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item-active"><a class="nav-link"
						href="newproduct">�Ż�ǰ</a></li>
					<li class="nav-item"><a class="nav-link" href="bestproduct">����Ʈ��ǰ</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="saleproduct">���ϻ�ǰ</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="boardList">�߰�����</a></li>
					<li class="nav-item"><a class="nav-link" href="qnalist">1:1����</a>
					</li>
							<c:if test="${!empty sessionScope.memberId}">
								<li class="nav-item"><a class="nav-link" href="mypage?id=${memberId}">${memberId}(����������)</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="showcart?id=${sessionScope.memberId}">��ٱ���</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="logout">[�α׾ƿ�]</a>
								</li>
							</c:if>
							<c:if test="${empty sessionScope.memberId}">
								<li class="nav-item"><a class="nav-link" href="login_view">�α���</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="join_view">ȸ������</a>
								</li>
							</c:if>
					

				</ul>
			</div>
		</div>
	</nav>
</body>
</html>