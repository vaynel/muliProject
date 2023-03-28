<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>



* {
	margin: 0;
	padding: 0;
	
}

img {
	width : 300px;
	height : 100px;
}

body {
	background-image : url('https://img.poipiku.com/user_img02/002382369/008490249_AHMaygEEr.png_640.jpg');
	background-repeat : no-repeat;
	background-size : cover;
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
}

form {
	background-color : rgba(255, 255, 255, 0.6);
	padding: 20px;
	display: inline-flex;
	flex-direction: column;
	align-items: center;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.8);
	width: 1000px;
	height: 600px;
}


form image {
	margin-top: 100px;
	font-size: 4.5rem;
	color: black;
	opacity : 0;
	
}

form input {
	border: none;
	text-align: justify;
	padding: 10px;
	margin: 10px;
	color: black;
	font-size : 20px;
	font-color : black;
	height: 30px;
	width: 50%;
	border-radius: 40px;
	position : relative;
	
}

form input[type="submit"] {
	text-align : center;
}

sign-out {
    color: black;
    font-size : 4.5rem;
}


#login {	
	background : dodgerblue;
	box-sizing: border-box;
	height: 50px;
	width: 50%;
	cursor: pointer;
}

#login:hover {
background : teal;
}

</style>
</head>
<body>
	<form action="/members/login" method="POST">
		<img
		src="https://img.poipiku.com/user_img03/002382369/008494728_U3a3wBIVG.png_640.jpg"
		>

		<input type="text" id="inputId" placeholder="아이디" required autofocus>
		<input type="password" id="inputPassword" placeholder="비밀번호" required>
		<input type="password" id="inputPassword-check" placeholder="비밀번호 확인" required>
		<input type="text" id="email" placeholder="이메일 주소" required autofocus>
		<input type="tel" id="phone-number" placeholder="연락처" required autofocus>
		<input type="submit" id = "login" value = "회원 가입" button class="btn btn-lg btn-primary btn-block btn-signin"></button>
		
		<div class="member">이미 회원가입을 하셨나요?
		<a href="login#">
		로그인
		</a>
		</div>
	</form>

	<script>
	
	</script>
</body>