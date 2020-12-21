<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-
GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<style>
	.head{
		background-color: #000000;	
	}
	body{
		text-align:center;
	}

</style>



</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp" />
	</div>
	<center><h1>1:1 문의</h1></center>
	<hr>
	<br>
	<br>

	<article>

		<div class="container" role="main">

			<h2>Q&A</h2>
			<br>
			<form name="form" id="form" role="form" method="post"
				action="/webapp/MovieController?command=movieqna">
				<div class="mb-3">
					<label for="title">제목</label> <input type="text"
						class="form-control" name="subject" id="title"
						placeholder="제목을 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<textarea class="form-control" rows="5" name="content" id="content"
						placeholder="내용을 입력해 주세요"></textarea>
				</div>
				<div>
				<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
				</div>
			</form>


		</div>

	</article>








</body>
</html>