<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
<meta charset="UTF-8">

</head>
<body>



	<input type="text" id="userId" placeholder="아이디" required autofocus>
	<input type="password" id="password" placeholder="비밀번호" required>
	
	<button class="btn btn-lg btn-primary btn-block btn-signin"
		type="button" id="btnClick">로그인</button>

	<div id="g_id_onload" data-client_id="689885454668-12d8lthjkbrfrjae7plunhqc12ctegfv.apps.googleusercontent.com"
		data-callback="handleCredentialResponse"></div>
	<div class="g_id_signin" data-type="icon" data-shape="circle"></div>


	<button class="btn btn-lg btn-primary btn-block btn-signin"
		type="button" id="btnSign">회원가입</button>



</body>

        
<script src="https://accounts.google.com/gsi/client" async defer></script>
<script defer src="${context}/resources/assets/js/member/login.js"></script>
</html>