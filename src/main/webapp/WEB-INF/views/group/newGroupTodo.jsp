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
	<div>${groupIdx}</div>
	<form id="form">
<%-- 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		<input type="hidden" id="groupIdx"  name="groupIdx" value="${groupIdx}"/>
		<input type="hidden" id="roomId"  name="roomId" value="${roomId}"/>
		일정 이름 <input type="text" name="title" id="title" maxlength="20" required><br><br>
		시작 날짜 <input type="date" name="dateStart" id="date" required><br><br>
		종료 날짜 <input type="date" name="dateEnd" id="dateEnd" required><br><br>
		<button type="button" value="확인" id="btnClick" onclick="window.close()" >확인</button>
		<button type="button" value="취소" id="btnCan" onclick="window.close()" >취소</button>
	
	</form>
	</div>
</body>
 <script defer src="${context}/resources/assets/js/group/MyGroupTodo.js"></script>  
</html>