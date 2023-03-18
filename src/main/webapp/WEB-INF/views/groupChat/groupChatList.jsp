<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="${context}/resources/assets/css/main.css" />

<meta name="_csrf" th:content="${_csrf.token}">
<meta name="_csrf_header" th:content="${_csrf.headerName}">

</head>
<body>
<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<div class="inner">
							<%@ include file="/WEB-INF/views/include/header.jsp" %>
						<!-- Content -->
							<div>채팅리스트</div>
									<tr>
									<td>그룹		</td>
									<td>방주인</td>
									<td>현재인원</td>
									<td>최대인원</td>
									<br>
								</tr>
							<c:forEach items="${MyGroupChatList}" var="MyGroupChatList">
								<tr>
									<td>${MyGroupChatList.groupName}</td>
									<td>${MyGroupChatList.roomMaster}</td>
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
	
</body>
</html>
