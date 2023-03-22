<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="${context}/resources/assets/css/main.css" />

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>

</head>
<body>
<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<div class="inner">
							<%@ include file="/WEB-INF/views/include/header.jsp" %>
						<!-- Content -->
						<form id="createRoom">
							<label>myUserId : <input id="userId" text="JaeHyun"> </label>
							<label>groupName : <input id="groupName"> </label>
							<label>maxMember : <input id="maxMember"> </label>
							<label>roomMaster : <input id="roomMaster"> </label>
							<button>방생성하기</button>
						</form>
						
							<div>채팅리스트</div>
									<tr>
									<td>그룹		</td>
									<td>방주인</td>
									<td>현재인원</td>
									<td>최대인원</td>
									<br>
									</tr>
									
								<tr>
							<c:forEach items="${MyGroupChatRoomList}" var="MyGroupChatRoomList">
								<td><a href="/groupChat/chatRoom?roomId=${MyGroupChatRoomList.roomId}&userId=">${MyGroupChatRoomList.groupIdx}</a></td>
							</c:forEach>
								</tr>
							<c:forEach items="${MyGroupChatList}" var="MyGroupChatList">
								<tr>
									<td>${MyGroupChatList.groupMaster}</td>
									<td>${MyGroupChatList.currentMember}</td>
									<td>${MyGroupChatList.maxMember}</td>
									<br>
								</tr>
							</c:forEach>	
							</div>
						</div>
				<!-- Sidebar -->
					<%@ include file="/WEB-INF/views/include/sidebar.jsp" %>
			</div>
		<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>
		<script src="${context}/resources/assets/js/chat/createRoom.js"></script>
		<script type="text/javascript">
		
		
		</script>
	
</body>
</html>
