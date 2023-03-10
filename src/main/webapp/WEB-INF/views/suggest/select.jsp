<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>

<link rel="stylesheet" href="${context}/resources/assets/css/suggest/suggest.css">


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
										<h1>장소추천</h1>
									</header>
										<h2 id="question">누구와 함께 가고 싶나요?</h2>
									
									<ul class="questionnaire" id="questionnaire">
									
										<!-- <li><a class ="button primary small fit option">가족 </a></li>
										<br>
										<li><a class ="button primary small fit option">친구 </a></li>
										<br>
										<li><a class ="button primary small fit option" >애인 </a></li>
										<br>
										<li><a href="#" class ="button primary small fit option">모임 </a></li> -->
										
									</ul>
									
									
								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

			</div>

		<!-- Scripts -->
			<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>
			<script defer src="${context}/resources/assets/js/suggest/suggestScript.js"></script>
			

	</body>
</html>



