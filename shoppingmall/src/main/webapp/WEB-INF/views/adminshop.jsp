<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<style>
	.wrap{
		width : 80%;
		height : auto;
		text-align : center;
	}
	
	.menu{
		text-align : center;
		padding : 5px;
		margin-left : 500px;
	}

	.table{
		width : 100%;
		margin-left : 150px;
		align-item : center;
		text-align : center;
		padding : 80px;
	
	}
	
	ul {
    list-style:none;
    margin:0;
    padding:0;
	}

li {
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;
	}
	 th, td {
    border: 1px solid #444444;
  }
	
	
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<center><h1>상품 관리</h1></center>

<div class="wrap">
<div class="menu">
	<a href="memberlist">회원관리</a>
	<a href="productlist">상품관리</a>
	<a href="adminqnalist">Q&A관리</a>
</div>

<table class="table">
<th>제품</th>
<th>종류</th>
<th>가격</th>
<th>내용</th>
<th>이미지</th>


<tr>
<c:forEach var="productlist" items="${productlist}">
<tr>
<td>${productlist.name}</td>
<td>${productlist.kind}</td>
<td>${productlist.price}</td>
<td>${productlist.content}</td>
<td><img src="resources/image/${productlist.image}" width="80px" height="80px"></td>
<td><a href="#?id=${productlist.name}">삭제</a></td>
</tr>
</c:forEach>
</tr>
</table>
<button type="button" onclick="location.href='product_register'">상품 등록</button>
</div>
</body>
</html>