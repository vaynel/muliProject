<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link rel="stylesheet" href="${context}/resources/assets/css/main.css" />
<link rel="stylesheet" href="${context}/resources/assets/css/group/groupChatList.css" />

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header"	content="${_csrf.headerName}"></meta>

</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<%@ include file="/WEB-INF/views/include/header.jsp"%>
				
				<!-- Content -->
				<!-- <form id="createRoom">
					<label>myUserId : <input id="userId" text="JaeHyun">
					</label> <label>groupName : <input id="groupName">
					</label> <label>maxMember : <input id="maxMember">
					</label> <label>groupMaster : <input id="groupMaster">
					</label>
					<button>방생성하기</button>
				</form> -->

					<h3>나의 그룹</h3>
				<div class="row gtr-200">
					
					
						<c:forEach items="${MyGroup['myGroups']}" var="Group" varStatus="status">
							<div class="col-6 col-12-medium">
							<div class="box">
								<c:set var="count" value="${status.count}"></c:set>
								<c:forEach items="${MyGroup['campingGroup']}" var="campingGroup" varStatus="st">					
									<c:if test="${count eq st.count}">
										<p>${st.count}.
											<a class="" href="/groupChat/groupChat?roomId=${Group.roomId}&groupIdx=${Group.groupIdx}">
											${campingGroup.groupName} </a>
											<span class="countMember">${campingGroup.currentMember} / ${campingGroup.maxMember}</span>
										</p>
										<p>GroupMaster : ${campingGroup.groupMaster}</p>
									</c:if>	
									
									
								</c:forEach>
									<form action="/group/withdrawGroup?groupIdx=${Group.groupIdx}" method="post">
										 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								    	<button class="button small countMember" >그룹 탈퇴</button>
									</form>
								<br>
							</div>
							</div>
						</c:forEach>
				</div>
			</div>
		</div>
		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>
	</div>
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>
	<script src="${context}/resources/assets/js/chat/createRoom.js"></script>

</body>
</html>
