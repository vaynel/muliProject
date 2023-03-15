<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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




	<script>
		$(document)
				.ready(
						function() {
							var tag = {};
							var counter = 0;

							// 입력한 값을 태그로 생성한다.
							function addTag(value) {
								tag[counter] = value;
								counter++; // del-btn 의 고유 id 가 된다.
							}

							// tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
							function marginTag() {
								return Object.values(tag).filter(
										function(word) {
											return word !== "";
										});
							}

							// 서버에 제공
							$("#tag-form").on("submit", function(e) {
								var value = marginTag(); // return array
								$("#rdTag").val(value);

								$(this).submit();
							});

							$("#tag")
									.on(
											"keypress",
											function(e) {
												var self = $(this);

												//엔터나 스페이스바 눌렀을때 실행
												if (e.key === "Enter"
														|| e.keyCode == 32) {

													var tagValue = self.val(); // 값 가져오기

													// 해시태그 값 없으면 실행X
													if (tagValue !== "") {

														// 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
														var result = Object
																.values(tag)
																.filter(
																		function(
																				word) {
																			return word === tagValue;
																		})

														// 해시태그가 중복되었는지 확인
														if (result.length == 0) {
															$("#tag-list")
																	.append(
																			"<li class='tag-item'>"
																					+ tagValue
																					+ "<span class='del-btn' idx='"+counter+"'>x</span></li>");
															addTag(tagValue);
															self.val("");
														} else {
															alert("태그값이 중복됩니다.");
														}
													}
													e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
												}
											});

							// 삭제 버튼 
							// 인덱스 검사 후 삭제
							$(document).on("click", ".del-btn", function(e) {
								var index = $(this).attr("idx");
								tag[index] = "";
								$(this).parent().remove();
							});
						})
	</script>
</body>
</html>