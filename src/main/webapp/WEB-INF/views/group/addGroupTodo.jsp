<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
<style>
Button {
  background-color: rgba(222, 118, 119, 50);
  color: white;
  border: none;
  font-color:black;
  width: 100px;
  height: 30px;
}
</style>
</head>
<body>
	<div>
	<h1>일정 추가하기</h1>
	<div id="groupIdx">${groupIdx}</div>
	<div id="form">
		일정 이름 <input type="text" name="title" id="title" maxlength="20"><br><br>
		시작 날짜 <input type="date" name="dateStart" id="date"><br><br>
		종료 날짜 <input type="date" name="dateEnd" id="dateEnd"><br><br>
		Allday	  <input type="checkbox" onClick="check(this)" name="allDay" ><br><br>
	<div id="timeBox">
		시작 시간 <input type="time" name="timeStart" id="startTime" maxlength="20"><br><br>
	</div>	
		<button type="button" value="확인" id="btnClick" >확인</button>
		<button type="button" value="취소" id="btnCan" >취소</button>
	</div>
	</div>
</body>
<script defer src="${context}/resources/assets/js/group/addMyGroupTodo.js"></script>
</html>