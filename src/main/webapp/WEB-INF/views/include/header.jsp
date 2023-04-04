<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Header -->
<header id="header">
	<a href="index.html" class="logo"><strong>Editorial</strong> by HTML5 UP</a>
	<%
	String id = (String)session.getAttribute("loginId");
	%>
	<ul class="icons">
		<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
		<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
		<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
		<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
		<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
	</ul>
	<%
	if(id!=null){
		%>
		<%=id %> 님 
		<button onclick="location.href='/members/logout'">로그아웃</button>
		<%
	}	
	else{
		%>
		<button onclick="location.href='/members/login'">로그인</button>
		<%
	}
	%>
</header>