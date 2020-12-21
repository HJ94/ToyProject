<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<style type="text/css">
	body {
    font-family: "Lato", sans-serif;
	}

.main-head{
    height: 150px;
    background: #FFF;
   
}

.sidenav {
    height: 100%;
    background-color: #000;
    overflow-x: hidden;
    padding-top: 20px;
}


.main {
    padding: 0px 10px;
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
    .login-form{
        margin-top: 10%;
    }

    .register-form{
        margin-top: 10%;
    }
}

@media screen and (min-width: 768px){
    .main{
        margin-left: 40%; 
    }

    .sidenav{
        width: 40%;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
    }

    .login-form{
        margin-top: 40%;
    }

    .register-form{
        margin-top: 20%;
    }
}


.login-main-text{
    margin-top: 20%;
    padding: 60px;
    color: #fff;
}

.login-main-text h2{`
    font-weight: 300;
}

.btn-black{
    background-color: #000 !important;
    color: #fff;
}
	
	
	</style>
</head>
<body>
	<div class="sidenav">
         <div class="login-main-text">
            <h1>Movie</h1><br>
            <p>전화번호와 이메일을 입력해 ID와 PW을 찾을 수 있습니다.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form action ="/webapp/MovieController?command=moviefinduserinfo" method="post">
                  <div class="form-group">
                     <label>이름</label>
                     <input type="text" class="form-control" placeholder="User Name" name ="name">
                  </div>
                  <div class="form-group">
                     <label>EMAIL</label>
                     <input type="text" class="form-control" placeholder="User EMAIL" name ="email">
                  </div>
                  <div class="form-group">
                     <label>Phone</label>
                     <input type="text" class="form-control" placeholder="User Phone" name="phone">
                  </div>
                  <button type="submit" class="btn btn-black">내 정보 확인</button>

               </form>
            </div>
         </div>
      </div>
</body>
</html>