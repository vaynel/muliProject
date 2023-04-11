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
                @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Stylish&display=swap');

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
                    <br>
                    <div class="row" id="row-1" >
                        <div class="col-xs-6 col-sm-6"  id="photo-1"
                             style="height:430px; text-align:center;">
                            <!--<c:forEach items="${files}" var="files">
                            <img src="/campingHome/images/${files.gnIdx}/${files.renameFileName}" alt="캠핑의집">
                            </c:forEach> -->
                            <!-- 사진 크기 참조 -->
                            <img src="https://t1.daumcdn.net/cfile/tistory/991EC1495AB1EA9112"
                                 style="width:633px; height:350px;
                            z-index:1;">
                            <!-- 왼쪽 화살표(버튼 용도) -->
                            <img src="https://www.flaticon.com/svg/vstatic/svg/3916/3916821.svg?token=exp=1680595035~hmac=fae4d86a6e996619e7b03f6cc1ba2644"
                                 style="width:50px; height:50px; z-index:100;
                            position:absolute; top:350px; right:350px;"
                                 a href="#">
                            <!-- 오른쪽 화살표(버튼 용도) -->
                            <img src="https://www.flaticon.com/svg/vstatic/svg/3916/3916826.svg?token=exp=1680595039~hmac=2cdeb4d383306604d9869bbe9fa69871"
                                 style="width:50px; height:50px; z-index:100;
                            position:absolute; top:350px; right:250px;"
                                 a href="#">
                        </div>
                        <div class="col-xs-6 col-sm-6" id="title-1"
                             style="height:430px;">
                            <p style="font-family: 'Stylish', sans-serif;">2023년 4월 5일 20:21</p>
                            <h1 style="font-family: 'Stylish', sans-serif;
                      	line-height:0.1;">아무말제목(20자제한)</h1>
                            <br>

                            <div class="row">
                                <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png"
                                     style="height:30px; width:55px;">
                                <p style="font-family: 'Stylish', sans-serif;
						padding:0px 0px 0px 10px;">서수진 · 지리산 대경오토캠핑장</p>
                            </div>
                            <h3 style="color:blue; font-family: 'Stylish', sans-serif;
						line-height:0.1; margin:0px 0px 15px;">
                                #산, #경남, #차박</h3>

                        </div>
                    </div> <!-- row-1 끝 -->

                    <!-- 본문 -->
                    <div class="row" id="row-2">
                        <div class="col-12" id="text-2"
                             style="height:340px;">
                            <h2 style="color:black; font-family: 'Stylish', sans-serif;">
                                끓는 노년에게서 방황하였으며, 꽃이 그들은 군영과 끓는 밝은 뜨거운지라, 것이다. 것은 사라지지 구할 하는 불어 너의 약동하다.
                                이상의 것은 작고 그들은 속에서 남는 피어나기 뼈 귀는 뿐이다. 안고, 생명을 이 인간의 없는 있는 피어나는 이것을 든 있는가? 청춘 이상을 꽃 얼마나 청춘에서만 있다. 그들의 천자만홍이 구할 곳으로 인생에 구하기 사막이다.
                                별과 같이 꽃이 원대하고, 가는 광야에서 것이다. 방지하는 커다란 예수는 그들은 쓸쓸하랴?
                                이것은 대중을 따뜻한 그들은 수 그들은 피에 때문이다. 너의 피가 끓는 그들에게 희망의 이 것이다.
                                이상의 없으면 같은 얼음 속에 피어나는 힘차게 들어 운다. 피가 산야에 속에 것은 뿐이다. (※한글판 로렘 잇숨)
                            </h2>
                            <div id="line"
                                 style="height:3px; width:100%; background-color:black;">
                            </div>
                        </div>
                    </div> <!-- row-2 끝 -->

                    <div class="row" id="row-3" style="width:1300px; position:relative; left:26px;">
                        <div class="col-xl-12" id="ad"
                             style="background-color:#FAEBD7; height:300px; line-height:0.01;">
                            <img src="http://th1.tmon.kr/thumbs/image/886/09d/b1d/db4607cd5_700x700_95_FIT.jpg"
                                 style="height:270px; width:270px;
                    object-fit: cover; object-position: top; border-radius: 50%;
                    margin: 15px 20px 0 20px;">
                            <img src="http://th1.tmon.kr/thumbs/image/886/09d/b1d/db4607cd5_700x700_95_FIT.jpg"
                                 style="height:270px; width:270px;
                    object-fit: cover; object-position: top; border-radius: 50%;
                    margin: 15px 20px 0 20px;">
                            <img src="http://th1.tmon.kr/thumbs/image/886/09d/b1d/db4607cd5_700x700_95_FIT.jpg"
                                 style="height:270px; width:270px;
                    object-fit: cover; object-position: top; border-radius: 50%;
                    margin: 15px 20px 0 20px;">
                            <img src="http://th1.tmon.kr/thumbs/image/886/09d/b1d/db4607cd5_700x700_95_FIT.jpg"
                                 style="height:270px; width:270px;
                    object-fit: cover; object-position: top; border-radius: 50%;
                    position:absolute;
                    margin: 15px 20px 0 20px;">
                        </div>
                    </div> <!-- row-3 끝 -->
                    <br>
                    <!-- 댓글 -->
                    <div class="row" id="row-4">
                        <div class="col-xl-12" id="reply"
                             style="height:300px;">
                            <div style="width:1300px; height:150px;
                    border-radius:8px; position:absoulte; left:50px;
                    box-shadow: 3px 3px 3px 3px rgb(220,220,220);">
                            </div>
                            <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png"
                                 style="height:50px; width:50px; position:absolute; top:17px; left:40px; z-index:1;">
                            <h3 style="font-family: 'Stylish', sans-serif; color:020F37;
                    position:absolute; bottom:225px; left:100px;">여태양</h3>
                            <h4 style="font-family: 'Stylish', sans-serif;
                    position:absolute; bottom:240px; right:30px;">2023.4.6</h4>
                            <h4 style="font-family: 'Stylish', sans-serif;
                    position:absolute; bottom:230px; left:170px;">이 이상 예쁘게 못하겠어요 이게 한계인 것 같아요. 모르겠다 싶은 거 있으시면 디코 메시지 보내주세요 (140자 제한)</h4>
                            <p style="font-family: 'Stylish', sans-serif;
                    position:absolute; bottom:180px; left:100px;">삭제 · 수정</p>
                            <img src="https://cdn-icons-png.flaticon.com/512/39/39559.png"
                                 style="width:30px; height:30px;
						position:relative; bottom:55px; left:75px;">
                            <div style="width:1300px; height:150px;
                    border-radius:8px; position:absoulte; left:50px;
                    box-shadow: 3px 3px 3px 3px rgb(220,220,220);">
                                <button class="w-btn w-btn-indigo" type="button"
                                        style="font-family: 'Stylish', sans-serif; font-size:15px; text-align:center;
    				background: whitesmoke; display: table-cell; color:black;
    				position:relative; left:1190px; top:100px;">
                                    입력
                                </button>
                            </div>
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