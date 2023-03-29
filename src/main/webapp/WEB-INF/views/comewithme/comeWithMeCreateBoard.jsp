<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>


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
					
					<form action="${context}/comewithme/upload" id="form" method="post"  enctype="multipart/form-data">
					 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div >
					<li>제목</li><input name="title" style="color: black" type="text" id="title">
					</div>
					<br>
					<br>

					<li>내용</li>
					<div>
						<input type="text" name="content"  id="content"/>
					</div>
					<br>
					<li>원하는 캠핑 장소는?</li> 
					<select style="width: 190px;" id="place">
						<option value="" selected></option>
						<option value="산">산</option>
						<option value="바다">바다</option>
					</select> <br>

					<li>원하는 캠핑방식</li> 
					<select style="width: 190px;" id="campingWay">
						<option  value="" selected></option>
						<option value="차박">차박</option>
						<option value="오토">오토</option>
						<option value="모토">모토</option>
					</select> <br>

					<li>원하는 성별은?</li> 
					<select style="width: 190px;" id="gender">
						<option value="" selected></option>
						<option value="남">남</option>
						<option value="여">여</option>
						<option value="무관">무관</option>
					</select> <br>

					<li style="color: black">원하는 연령층은?</li> 
					<select style="width: 190px;" id="ageAverage">
						<option value="" selected></option>
						<option value="20대">20대</option>
						<option value="30대">30대</option>
						<option value="40대">40대</option>
					</select> <br>
					
					<li style="color: black">원하는 인원수는?</li> 
					<input type="number" placeholder="숫자만 입력해주세요." id="numOfPerson">
					<br>

					<div class="tr_hashTag_area">
						<ul id="tag-list"></ul>

						<div class="form-group">
								<input type="text" id="tag" size="7" placeholder="엔터로 해시태그를 등록해주세요." style="width: 300px;" />
						</div>
						<div class="col-12">
                            <strong>사진 등록</strong>
                            <input type="file" name="files" id="contract_file" multiple/>
                        </div>						
						
                          <br>   <button type="submit" id="btnClick" class="button primary" style="color:white; width:100%">게시글 저장하기</button>
                          
					</div>
</form>
				</section>
			</div>
		</div>
		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	</div>

	<!-- Scripts -->
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

	<%-- <script defer src="${context}/resources/assets/js/comeWithMe/createBoardJavaScript.js"></script> --%>
</body>
</html>