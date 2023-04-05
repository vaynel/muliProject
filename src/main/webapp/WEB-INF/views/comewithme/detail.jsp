<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<style>
.leftbutton{
	position:static;
	left:0;
	bottom:0;
}
.rightbutton{
	position:static;
	left:0;
	bottom:0;
}
.centerbutton{
	position:static;
	left:0;
	bottom:0;
}

.popup > .title{
    border-radius: 15px 15px 0 0;
    min-height: 40px;
    color: #fff;
    background-color: #b66;
    padding: 10px 15px;
    box-sizing: border-box;
    font-weight: bold;
}

.popup > .content {
    padding: 20px;
    box-sizing: border-box;
}

.popup > .cmd {
    bottom: 0;
    min-height: 40px;
    padding: 15px 15px;
    box-sizing: border-box;
    border-radius: 0 0 15px 15px;
    min-height: 40px;
    text-align: right;
}

.popup > .cmd .button {
    border-radius: 8px;
    padding: 5px 10px;
    border: 1px solid #aaa;
}

.popup > .cmd .button:hover {
    color: #fff;
    background-color: #000;
    border-color: #000;
}
</style>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>

<body class="dimmed">
	<div class="popup">
			<div class="title">
				<h1>${boardList.title}</h1>
				<p>작성일 : ${boardList.createDate}</p>
				<hr>
			</div>

	<div class="content">
			<div class="row">
				<div class="col-6 col-12-large">
					<c:forEach items="${files}" var="files">
						<tr>
							<td>
								<img src="/storage/${files.groupName}/${files.savePath}${files.renameFileName}" width="400px" height="300px">
								<br>
							</td>
						</tr>
					</c:forEach>
					<br>
				</div>
			</div>

			<tr>
				<td>인원수 : ${boardList.numOfPerson}<br></td>
				<td>장소 : ${boardList.place}<br></td>
				<td>모집 연령층 : ${boardList.ageAverage}<br></td>
				<td>캠핑 방식 : ${boardList.campingWay}<br><br></td>
			</tr>
			<pre>${boardList.content}</pre>
			<br>
	</div>
		<form action="/comewithme/remove" method="get">
			<input type="hidden" value="${boardList.bdIdx}" name="bdIdx">
			<button id="btnDel" class="leftbutton">
				<span>삭제</span>
			</button>
		</form>

		<form action="/comewithme/memberInsert" method="post">
			<input type="hidden" value="${boardList.bdIdx}" name="bdIdx"/> 
			<input type="hidden" value="${sessionScope.userId}" name="userId"/> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type="submit" id="btnMember" class="centerbutton">멤버 추가하기</button>
		</form>


		<form action="/comewithme/modify" method="get">
			<input type="hidden" value="${boardList.bdIdx}" name="bdIdx"/>
			<button id="btnModify" class="rightbutton">
				<span>수정</span>
			</button>
		</form>

	</div>




	<!-- Scripts -->
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

</body>
</html>