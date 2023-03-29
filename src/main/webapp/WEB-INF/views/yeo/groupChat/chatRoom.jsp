<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<meta charset="UTF-8">
<title>채팅</title>
</head>
<body>

	<div class="container">
		<div class="col-6">
			<h2 id="groupIdx">GroupIdx : ${groupIdx} </h2>
			<h2 id="roomIda">RoomId : ${room.roomId}</h2>
			
		</div>
		<div>
			<div id="msgArea" class="col"></div>
			<div class="col-6">
				<div class="input-group mb-3">
					<div>userName : <input id="userNamea"></div>
					<input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="button"
							id="button-send">전송</button> 
					</div>
				</div>
			</div>
			<br>
			<a href="/group/newGroupTodo?groupIdx=${groupIdx}">모임 생성</a>
			<a href="/group/recommendDate">날짜 추천</a>
		</div>
	</div>



</body>
<script defer src="${context}/resources/assets/js/chat/room.js"></script>
</html>
