<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<!-- head 설정 -->
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<%@ include file="/WEB-INF/views/include/header.jsp"%>

				<!-- Content -->
				<section>
					<header class="main">
						<h1 style="color: black">게시글 작성</h1>
						<hr>
					</header>
					<li style="color: black" type="text">제목</li> <input><br>
					<br>

					<li style="color: black" type="text">내용</li>
					<textarea rows="10" cols="100"></textarea>
					<br>
					<li style="color: black">원하는 캠핑 장소는?</li> <select
						style="width: 190px;">
						<option selected></option>
						<option value="mount">산</option>
						<option value="sea">바다</option>
					</select> <br>

					<li style="color: black">원하는 캠핑방식</li> <select
						style="width: 190px;">
						<option selected></option>
						<option value="car">차박</option>
						<option value="outo">오토</option>
						<option value="moto">모토</option>
					</select> <br>

					<li style="color: black">원하는 성별은?</li> <select
						style="width: 190px;">
						<option selected></option>
						<option value="M">남</option>
						<option value="F">여</option>
					</select> <br>

					<li style="color: black">원하는 연령층은?</li> <select
						style="width: 190px;">
						<option selected></option>
						<option value="twenty">20대</option>
						<option value="thirty">30대</option>
						<option value="fourty">40대</option>
					</select> <br>

					<div class="tr_hashTag_area">
						<div class="form-group">
							<input type="hidden" value="" name="tag" id="rdTag" />
						</div>

						<ul id="tag-list"></ul>

						<div class="form-group">
							<input type="text" id="tag" size="7" placeholder="엔터로 해시태그를 등록해주세요." style="width: 300px;" />
						</div>
					</div>
				</section>

			</div>
		</div>

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	</div>

	<!-- Scripts -->
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

	<script defer src="${context}/resources/assets/js/comeWithMe/comeWithMeScript.js"></script>
</body>
</html>