<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<meta charset="UTF-8">
<title>채팅</title>
</head>
<body>

	<div class="container">
		<div class="col-6">
			<label><b>채팅방</b></label> <input id="userId" value="userId">
		</div>
		<div>
			<div id="msgArea" class="col"></div>
			<div class="col-6">
				<div class="input-group mb-3">
					<input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="button"
							id="button-send">전송</button>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
<script defer src="${context}/resources/assets/js/chat/chat.js"></script>
</html>
