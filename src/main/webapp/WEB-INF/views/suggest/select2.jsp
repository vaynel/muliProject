<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>

<link rel="stylesheet" href="/resources/assets/css/suggest/suggest.css?v=<%= System.currentTimeMillis() %>">



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
					<header class="main"> <h1 id="recommend">장소추천</h1> </header>
					<div style="text-align: right;">
						<button class="noChoice1" type="button" id="nochoice" a href="#"> 아무것도 선택하지 않음 </button>
					</div>
					
					<h2>어떤 종류의 캠핑을 가 보고 싶은가요?</h2>
					<div id="campingContainer">
						<input type="radio" name="induty" value="일반야영장" id="select01" checked />
							<label for="select01">일반 야영장</label>
						<input type="radio" name="induty"  value="자동차야영장" id="select02" />
							<label for="select02">자동차 야영장</label>
						<input type="radio" name="induty" value="카라반" id="select03" />
							<label for="select03">카라반</label>
						<input type="radio" name="induty" value="글램핑" id="select04" /> 
							<label for="select04">글램핑</label>
					</div><br>
					
					<div id="choosingContainer" style="display: flex; flex-wrap: wrap;">	
					
						<div id="campingRegion" style="margin-right: 10px;">
							<select name="doNm" >
								<option value="">지역을 선택하세요.</option>
								<option value="경기도">경기도</option>
								<option value="강원도">강원도</option>
								<option value="충청북도">충청북도</option>
								<option value="충청남도">충청남도</option>
								<option value="전라북도">전라북도</option>
								<option value="전라남도">전라남도</option>
								<option value="경상북도">경상북도</option>
								<option value="경상남도">경상남도</option>
								<option value="제주특별시">제주특별시</option>
							</select>
						</div>					
						<br>
					
						<div id="smallRegion">
						<select name="sigunguNm" >
							<option value="">세부 지역을 선택하세요.</option>
						</select>
						</div>
					</div>
					<br>
					<div id="whereCamping">
						<h2>어디로 가 보고 싶은가요?</h2>
						<input type="radio" name="lctCl" value="산" id="select05"  /> 
							<label for="select05">산</label> 
						<input type="radio" name="lctCl" value="바다" id="select06" />
							<label for="select06">바다</label> 
						<input type="radio"	name="lctCl" value="계곡" id="select07" /> 
							<label for="select07">계곡</label> 
						<input type="radio"	name="lctCl" value="도심" id="select08" /> 
							<label for="select08">도심</label> 
						<input type="radio"	name="lctCl" value="무관" id="select09" /> 
							<label for="select09">상관없다</label>
					</div>
					<button  id="btnSummit" >확인</button>
					
					<div id="campsiteList">
					<br><br>
						<h2>캠핑장 리스트</h2>
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
						</div></tr>
						
						</c:forEach>
						
						<div class="row mt-3">
		                    <nav aria-label="Page navigation example">
		                        <ul class="pagination justify-content-center">
		
		                            <li class="page-item">
		                                <a class="page-link" href="/suggest/select2?page=${paging.prevPage}">Previous</a>
		                            </li>
		
		                            <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
		                                <li class="page-item"><a class="page-link" href="/suggest/select2?page=${page}">${page}</a></li>
		                            </c:forEach>
		
		                            <li class="page-item">
		                                <a class="page-link" href="/suggest/select2?page=${paging.nextPage}">Next</a>
		                            </li>
		
		                        </ul>
		                    </nav>
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
	<script defer src="${context}/resources/assets/js/suggest/suggestScript2.js"></script>


</body>
</html>



