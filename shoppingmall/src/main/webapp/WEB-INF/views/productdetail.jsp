<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop Item - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">

  <!-- Custom styles for this template -->
  <link href="css/shop-item.css" rel="stylesheet">

</head>

<body>
  <jsp:include page="headerpage.jsp"></jsp:include>
  <br>
  <br>
  <br>
  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">
        <h3 class="my-4">${product_detail.name}</h3>

      </div>
      <!-- /.col-lg-3 -->
	
      <div class="col-lg-9">
        <div class="card mt-4">
        <form action = "addcart" method="post">
        <input type="hidden" name="id" value="${sessionScope.memberId}">
        <input type="hidden" name="price" value="${product_detail.price}">
        <%-- <input type="hidden" name="pseq" value="${product_detail.pseq}"> --%>
        <input type="hidden" name="name" value="${product_detail.name}">
        <input type="hidden" name="image" value="${product_detail.image}">	
          <img class="card-img-top img-fluid" src="resources/image/${product_detail.image}" style="max-width: 100%; height: auto;">
          <div class="card-body">  
            <h3 class="card-title">${product_detail.name}</h3>
            <h4>${product_detail.price}원</h4>
            <p class="card-text">${product_detail.content}</p>
			<button type="submit" class="btn btn-success">장바구니 담기</button>
          </form>
          </div>
        </div>
        
        <br>
        <br>
        <br>
        <!-- /.card -->

        <!-- <div class="card card-outline-secondary my-4">
          <div class="card-header">
            상품 리뷰
          </div>
          <div class="card-body">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <a href="#" class="btn btn-success">Leave a Review</a>
          </div>
        </div>
 -->        <!-- /.card -->

      </div>
      <!-- /.col-lg-9 -->

    </div>

  </div>
  <!-- /.container -->

  <!-- Footer -->

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <jsp:include page="footerpage.jsp"></jsp:include>
</body>

</html>
