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
								<h1>매칭</h1>
							</header>
							<h2 id="matchQuestion"></h2>
							<ul class="matchStart" id="matchStart"></ul>
							
							
							
						</section>

				</div>
			</div>
			<!-- Sidebar -->
			<%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

		</div>
	<!-- Scripts -->
			<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>
			<script defer src="${context}/resources/assets/js/comeWithMe/matchJavaScript.js"></script>
			

</body>
</html>