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
										<h1>장소추천</h1>
									</header>
									
									<ul>
										<li><a href="suggestPlace" class ="button primary small fit">장소추천1 </a></li>
										<br>
										<li><a href="suggestPlace" class ="button primary small fit">장소추천2 </a></li>
										<br>
										<li><a href="suggestPlace" class ="button primary small fit">장소추천3 </a></li>
										<br>
										<li><a href="suggestPlace" class ="button primary small fit">장소추천4 </a></li>
									</ul>
									
									
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