<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script type="text/javascript">
     function Validation(form) {
	 
    	 	var RegExp1 = /^[a-z][a-z\d]{4,12}$/; // 아이디 정규식(대소문자 4자리에서 12자리)
		    var RegExp2 = /^[a-z0-9]{4,12}$/; // 비밀번호 정규식
    	 	var RegExp3 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	                // 이메일 정규식
			var RegExp4 = /[가-힣]{2,8}$/; //이름 정규식(한글 입력만)
			var RegExp5 = /^\d{2,3}-\d{3,4}-\d{4}$/;  //전화번호 정규식
	        
			var objId = document.getElementById("id");
			var objPw = document.getElementById("pw");
			var objPwc = document.getElementById("pwc");
			var objName = document.getElementById("name");
			var objEmail = document.getElementById("email");
			var objPhone = document.getElementById("phone");
			
			
			//아이디 검사
			if(objId.value=='') {
             alert("아이디를을 입력해 주세요");
             return false;
        	 }
			if(!RegExp1.test(objId.value)){
				alert("ID는 4~12자의 영문 소문자와 숫자로만 입력가능합니다.");
				return false;
			}
			//패스워드 검사
			if(objPw.value==''){
				alert("패스워드를 입력해 주세요");
				objPw.focus();
				return false;
				}
			
			if(objPw.value != objPwc.value){
				alert("비밀번호가 일치하지 않습니다.");
				objPwc.focus();
				return false;
			}
			
			if(!RegExp2.test(objPw.value)){
				alert("비밀번호는 4~12자의 영문 소문자와 숫자로만 입력가능합니다.");
				objPw.focus();
				return false;
			}
			
			if(objPw.value==objId.value){
				alert("ID와 패스워드는 동일할 수 없습니다.");
				objPw.focus();
				return false;
			}
			
			//이름 검사
			if(objName.value==''){
				alert("이름을 입력해 주세요");
				objName.focus();
				return false;
			}
			if(!RegExp4.test(objName.value)){
				alert("이름 형식이 올바르지 않습니다.");
				objName.focus();
				return false;
			}
			
			//이메일 검사
			if(objEmail.value==''){
				alert("이메일을 입력해 주세요");
				objEmail.focus();
				return false;
			}
			if(!RegExp3.test(objEmail.value)){
				alert("이메일 형식이 올바르지 않습니다.");
				objEmail.focus();
				return false;
			}
			//전화번호 검사
			if(objPhone.value==''){
				alert("전화번호를 입력해 주세요");
				objPhone.focus();
				return false;
			}
			if(!RegExp5.test(objPhone.value)){
				alert("전화번호 형식이 올바르지 않습니다.");
				objPhone.focus();
				return false;
			}
		}
     function IdCheck(){
    	 //아이디 중복확인
    	 window.open("IdCheck.jsp", "IDC", "width=400 height=350")
    	 
     }

</script>

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
        margin-top: 20%;
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

.login-main-text h2{
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
            <p>회원가입</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form name ="join" onsubmit="return Validation(this);" action ="/webapp/MovieController?command=moviejoin" method="post">
                  <div class="form-group">
                     <label>ID</label>
                     <input type="text" class="form-control" name ="id" id="id">
                     <button type="button" onclick="IdCheck()" class="btn btn-secondary">ID 중복체크</button>
                     &nbsp;4~12자의 영문 소문자와 숫자로만 입력  
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" name ="pw" id="pw">&nbsp;4~12자의 영문 소문자와 숫자로만 입력
                  </div>
                  <div class="form-group">
                     <label>Password Check</label>
                     <input type="password" class="form-control" name ="pwc" id="pwc">&nbsp;비밀번호 확인
                  </div>
                  <div class="form-group">
                     <label>Name</label>
                     <input type="text" class="form-control" name ="name" id="name">&nbsp;한글로만 입력
                  </div>
                  <div class="form-group">
                     <label>Email</label>
                     <input type="text" class="form-control" name="email" id="email">&nbsp;ex)abcd@naver.com
                  </div>
                  <div class="form-group">
                     <label>Phone</label>
                     <input type="text" class="form-control" name="phone" id="phone">&nbsp;ex)010-123-1234 / 02-123-1234
                  </div>
                  <input type="submit" class="btn btn-secondary" value="회원가입">
               	  <input type="reset" class="btn btn-secondary" value="다시입력">
               </form>
            </div>
         </div>
      </div>
</body>
</html>