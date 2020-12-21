<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
	
	}
	
	.jumbotron {
		background-color: #000000;
	}
	.head{
		text-align:center;
	}
</style>
</head>
<body>
	<div class="head">
	<jsp:include page="/Movie/MovieHeader.jsp"/>	
	</div>
		<article>
			
			<div class="container" role="main">
				<h2>영화 리뷰</h2>
				<br>
				<form action="/webapp/MovieController?command=moviereviewwrite"
				method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="subject" placeholder="제목을 입력해 주세요">
					</div>
					<div class="mb-3">
						<label for="title">사진 업로드</label> <input type="file"
							class="form-control" name="file">
					</div>
					<div class="mb-3">
						<label for="content">내용</label>
						<textarea class="form-control" rows="15" name="content" placeholder="내용을 입력해 주세요"></textarea>
					</div>
					<div class="mb-3">
						<label for="tag">TAG</label> <input type="text"
							class="form-control" name="tag"placeholder="태그를 입력해 주세요">
					</div>
				
					<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
					<button type="button" onclick="location.href='/webapp/MovieController?command=moviereviewlist'" class="btn btn-sm btn-primary" id="btnList">목록</button>				</form>
			</div>
	</article>
</body>
</html>