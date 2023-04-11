<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Header -->

<style>


@font-face {
	font-family: 'TheJamsil5Bold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2')
		format('woff2');
	font-weight: 700;
	font-style: normal;
}

.h1Style{
	color: rgba(227, 118, 119, 50);
	margin-top: 20px;
	position: absolute;
	top: 0;
	left: 0;
	font-size: 40px;
	font-family: 'TheJamsil5Bold';
}

.divStyle {
	margin-top: 20px;
	position: absolute;
	top: 0;
	right: 0;
	font-family: 'TheJamsil5Bold';
	font-size: 15px;
}

button{
	font-family: 'TheJamsil5Bold';
	font-size: 13px;
}
</style>

<header id="header">
	<h1 class="h1Style pt-2">떠나자</h1>
	<%
		String id = (String) session.getAttribute("loginUserName");
	%>
	<div class="divStyle pt-2">
		<%
			if (id != null) {
		%>
		<%=id%>
		님
		<button onclick="location.href='/members/logout'"
			style="margin: 0 10px;">로그아웃</button>
		<%
			} else {
		%>
		<button onclick="location.href='/members/login'"
			style="margin: 0 10px;">로그인</button>
		<%
			}
		%>
	</div>
</header>