<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Serif+JP:wght@200&display=swap');

* {
	
	margin: 0;
	padding: 0;
	
}

img {
	width : 400px;
	height : 200px;
}

body {
	font-family: 'Nanum Gothic Coding', monospace;
	font-family: 'Noto Serif JP', serif;
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
	text-align: center;
	padding: 10px;
	margin: 10px;
	color: black;
	font-size : 20px;
	font-color : black;
	height: 30px;
	width: 70%;
	border-radius: 40px;
	
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

#kakao_login {	
	background : yellow;
	font-color : black;
	box-sizing: border-box;
	height: 50px;
	width: 50%;
	cursor: pointer;
}

#login:hover {
background : teal;
}

.speech-bubble {
	position: relative;
	background: #fafafa;
	border-radius: .4em;
}

.speech-bubble:after {
	content: '';
	position: absolute;
	left: 0;
	top: 50%;
	width: 0;
	height: 0;
	border: 58px solid transparent;
	border-right-color: #fafafa;
	border-left: 0;
	margin-top: -58px;
	margin-left: -58px;
}



</style>
</head>
<body>
	<form action="/members/login" method="POST">
		<img
		src="https://img.poipiku.com/user_img02/002382369/008490504_nWNItirig.png_640.jpg"
		>

		<input type="text" id="inputId" placeholder="아이디" required autofocus onkeyup="checkCapsLock(event)"/>
		<div id='message'></div>
		<input type="password" id="inputPassword" placeholder="비밀번호" required>
		
		<input type="submit" id = "login" value = "로그인" button class="btn btn-lg btn-primary btn-block btn-signin"></button>
		<input type="submit" id = "kakao_login" value = "카카오톡으로 로그인" button class="btn btn-lg btn-primary btn-block btn-signin"></button>
		<br>
		<br>
		<a href="signin#" class="sign-out" id="signout">
                아직 회원이 아니신가요?
            </a>
	</form>

	<script>
	function checkCapsLock(event)  {
		  if (event.getModifierState("CapsLock")) {
		    document.getElementById("message").innerText 
		      = "Caps Lock이 켜져 있습니다."
		  }else {
		    document.getElementById("message").innerText 
		      = ""
		  }
		}
	</script>
</body>
</html>