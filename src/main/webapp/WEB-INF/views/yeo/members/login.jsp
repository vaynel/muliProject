<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}"></meta>
<meta charset="UTF-8">
</head>
<body>



	<input type="text" id="userId" placeholder="아이디" required autofocus>
	<input type="password" id="password" placeholder="비밀번호" required>
	<div id="remember" class="checkbox">
		<label> <input type="checkbox" value="remember-me">
			아이디 기억하기
		</label>
	</div>
	<button class="btn btn-lg btn-primary btn-block btn-signin"
		type="button" id="btnClick">로그인</button>


	<button class="btn btn-lg btn-primary btn-block btn-signin"
		type="button" id="btnSign">회원가입</button>


	
</body>
<script defer src="${context}/resources/assets/js/member/login.js"></script>
</html>