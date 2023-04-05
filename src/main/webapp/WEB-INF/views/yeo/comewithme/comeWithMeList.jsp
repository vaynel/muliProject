<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>


<link rel="stylesheet" href="${context}/resources/assets/css/yeo/boardDetail.css">

<!-- head 설정 -->
<body class="is-preload">

	<style>
	@import url('https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Stylish&display=swap');

	.material-symbols-outlined {
  		font-variation-settings:
  		'FILL' 0,
  		'wght' 400,
		'GRAD' 0,
	    'opsz' 48
	}

	</style>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<%@ include file="/WEB-INF/views/include/header.jsp"%>

				<!-- Content -->
				<section>
					<header class="main">
						<h1 style="font-family: 'Stylish', sans-serif;
						text-align: center;">같이갈래</h1>
						<h2 style="font-family: 'Stylish', sans-serif;
						text-align: center; line-height: 0.1;">Come with me</h2>
						
						<img src="https://cdn-icons-png.flaticon.com/512/1001/1001371.png"
							style="height:50px; width:50px;
							position:absolute; right:100px; top: 400px;"
							a href="#">
					</header>
					<br>
					<br>
					<div class="row" id="1st">
						<div class="col-xs-6 col-sm-4" id="g1" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
							<br>
							<img src="https://m.thankqcamping.com/file/2022/09/06/thumbM_2022090663329.16.jpg"
							style="height:40%; width:100%;">
							<br>
							<!-- 게시글 제목 -->
							<h3 style="font-family: 'Stylish', sans-serif;">별빛캠핑장 한가족04 글자수 공백포함 20자 제한</h3>
							<!-- 본문 -->
							<p style="font-family: 'Stylish', sans-serif;">Lorem ipsum dolor sit amet, consectetur adipiscing elit Duis aute irure dolor in reprehenderit in voluptate 사진 있을 시 썸네일에 보이는 글자수 공백 포함 155자로 자르기 (155자 세줄꽉참)</p>
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">2023년 4월 22일 · 모집수 2/4</p>
							<p style="color:blue; line-height : 0.1;">#산, #경북, #별빛캠핑장</p>
							
							<div id="line-to-heart" style="position:relative; top:2px;">
							<!-- 구분선 -->
							<div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;
							position:relative; bottom:0px;">
							<br>
							</div>
							<br>
							<div class="row">
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png"
							style="height:30px; width:30px;
							margin: 0 1em 0 0; float:left;
							position:relative; bottom:5px;">
							</div>
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif;
							padding: 0px 0px 0px 0px;
							position:relative; bottom:5px;">by 서지윤</p>
							<!-- 하트(좋아요) -->
							<img src="https://cdn-icons-png.flaticon.com/512/39/39559.png"
							style="width:55px; height:30px;
							position:relative; bottom:5px; left:230px;">
							</div>
							</div>							
						</div>
						<br>
						<div class="col-xs-6 col-sm-4" id="g2" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
						<br>
							<!-- 게시글 제목 -->
							<h3 style="font-family: 'Stylish', sans-serif;">서울 노을캠핑장 남자 2인 모집</h3>
							<!-- 본문 -->
							<p style="font-family: 'Stylish', sans-serif;">
							neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur abc
							사진 있을 시 글자표시 450자</p>
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">2023년 4월 21일 · 모집수 1/3</p>
							<p style="color:blue; line-height : 0.1;">#서울, #노을캠핑장</p>
							<br>
							<!-- 선부터 하트까지 -->
							<div id="line-to-heart" style="position:relative; top:77px;">
							<!-- 구분선 -->
							<div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;
							position:relative; bottom:0px;">
							<br>
							</div>
							<br>
							<div class="row">
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png"
							style="height:30px; width:30px;
							margin: 0 1em 0 0; float:left;
							position:relative; bottom:5px;">
							</div>
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif;
							padding: 0px 0px 0px 0px;
							position:relative; bottom:5px;">by 김이서</p>
							<!-- 하트(좋아요) -->
							<img src="https://cdn-icons-png.flaticon.com/512/39/39559.png"
							style="width:55px; height:30px;
							position:relative; bottom:5px; left:230px;">
							</div>
							</div> <!-- 선부터 하트까지 끝 -->
						</div>
						
						<div class="col-xs-6 col-sm-4" id="g3" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
						
						<br>
							<!-- 게시글 제목 -->
							<h3 style="font-family: 'Stylish', sans-serif;">대왕암공원 오토캠핑장 여자만 (모집완)</h3>
							<!-- 본문 -->
							<p style="font-family: 'Stylish', sans-serif;">
							neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur abc
							사진 있을 시 글자표시 450자</p>
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">2023년 4월 20일 · 모집수 4/4</p>
							<p style="color:blue; line-height : 0.1;">#대왕암공원, #울산, #오토캠핑</p>
							<br>
							<!-- 선부터 하트까지 -->
							<div id="line-to-heart" style="position:relative; top:77px;">
							<!-- 구분선 -->
							<div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;
							position:relative; bottom:0px;">
							<br>
							</div>
							<br>
							<div class="row">
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png"
							style="height:30px; width:30px;
							margin: 0 1em 0 0; float:left;
							position:relative; bottom:5px;">
							</div>
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif;
							padding: 0px 0px 0px 0px;
							position:relative; bottom:5px;">by 성지연</p>
							<!-- 하트(좋아요) -->
							<img src="https://cdn-icons-png.flaticon.com/512/39/39559.png"
							style="width:55px; height:30px;
							position:relative; bottom:5px; left:230px;">
							</div>
							</div> <!-- 선부터 하트까지 끝 -->
						
						
						
						
						
					</div>
					</div>
					
					<div class="row" id="2nd">
						<div class="col-xs-6 col-sm-4" id="g4" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
							
							
						<br>
							<!-- 게시글 제목 -->
							<h3 style="font-family: 'Stylish', sans-serif;">부산항 힐링야영장 파티원 구함 (모집완)</h3>
							<!-- 본문 -->
							<p style="font-family: 'Stylish', sans-serif;">
							neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur abc
							사진 있을 시 글자표시 450자</p>
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">2023년 4월 10일 · 모집수 4/4</p>
							<p style="color:blue; line-height : 0.1;">#대왕암공원, #울산, #오토캠핑</p>
							<br>
							<!-- 선부터 하트까지 -->
							<div id="line-to-heart" style="position:relative; top:77px;">
							<!-- 구분선 -->
							<div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;
							position:relative; bottom:0px;">
							<br>
							</div>
							<br>
							<div class="row">
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png"
							style="height:30px; width:30px;
							margin: 0 1em 0 0; float:left;
							position:relative; bottom:5px;">
							</div>
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif;
							padding: 0px 0px 0px 0px;
							position:relative; bottom:5px;">by 주은하</p>
							<!-- 하트(좋아요) -->
							<img src="https://cdn-icons-png.flaticon.com/512/39/39559.png"
							style="width:55px; height:30px;
							position:relative; bottom:5px; left:230px;">
							</div>
							</div> <!-- 선부터 하트까지 끝 -->	
							
							
							
						</div>
						
						<div class="col-xs-6 col-sm-4" id="g5" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
							
														<br>
							<img src="https://www.5gcamp.com/files/camping/2018/03/02/9c1cd582a187321b32721fbf2be51acf232313.jpg"
							style="height:40%; width:100%;">
							<br>
							<!-- 게시글 제목 -->
							<h3 style="font-family: 'Stylish', sans-serif;">달천공원 오토캠핑장 남자 2명 구함</h3>
							<!-- 본문 -->
							<p style="font-family: 'Stylish', sans-serif;">주말에 시간 나시는 분</p>
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">2023년 4월 7일 · 모집수 2/3</p>
							<p style="color:blue; line-height : 0.1;">#오토캠핑, #창원, #경남, #불멍, #오지캠핑</p>
							
							<div id="line-to-heart" style="position:relative; top:59px;">
							<!-- 구분선 -->
							<div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;
							position:relative; bottom:0px;">
							<br>
							</div>
							<br>
							<div class="row">
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png"
							style="height:30px; width:30px;
							margin: 0 1em 0 0; float:left;
							position:relative; bottom:5px;">
							</div>
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif;
							padding: 0px 0px 0px 0px;
							position:relative; bottom:5px;">by 김지훈</p>
							<!-- 하트(좋아요) -->
							<img src="https://cdn-icons-png.flaticon.com/512/39/39559.png"
							style="width:55px; height:30px;
							position:relative; bottom:5px; left:230px;">
							</div>
							</div>		
							
							
							
							
							
						</div>
						
						<div class="col-xs-6 col-sm-4" id="g6" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
						
														<br>
							<img src="http://appdata.hungryapp.co.kr/images/hatdog/ar/2020_11/M16043911905665687.jpg"
							style="height:40%; width:100%;">
							<br>
							<!-- 게시글 제목 -->
							<h3 style="font-family: 'Stylish', sans-serif;">전주 아중호수 캠핑장 함께해요</h3>
							<!-- 본문 -->
							<p style="font-family: 'Stylish', sans-serif;"></p>
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">2023년 4월 1일 · 모집수 2/5</p>
							<p style="color:blue; line-height : 0.1;">#전주, #아중호수, #SF관광농원</p>
							
							<div id="line-to-heart" style="position:relative; top:110px;">
							<!-- 구분선 -->
							<div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;
							position:relative; bottom:0px;">
							<br>
							</div>
							<br>
							<div class="row">
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png"
							style="height:30px; width:30px;
							margin: 0 1em 0 0; float:left;
							position:relative; bottom:5px;">
							</div>
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif;
							padding: 0px 0px 0px 0px;
							position:relative; bottom:5px;">by 이  림</p>
							<!-- 하트(좋아요) -->
							<img src="https://cdn-icons-png.flaticon.com/512/39/39559.png"
							style="width:55px; height:30px;
							position:relative; bottom:5px; left:230px;">
							</div>
							</div>								
						
							
					</div>
					</div>


	



					<div class="row mt-3" id="navigation">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">

								<li class="page-item"><a class="page-link"
									href="/comewithme/comeWithMeList?page=${paging.prevPage}">Previous</a>
								</li>

								<c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}"
									var="page">
									<li class="page-item"><a class="page-link"
										href="/comewithme/comeWithMeList?page=${page}">${page}</a></li>
								</c:forEach>

								<li class="page-item"><a class="page-link"
									href="/comewithme/comeWithMeList?page=${paging.nextPage}">Next</a>
								</li>

							</ul>
						</nav>
					</div>
				</section>

			</div>
		</div>


		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	</div>

	<!-- Scripts -->
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

</body>
</html>