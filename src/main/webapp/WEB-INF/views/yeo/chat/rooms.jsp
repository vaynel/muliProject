<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>

<meta charset="UTF-8">
<title>채팅</title>
</head>
<body>
	<div class="container">
		<div>
			<c:forEach items="${list}" var="room">
				<ul>
					<li><a href="/chat/room?roomId=${room.roomId}">[${room.name}]</a></li>
				</ul>
			</c:forEach>
		</div>
	</div>
	<form id="form">
		<input id="roomName1" type="text" name="name" class="form-control">
		<button class="btn btn-secondary">개설하기</button>
	</form>


</body>
<script defer src="${context}/resources/assets/js/chat/rooms.js"></script>

</html>
