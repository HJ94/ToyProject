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


<center><h1>Q&A</h1></center>

<div class="wrap">
<div class="menu">
	<a href="memberlist">ȸ������</a>
	<a href="productlist">��ǰ����</a>
	<a href="adminqnalist">Q&A����</a>
</div>

<table class="table">
<th>�ۼ���</th>
<th>����</th>
<th>���� ����</th>
<th>�ۼ���</th>
<th>�亯 ����</th>


<tr>
<c:forEach var="qnalist" items="${qnalist}">
<tr>
<td>${qnalist.id}</td>
<td>${qnalist.subject}</td>
<td>${qnalist.content}</td>
<td>${qnalist.indate}</td>
<c:if test="${qnalist.rep == 1}">
<td>o</td>
</c:if>
<c:if test="${qnalist.rep == 0}">
<td>x</td>
</c:if>
<c:if test="${qnalist.rep == 0 }">
<td><a href="adminqna_reply?qseq=${qnalist.qseq}">�亯�ϱ�</a></td>
</c:if>
</tr>
</c:forEach>
</tr>
</table>
</div>
</body>
</html>