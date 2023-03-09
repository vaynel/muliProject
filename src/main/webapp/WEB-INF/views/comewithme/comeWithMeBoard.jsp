<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!-- head 설정 -->
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<%@ include file="/WEB-INF/views/include/header.jsp" %>

							<!-- Content -->
								<section>
									<header class="main">
										<h1>게시글 작성</h1>
										<hr>
									</header>
									<!-- 
										1, 원하는 장소 (산, 바다, 무관)
										2, 원하는 캠핑 방식(차박, 오토, 모토, 무관)
										3, 원하는 성별 ( 남, 여, 무관)
										4, 원하는 연령층( ... , 무관)
										5, 원하는 지역 ( ... , 무관)
									 -->
									 
										 <li>원하는 캠핑 장소는?</li>
										 <select>
										 	<option selected></option>
										 	<option value="mount">산</option>
										 	<option value="sea">바다</option>
										 	<option value="place">다 좋아</option>
										 </select>
										 <br>
										 
										 <li>원하는 캠핑방식</li>
										 <select>
										 	<option selected></option>
										 	<option value="car">차박</option>
										 	<option value="outo">오토</option>
										 	<option value="moto">모토</option>
										 	<option value="all">다 좋아</option>
										 </select>
										 <br>
										 
										 <li>원하는 성별은?</li>
										 <select>
										 	<option selected></option>
										 	<option value="M">남</option>
										 	<option value="F">여</option>
										 </select>
										 <br>
										 
										
									
									
									
								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

			</div>

		<!-- Scripts -->
			<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>

	</body>
</html>