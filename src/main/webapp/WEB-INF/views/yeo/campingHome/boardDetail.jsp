<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
<link rel="stylesheet" href="${context}/resources/assets/css/CampingHome/slideShow.css">
<link rel="stylesheet" href="${context}/resources/assets/css/SunnyTest/boardDetail.css">
<!-- head 설정 -->
<body class="campingHome">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">
    	<style>
    		@import url('https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Stylish&display=swap');    		
			.container {
				display: grid;
			}    		
    	</style>
			
            <%@ include file="/WEB-INF/views/include/header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
						<!--<h1>${board.title}</h1> -->
						<h1 style="font-family: 'Stylish', sans-serif;
						text-align: center;">캠핑의 집</h1>
						<h2 style="font-family: 'Stylish', sans-serif;
						text-align: center; line-height: 0.1;">Camping Home</h2>
                </header>
						
                  <div class="container">
                  <br>
                    <div class="row" id="row-1" >
                      <div class="col-xs-8 col-sm-8"  id="photo-1"
                      style="background-color:skyblue; height:500px; text-align:center;">
                      	 	<!--<c:forEach items="${files}" var="files">
                            <img src="/campingHome/images/${files.gnIdx}/${files.renameFileName}" alt="캠핑의집">
                            </c:forEach> -->
                            <!-- 사진 크기 참조 -->
                            <img src="https://t1.daumcdn.net/cfile/tistory/991EC1495AB1EA9112"
                            style="width:500px; height:350px;
                            z-index:1;">
                            <!-- 왼쪽 화살표(버튼 용도) -->
                            <img src="https://www.flaticon.com/svg/vstatic/svg/3916/3916821.svg?token=exp=1680595035~hmac=fae4d86a6e996619e7b03f6cc1ba2644"
                            style="width:50px; height:50px; z-index:100;"
                            a href="#">
                            <!-- 오른쪽 화살표(버튼 용도) -->
                            <img src="https://www.flaticon.com/svg/vstatic/svg/3916/3916826.svg?token=exp=1680595039~hmac=2cdeb4d383306604d9869bbe9fa69871"
                            style="width:50px; height:50px; z-index:100;"
                            a href="#">
                      </div>
                      <div class="col-xs-4 col-sm-4" id="title-1"
                      style="background-color:purple; height:500px;">
                      	<h1>Daybit sem void and Tezcatlipoca(sample title)</h1>
                      </div>
                    </div> <!-- row-1 끝 -->
                    
                    <div class="row" id="row-2">
                    <div class="col-xl-12" id="text-2"
                    style="background-color:gray; height:500px;">
                    <p style="color:black; font-family: 'Stylish', sans-serif;">
                    끓는 노년에게서 방황하였으며, 꽃이 그들은 군영과 끓는 밝은 뜨거운지라, 것이다. 것은 사라지지 구할 하는 불어 너의 약동하다.
					이상의 것은 작고 그들은 속에서 남는 피어나기 뼈 귀는 뿐이다. 안고, 생명을 이 인간의 없는 있는 피어나는 이것을 든 있는가? 청춘 이상을 꽃 얼마나 청춘에서만 있다. 그들의 천자만홍이 구할 곳으로 인생에 구하기 사막이다.
					별과 같이 꽃이 원대하고, 가는 광야에서 것이다. 방지하는 커다란 예수는 그들은 쓸쓸하랴?
					이것은 대중을 따뜻한 그들은 수 그들은 피에 때문이다. 너의 피가 끓는 그들에게 희망의 이 것이다.
					이상의 없으면 같은 얼음 속에 피어나는 힘차게 들어 운다. 피가 산야에 속에 것은 뿐이다.
                    </p>
                    </div>
                    </div> <!-- row-2 끝 -->
                    
                    <div class="row" id="row-3">
                    <div class="col-xl-12" id="ad"
                    style="background-color:blue; height:300px;">
                    </div>
                    </div> <!-- row-3 끝 -->
                    
                    <div class="row" id="row-4">
                    <div class="col-xl-12" id="reply"
                    style="background-color:turquoise; height:300px;">
                    <div style="background-color:lightgray; width:1300px; height:70px;
                    border-radius:8px;">
                    </div>
                    <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png"
                    style="height:50px; width:50px; position:absolute; top:15px;">
                    </div>
                    </div> <!-- row-4 끝 -->
                 </div>


            </section>

        </div>
    </div>

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

</div>

<!-- Scripts -->
<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>

<script src="${context}/resources/assets/js/campingHome/reply.js"></script>
<script src="${context}/resources/assets/js/campingHome/slideShow.js"></script>


</body>
</html>