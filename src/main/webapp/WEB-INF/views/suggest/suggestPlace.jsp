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
									<c:forEach items="${campsites}" var="campsite">
										<h2>${campsite.facltNm}</h2>
										<tr>
											<a href="${campsite.homepage}">${campsite.homepage}</a><br>
											
										<div class="row">
										<div class="col-6 col-12-small">
											<div class="image left fit"><img src="${campsite.firstImageUrl}" alt="" /></div>
										</div>
										<div class="col-6 col-12-small left">
											<h3>캠핑장 소개</h3>
										<ul>
											<li>${campsite.lineIntro}<br></li>
											<li>${campsite.intro}<br></li>
											<li>${campsite.addr1}<br></li>
											<li>${campsite.tel}<br></li>
										</ul>
										</div>	
									</div>
									</c:forEach>
								
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