<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

            
            <form  action="/members/login"  method="POST" >

                <input type="text" id="inputId"  placeholder="아이디" required autofocus>
                <input type="password" id="inputPassword" placeholder="비밀번호" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> 아이디 기억하기
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">로그인</button>
            </form>
            <a href="#" class="forgot-password">
                비밀번호 찾기
            </a>

</body>
</html>