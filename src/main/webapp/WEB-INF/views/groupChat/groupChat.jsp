<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link rel="stylesheet"	href="${context}/resources/assets/css/chat/chat.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<%@ include file="/WEB-INF/views/include/header.jsp"%>

					<div class="container">
						<div class="col-6">
						
							<br><h2 id="groupName">GroupName : ${campingGroup.groupName} </h2>
							  <input type="hidden" id="userNamea" value="${user.name}">
							<input type="hidden" id="roomIda" value="${room.roomId}">
		
						</div>
						<div class="row" id="chatRow">
						<div id="msgArea"  class="col"></div>
						
						</div>
						<div class="input-group -xsmall">
							<a class="button" href="#none" onclick="window.open('${context}/group/newGroupTodo?groupIdx=${groupIdx}', 'new', 'scrollbars=no, resizable=no width=300 height=350, left=750, top=150');">모임생성</a>
							<a class="button" href="/group/recommendDate?groupIdx=${groupIdx}">날짜추천</a>
							<input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
							<span class="input-group-append">
								<button class="button " type="button" id="button-send">전송</button>
							</span>
							
						</div>


			</div>
		</div>
	</div>


	<!-- Sidebar -->
	<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	</div>
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>
</body>
<script defer src="${context}/resources/assets/js/chat/room2.js"></script>
</html>























<!-- <div class="bubbleWrapper">
	<div class="inlineContainer">
		<span class="groupMember" > 유저1</span>
		<div class="otherBubble other">No ninjas!</div>
	</div>
	<span class="other">08:41</span>
</div>

<div class="bubbleWrapper">
	<div class="inlineContainer own">
		<img class="inlineIcon"
			src="https://www.pinclipart.com/picdir/middle/205-2059398_blinkk-en-mac-app-store-ninja-icon-transparent.png">
		<div class="ownBubble own">The first rule of being a ninja is, 'Do no harm.'</div>
	</div>
	<span class="own">08:55</span>
</div>

<div class="bubbleWrapper">
	<div class="inlineContainer">
		<img class="inlineIcon" src="https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png">
		<div class="otherBubble other">Knowing when to leave requires training.</div>
	</div>
</div>
<span class="other">10:13</span>

<div class="bubbleWrapper">
	<div class="inlineContainer own">
		<img class="inlineIcon"
			src="https://www.pinclipart.com/picdir/middle/205-2059398_blinkk-en-mac-app-store-ninja-icon-transparent.png">
		<div class="ownBubble own">Stunned but impressed.</div>
	</div>
	<span class="own">11:07</span>
</div>

<div class="bubbleWrapper">
	<div class="inlineContainer">
		<img class="inlineIcon"
			src="https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png">
		<div class="otherBubble other">How about throwing stars?</div>
	</div>
	<span class="other">11:11</span>
</div> -->
