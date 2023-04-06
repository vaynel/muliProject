<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Header -->
<header id="header">
	<a href="index.html" class="logo"><strong>제목</strong> 정하기 </a>
	<%
	String id = (String)session.getAttribute("loginId");
	%>
	<div>
	<%
	if(id!=null){
		%>
		<%=id %> 님      
		<button onclick="location.href='/members/logout'" style="margin: 0 10px; ">로그아웃</button>
		<%
	}	
	else{
		%>
		<button onclick="location.href='/members/login'" style="margin: 0 10px; ">로그인</button>
		<%
	}
	%>
	</div>
</header>