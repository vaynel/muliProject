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
									
									<h2 id="content">봉봉오토캠핑장</h2>
									<a href="http://www.bongcamp.com/default/">http://www.bongcamp.com/default/</a>
									<br>
									<div class="image left fit box alt row gtr-50 gtr-uniform col-4"><img src="${context}/resources/images/suggest/map_ex.png" alt="" /></div>
									
									
									
									
									
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