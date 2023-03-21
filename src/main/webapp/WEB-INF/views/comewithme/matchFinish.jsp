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
						<h1>.시발 매칭 갯새키</h1>
						<hr>
						<li><a href="/comewithme/comeWithMeCreateBoard">게시글 작성하러 가기</a></li>
					</header>
					<tr>
						<th style="width: 10%; height: 20%;"><span>| 번호 |</span></th>
						<th style="width: 70%;"><span> 제목 |</span></th>
						<th style="width: 10%;"><span> 내용 |</span></th>
						<th style="width: 10%;"><span> 좋아요 |</span></th>
						<th style="width: 10%;"><span> 등록일 |</span></th>
						<th style="width: 10%;"><span> 모집 인원 수 |</span></th>
						<br>
					</tr>
					<c:forEach items="${boardList}" var="boardList">
								<tr>
									<td>${boardList.bdIdx}</td>
									<td>${boardList.title}</td>
									<td>${boardList.content}</td>
									<td>${boardList.likeCount}</td>
									<td>${boardList.createDate}</td>
									<td>${boardList.numOfPerson}</td>
									<br>
								</tr>
					
					</c:forEach>
					
					<div class="row mt-3">
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		   
		    <li class="page-item">
		      <a class="page-link" href="/comewithme/comeWithMeList?page=${paging.prevPage}">Previous</a>
		    </li>
		   
		    <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
		    	<li class="page-item"><a class="page-link" href="/comewithme/comeWithMeList?page=${page}">${page}</a></li>
		    </c:forEach>
		  
		    <li class="page-item">
		      <a class="page-link" href="/comewithme/comeWithMeList?page=${paging.nextPage}">Next</a>
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