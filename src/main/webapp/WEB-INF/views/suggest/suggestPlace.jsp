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
									
									<div class="row">
										<div class="col-6 col-12-small">
											<div class="image left fit"><img src="${context}/resources/images/suggest/map_ex.png" alt="" /></div>
										</div>
										<div class="col-6 col-12-small left">
											<h3>여기를 다녀온 사람</h3>
										<ul>
											<li>
											<div class="avatar avatar-online">
												<img src="https://via.placeholder.com/50x50" alt="..." class="avatar-img rounded-circle">
											</div>여기 완전 추천 입니다!!<br></li>
												
											<li>
												<div class="avatar avatar-online">
													<img src="https://via.placeholder.com/50x50" alt="..." class="avatar-img rounded-circle">
												</div>안오시면 인생 손해 입니다.<br>
											</li>
											
											<li>
												<div class="avatar avatar-online">
												<img src="https://via.placeholder.com/50x50" alt="..." class="avatar-img rounded-circle">
												</div>사장님이 진짜 착해요!^^<br>
											</li>
										</ul>
										</div>	
									</div>
									
									
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