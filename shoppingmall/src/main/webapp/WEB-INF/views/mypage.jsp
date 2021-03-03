<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	body{
		margin : 0;
		padding : 0;
		height : 100%;
		
	}
	.form-group{
		width : 40%;
		margin : 0px auto;
	}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="headerpage.jsp" />
	<br>
	<br>
	<br>
	<br>
	<center><h1>마이페이지</h1></center>
	<form action="memberinfoupdate" method="post">
		<div class="form-group">
			<label for="exampleFormControlInput1">이름</label> <input type="text"
				class="form-control" id="exampleFormControlInput1" name="name"
				value="${memberinfo.name}" readonly>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">아이디</label> <input type="text"
				class="form-control" id="exampleFormControlInput1" name="id" value="${memberinfo.id}" readonly>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">패스워드</label> <input type="text"
				class="form-control" id="exampleFormControlInput1" name="pw" value="${memberinfo.pw}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">이메일</label> <input type="text"
				class="form-control" id="exampleFormControlInput1" name="email" value="${memberinfo.email}">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">번호</label> <input type="text"
				class="form-control" id="exampleFormControlInput1" name="phone" value="${memberinfo.phone}" readonly>
		</div>

		<div class="form-group">
			<label for="exampleFormControlTextarea1">주소</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="5" name="address">${memberinfo.address}</textarea>
		</div>
		
		<center>
			<button type="submit" class="btn btn-outline-primary">개인정보수정</button>
			<br>
			<br>
			<a href="memberinfodelete?id=${memberinfo.id}">탈퇴</a>  
		</center>
	</form>
</body>
</html>