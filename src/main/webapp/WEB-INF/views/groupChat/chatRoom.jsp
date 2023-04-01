<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link rel="stylesheet" href="${context}/resources/assets/css/chat/chatRoom.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<meta charset="UTF-8">
<title>채팅방</title>
</head>

<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<%@ include file="/WEB-INF/views/include/header.jsp"%>

				<!-- Content -->
				<div class="container">
					<div class="col-6">
			<%-- 			<h2 id="groupIdx">GroupIdx : ${groupIdx}</h2> --%>
						<h2 id="groupName">GroupName : ${campingGroup.groupName} </h2>
					<!-- 	 <span class="input-group mb-3">userName : </span>-->
						  <input type="hidden" id="userNamea" value="${user.name}"><br>
						<input type="hidden" id="roomIda" value="${room.roomId}">

					</div>
					<div>
						<div id="msgArea" class="col"></div>
						
						<div class="col-6 inputText" >
							<div class="input-group -xsmall">
								<input type="text" id="msg" class="form-control" aria-label="Recipient's username"
									aria-describedby="button-addon2">
								<span class="input-group-append">
									<button class="button " type="button" id="button-send">전송</button>
								</span>
							</div>
					
							<br> <a class="button" href="/group/newGroupTodo?groupIdx=${groupIdx}">모임생성</a>
								 <a class="button" href="/group/recommendDate?groupIdx=${groupIdx}">날짜 추천</a>
							</div>	
							
					</div>
				</div>
			</div>
		</div>

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>
	</div>
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>
</body>

<script defer src="${context}/resources/assets/js/chat/room.js"></script>
</html>
