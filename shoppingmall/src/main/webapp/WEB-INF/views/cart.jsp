<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap{
		width : 50%;
		margin : 0px auto;
		text-align : center;
	}

</style>
<!-- Bootstrap CSS -->
<link
	href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="headerpage.jsp" />
	<br>
	<br>
	<br>
	<div class="wrap">
	<center><h1>장바구니</h1></center>
	<br>
	<br>
		<table class="table">
			<th></th>
			<th>제품</th>
			<th>가격</th>
			<tr>
				<c:set var="sum" value="0"/>
				<c:forEach var="showcart" items="${showcart}">
					<c:if test="${showcart.name == null}">
						장바구니가 비었습니다.	
					</c:if>				
				
					<c:set var="sum" value="${sum + showcart.price}"/>	
					<tr>
						<td><img src="resources/image/${showcart.image}" width="100"  heigth="100"></td>
						<td>${showcart.name}</td>
						<td><fmt:formatNumber value="${showcart.price}"
						type="currency"/>
						</td>
						<td><a href="cartdelete?cseq=${showcart.cseq}&id=${sessionScope.memberId}">[삭제]</a></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<br>
		<br>
		<hr>
		<p>총 주문 금액 : <fmt:formatNumber value="${sum}" type="currency"/> </p>
	</div>
<%-- 
	<fmt:formatNumber value="${sum}"
	type="currency" currencySymbol="원"/>입니다 --%>
	
</body>
</html>