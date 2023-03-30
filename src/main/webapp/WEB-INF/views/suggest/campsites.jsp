<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>캠핑장 리스트</h2>
	<c:forEach items="${campsites}" var="campsite">
		<h2>${campsite.facltNm}</h2>
		<tr>
			<a href="${campsite.homepage}">${campsite.homepage}</a>
			<br>

			<div class="row">
				<div class="col-6 col-12-small">
					<div class="image left fit">
						<img src="${campsite.firstImageUrl}" alt="" />
					</div>
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

	<div class="row mt-3">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">

				<li class="page-item"><a class="page-link"
					href="/suggest/select2?page=${paging.prevPage}">Previous</a></li>

				<c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
					<li class="page-item"><a class="page-link"
						href="/suggest/select2?page=${page}">${page}</a></li>
				</c:forEach>

				<li class="page-item"><a class="page-link"
					href="/suggest/select2?page=${paging.nextPage}">Next</a></li>

			</ul>
		</nav>
	</div>



</body>
</html>