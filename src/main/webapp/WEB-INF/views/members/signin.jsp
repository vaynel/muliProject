<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
	<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}"></meta>
  
  <title>회원가입 화면</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


  <style>
    body {
      min-height: 100vh;

      background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
    }

    .input-form {
    position: fixed; top: 0; right: 0;
    margin: 0 auto;
   	left: 0;
   	right: 0;
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>
</head>
<body>

	<!-- Sidebar -->
			<%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

		<!-- Scripts -->
			<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>
		
	 <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원가입</h4>
        <form class="validation-form" novalidate>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">아이디</label>
              <input type="text" class="form-control" id="id" placeholder="" value="" required>
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
                <button type="button" id="idCheck">중복확인</button>
            </div>
            
          
            
            <br>
            
            <div class="col-md-6 mb-3">
              <label for="nickname">비밀번호</label>
              <input type="text" class="form-control" id="password" placeholder="" value="" required>
              <div class="invalid-feedback">
                비밀번호를 입력해주세요.
              </div>
            </div>
          </div>


   		 <label for="name">이름</label>
      	        <input type="text" class="form-control" id="nameData" placeholder="" value="" required>
              <div class="invalid-feedback">
                이름를 입력해주세요.
              </div>

          <div class="mb-3">
            <label for="birth">생년월일</label>
            <input type="date" class="form-control" id="birth" required>
            <div class="invalid-feedback">
              생년월일을 입력해주세요.
            </div>
          </div>
          
             <div class="mb-3">
            <label for="phone-number">전화번호</label>
            <input type="text" class="form-control" id="tell" placeholder="010-****-****" required>
            <div class="invalid-feedback">
              전화번호를 입력해주세요.
            </div>
          </div>

          <div class="row">
            <div class="col-md-8 mb-3">
              <label for="root">성별</label>
              <select class="custom-select d-block w-100" id="gender">
                <option value=""></option>
                <option value="m">남자</option>
                <option value="w">여자</option>
              </select>
              <div class="invalid-feedback">
                성별을 선택해주세요.
              </div>
            </div>
            

          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="button" id="btnSign">가입 완료</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 YD</p>
    </footer>
  </div>
  <script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
</body>
<script defer src="${context}/resources/assets/js/member/signin.js"></script>
</html>