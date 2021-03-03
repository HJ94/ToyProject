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
	.wrap{
		position : relative;
		min-height : 100%;
	}
	
	
	.form-group{
		width : 60%;
		margin : 0px auto;
	}
	
	.btn{
		text-align : center;
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
	
		<div class="form-group">
			<label for="exampleFormControlInput1">작성자</label> <input
				type="text" class="form-control" id="exampleFormControlInput1" name="id" value="${sessionScope.memberId}" readonly>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label> <input
				type="text" class="form-control" id="exampleFormControlInput1" name="subject" value="${qnadetail.subject}" readonly>
		</div>

		<div class="form-group">
			<label for="exampleFormControlTextarea1">문의 내용</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="10" name="content"  readonly>${qnadetail.content}</textarea>
		</div>
		
		<br>
		<br>
		<br>
		<c:if test="${qnadetail.reply == null}">
		<div class="form-group">
			<label for="exampleFormControlTextarea1">답변</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="10" name="content"  readonly><---곧 문의 답변 드리겠습니다---></textarea>
		</div>
		</c:if>
		<c:if test="${qnadetail.reply != null}">	
		<div class="form-group">
			<label for="exampleFormControlTextarea1">답변</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="10" name="content"  readonly>${qnadetail.reply}</textarea>
		</div>
		</c:if>
		
	
	</div>
</body>
</html>


