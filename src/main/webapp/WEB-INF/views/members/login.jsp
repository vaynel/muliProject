<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}"></meta>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" type="text/css">

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Serif+JP:wght@200&display=swap')
	;

@font-face {
    font-family: 'EF_jejudoldam';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2210-EF@1.0/EF_jejudoldam.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

@font-face {
    font-family: 'CWDangamAsac-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/CWDangamAsac-Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
    font-family: 'RixYeoljeongdo_Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2102-01@1.0/RixYeoljeongdo_Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

/*  body {
	background-color: #888;
	background-image: linear-gradient(45deg, #444 25%, transparent 25%, transparent 75%, #444
		75%, #444),
		linear-gradient(45deg, #444 25%, transparent 25%, transparent 75%, #444
		75%, #444);
	background-position: 0 0, 25px 25px;
	background-size: 50px 50px;
}  */

  body {
	background-color: white;
	
	background-position: 0 0, 25px 25px;
	background-size: 50px 50px;
}  

.wrapper {
	text-align: center;
	margin: auto;
	margin-top: 15px;
	width: 420px;
	height: 530px;
	border: solid 3px;
	border-radius: 10%;
	background: rgba(222, 118, 119, 30);
}

h1 {
font-family: 'CWDangamAsac-Bold';
	margin-top: 120px;
	font-size: 60px;
}

input {
	text-align: left;
	width: 225px;
	height: 30px;
	border: none;
	border-bottom: solid 3px black;
	background: rgba(222, 118, 119, 30);
}

input::placeholder {
	color: black;
	font-size: 10px;
}

.idStyle {
	padding-top: 19px;
}

img {
	width: 250px;
	height: 250px;
}

.psStyle {
	padding-bottom: 32px;
	padding-top: 22px;
}

button {
	background-color:white;
 	position: relative;
    border: none;
    display: inline-block;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
}

.gooButton {
	padding-left: 105px;
	padding-top: 20px;
}

.title{
	text-align: center;
}

</style>

</head>
<body>
 	<div class="title">
	<h1>떠나자</h1>
	</div> 
	

	
	<div class="wrapper">

		

		<img src="${context}/resources/assets/img/campingImg.png">
		<div class="idStyle">
			<input type="text" id="userId" placeholder="아이디" required autofocus>
		</div>

		<div class="psStyle">
			<input type="password" id="password" placeholder="비밀번호" required>
		</div>


		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="button" id="btnClick">로그인</button>




		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="button" id="btnSign">회원가입</button>

		<div class="gooButton">
			<div id="g_id_onload"
				data-client_id="689885454668-12d8lthjkbrfrjae7plunhqc12ctegfv.apps.googleusercontent.com"
				data-callback="handleCredentialResponse"></div>
			<div class="g_id_signin"  data-shape="rectangular" data-width="215"
				data-height="180"></div>
		</div>

	</div>

</body>


<script src="https://accounts.google.com/gsi/client" async defer></script>
<script defer src="${context}/resources/assets/js/member/login.js"></script>
</html>