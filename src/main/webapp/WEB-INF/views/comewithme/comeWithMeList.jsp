<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!-- head 설정 -->
<body class="is-preload">

	<style>
	@import url('https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Stylish&display=swap');


	#g1 {

	}
	
	#g2 {
		background-color: #7FD9D6;
	}
	
    #g3 {
		background-color: #C4F2CE;
	}
	
	#g4 {
		background-color: #9FDEBD;
	}
	
	#g5 {
		background-color: #80CEBE;
	}
	
	#g6 {
		background-color: #EFF4E7;
	}
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
						text-align: center;">같이가자</h1>
						<h2 style="font-family: 'Stylish', sans-serif;
						text-align: center; line-height: 0.1;">Come with me</h2>
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
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">2023년 4월 22일 · 0개의 댓글</p>
							<p style="color:blue; line-height : 0.1;">#산, #경남, #오토캠핑</p>
							<div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;">
							<br>
							</div>
							<br>
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png"
							style="height:30px; width:30px;
							margin: 0 1em 0 0; line-height:0.1; float:left;">
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif;">by 서지윤</p>
							</div>
						</div>
						<br>
						<div class="col-xs-6 col-sm-4" id="g2" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;
						">

						</div>
						
						<div class="col-xs-6 col-sm-4" id="g3" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">

					</div>
					</div>
					
					<div class="row" id="2nd">
						<div class="col-xs-6 col-sm-4" id="g4" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
							
						</div>
						
						<div class="col-xs-6 col-sm-4" id="g5" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
							
						</div>
						
						<div class="col-xs-6 col-sm-4" id="g6" 
						style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
							
					</div>
					</div>


					<c:forEach items="${boardList}" var="boardList">
						<tr>
							<td>${boardList.bdIdx}</td>
							<td><a
								href="${context}/comewithme/detail?bdIdx=${boardList.bdIdx}">${boardList.title}</a></td>
							<td>${boardList.content}</td>
							<td>${boardList.likeCount}</td>
							<td>${boardList.createDate}</td>
							<td>${boardList.numOfPerson}</td>
							<br>
						</tr>

					</c:forEach>
					<br>
					<tr>
						<td>1</td>
						<td><a>title</a></td>
						<td>content</td>
						<td>like</td>
						<td>date</td>
						<td>numOfperson</td>
						<br>
					</tr>




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