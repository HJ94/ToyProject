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


<center><h1>ȸ�� ����</h1></center>

<div class="wrap">

<div class="menu">
	<a href="memberlist">ȸ������</a>
	<a href="productlist">��ǰ����</a>
	<a href="adminqnalist">Q&A����</a>
</div>

<table class="table">
<th>�̸�</th>
<th>ID</th>
<th>PW</th>
<th>��ȭ��ȣ</th>
<th>�ּ�</th>


<tr>
<c:forEach var="memberlist" items="${memberlist}">
<tr>
<td>${memberlist.name}</td>
<td>${memberlist.id}</td>
<td>${memberlist.pw }</td>
<td>${memberlist.phone }</td>
<td>${memberlist.address}</td>
<td><a href="adminmemberdelete?mseq=${memberlist.mseq}">����</a></td>
</tr>
</c:forEach>
</tr>
</table>
</div>
</body>
</html>