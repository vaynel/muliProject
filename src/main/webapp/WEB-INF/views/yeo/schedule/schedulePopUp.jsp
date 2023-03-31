<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 등록</title>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');

body {
  background-color: #f2f2f2;
  font-family: Arial, sans-serif;
  font-size: 16px;
  line-height: 1.5;
}

/* Heading styles */
h1 {
  color: #333;
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  margin-top: 50px;
}

/* Form styles */
#form {
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 0 5px #ccc;
  padding: 20px;
  margin: 0 auto;
  width: 80%;
}

input[type="text"], input[type="date"], input[type="time"], input[type="checkbox"] {
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
  font-size: 16px;
  padding: 10px;
  width: 100%;
  margin-bottom: 20px;
}

input[type="checkbox"] {
  width: auto;
}

#timeBox {
  display: none;
}

.button-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
  
}

.button-container button {
  margin: 0 10px;
  background-color: rgba(222, 118, 119, 50);
  color: #fff;
  border: none;
  font-size: 16px;
  font-weight: bold;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  margin-right: 10px;
}


button:hover {
  background-color: #444;
}

/* Media queries */
@media screen and (max-width: 767px) {
  #form {
    width: 100%;
  }
}

@media screen and (max-width: 480px) {
  input[type="text"], input[type="date"], input[type="time"], input[type="checkbox"] {
    font-size: 14px;
    padding: 8px;
  }

  h1 {
    font-size: 20px;
  }
}
</style>
</head>
<body>
	<div>
	<h1>일정 추가하기</h1>
	<div id="form">
		일정 이름 <input type="text" name="title" id="title" maxlength="20"><br><br>
		시작 날짜 <input type="date" name="dateStart" id="date"><br><br>
		종료 날짜 <input type="date" name="dateEnd" id="dateEnd"><br><br>
		Allday	  <input type="checkbox" onClick="check(this)" name="allDay" ><br><br>
	<div id="timeBox">
		시작 시간 <input type="time" name="timeStart" id="startTime" maxlength="20"><br><br>
	</div>
	<div class="button-container">
		<button type="button" value="확인" id="btnClick" >확인</button>
		<button type="button" value="취소" id="btnCan" >취소</button>
	</div>
	</div>
	</div>
</body>
<script defer src="${context}/resources/assets/js/schedule/popup.js"></script>
</html>