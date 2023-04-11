<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head2.jsp"%>
 
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
						<h1 style="font-family: 'Stylish', sans-serif; text-align: center;">같이갈래</h1>
						<h2 style="font-family: 'Stylish', sans-serif; text-align: center; line-height: 0.1;">Come with me</h2>
						
						<img src="https://cdn-icons-png.flaticon.com/512/1001/1001371.png" style="cursor:pointer; height:50px; width:50px;  right:100px; top: 400px;" onclick="location.href='/comewithme/comeWithMeCreateBoard';">

					</header>
					
					<div class="row" id="1st">
					<c:forEach items="${boardList}" var="boardList"  varStatus="status">
						<div class="col-xs-6 col-sm-4 box" id="g1"  style=" height:600px; box-shadow: 7px 3px 3px gray;">
							<br>
							<c:if test="${boardList.renameFileName ne null}">
								<img src="/storage/${boardList.groupName}/${boardList.savePath}${boardList.renameFileName}" style="height:40%; width:100%;" alt="이미지파일">
							</c:if>
							<br>
							<!-- 게시글 제목 -->
							<h3 style="cursor:pointer; font-family: 'Stylish', sans-serif;" onclick='window.open("${context}/comewithme/detail?bdIdx=${boardList.bdIdx}", "new", " width=500, height=550, left=750, top=150, status=no, location=no ,scrollbars=no, resizable=no")'>${boardList.title} ( ${boardList.groupName} ) </h3>
							<%-- <h4 style=" font-family: 'Stylish', sans-serif;">${boardList.groupName}</h4> --%>
							<!-- 본문 -->
							<p style="font-family: 'Stylish', sans-serif;">${boardList.content}</p>
							<p style="font-family: 'Stylish', sans-serif; line-height : 0.1;">${boardList.crDate} · 모집수 1/${boardList.numOfPerson}</p>
							<div id="line-to-heart" style="position: absolute; bottom:0; width:94%">
							<!-- 구분선 -->
							<div class="line" style="background-color:black; height:2px; width:100%; line-height:0.1; position:relative; bottom:0px;">
							<br>
							</div>
							<br>
							<div class="row">
							<div id="profile" style="text-align:left;">
							<!-- 프로필 사진 -->
							<img src="https://friconix.com/png/fi-cnsuxl-user-circle.png" style="height:30px; width:30px; margin: 0 1em 0 0; float:left; position:relative; bottom:5px;">
							</div>
							<!-- 작성자 이름 -->
							<p style="font-family: 'Stylish', sans-serif; padding: 0px 0px 0px 0px; position:relative; bottom:5px;">by ${boardList.groupMaster}</p>
							<!-- 하트(좋아요) 이상하게 적용되서 지움 -->
							<!-- <img src="https://cdn-icons-png.flaticon.com/512/39/39559.png" style="width:55px; height:30px; position:relative; bottom:5px; left:230px;"> -->
							</div>
							</div>							
						</div>
						<br>
					</c:forEach>
					</div>
					<br>
					<!--페이징 버튼  -->
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