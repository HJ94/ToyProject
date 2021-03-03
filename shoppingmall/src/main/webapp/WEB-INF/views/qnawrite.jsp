<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	body{
		margin : 0;
		padding : 0;
		height : 100%;
	}
	.wrap{
		position : relative;
		min-height : 100%;
	}
	
	
	.form-group{
		width : 60%;
		margin : 0px auto;
	}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Form</title>
</head>
<body>
	
	<div class="wrap">
	<jsp:include page="headerpage.jsp" />
	<br>
	<br>
	<br>
	<br>
	<center><h2>Q&A</h2></center>
	<form action="qnawrites" method="post">
		<div class="form-group">
			<label for="exampleFormControlInput1">작성자</label> <input
				type="text" class="form-control" id="exampleFormControlInput1" name="id" value="${sessionScope.memberId}" readonly>
		</div>
		<div class="form-group"><input type="hidden" class="form-control" id="exampleFormControlInput1" name="rep" value=1>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label> <input
				type="text" class="form-control" id="exampleFormControlInput1" name="subject">
		</div>

		<div class="form-group">
			<label for="exampleFormControlTextarea1">내용</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="10" name="content"></textarea>
		</div>
		<center><button type="submit" class="btn btn-outline-primary">글쓰기</button></center>
	</form>
	
	
	</div>
</body>
</html>


