<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}"></meta>

<title>회원가입 화면</title>


<style>
.input-form {
	position: fixed;
	top: 0;
	right: 0;
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

button {
	margin: 0 10px;
	font-color: #ffff;
	border: none;
	font-size: 16px;
	font-weight: bold;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	margin-right: 10px;
}

.divStyle1 {
	margin-top: 30px;
	margin-left: 180px;
}
</style>
</head>
<body>

	<!-- Sidebar -->
	<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	<!-- Scripts -->
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원 정보 입력</h4>
				<form class="validation-form" novalidate>
					<div class="row">



						<div class="mb-3">
							<label for="birth">생년월일</label> <input type="date"
								class="form-control" id="birth" required>
							<div class="invalid-feedback">생년월일을 입력해주세요.</div>
						</div>

						<div class="mb-3">
							<label for="phone-number">전화번호</label> <input type="text"
								class="form-control" id="tell" placeholder="010-****-****"
								required>
							<div class="invalid-feedback">전화번호를 입력해주세요.</div>
						</div>

						<div class="row">
							<div class="col-md-8 mb-3">
								<label for="root">성별</label> <select
									class="custom-select d-block w-100" id="gender">
									<option value=""></option>
									<option value="m">남자</option>
									<option value="w">여자</option>
								</select>
								<div class="invalid-feedback">성별을 선택해주세요.</div>
							</div>




							<div class="mb-4"></div>
							<div class="divStyle1">
								<button type="button" id="btnSign">가입 완료</button>
								<button type="button"
									onclick="location.href='http://localhost:8080/members/login'">취소</button>
							</div>
				</form>
			</div>
		</div>

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
<script defer
	src="${context}/resources/assets/js/member/signinGoogle.js"></script>
</html>