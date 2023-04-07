<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
<link rel="stylesheet" href="${context}/resources/assets/css/CampingHome/slideShow.css">
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
                                <div class="col-xs-6 col-sm-6"  id="photo-1" style="height:430px; text-align:center;">
                                    <div class="con">
                                        <div class ="album">

                                            <div class = "images" id="image">
                                                <c:forEach items="${files}" var="files">
                                                        <img src="/campingHome/images/${files.gnIdx}/${files.renameFileName}" alt="캠핑의집">
                                                </c:forEach>
                                            </div>

                                        </div>

                                            <img class="previous" src="https://cdn-icons-png.flaticon.com/512/608/608283.png" style="width:50px; height:50px; z-index:100;
                                position:absolute; top:350px; right:350px;"/>
                                            <img class="next" src="https://cdn-icons-png.flaticon.com/512/626/626043.png" style="width:50px; height:50px; z-index:100;
                                position:absolute; top:350px; right:250px;"/>

                                    </div>
                                </div>

                            <div class="col-xs-6 col-sm-6" id="title-1" style="height:430px;">
                                <p style="font-family: 'Stylish', sans-serif;">2023년 4월 5일 20:21</p>
                                <h1 style="font-family: 'Stylish', sans-serif;
                      	line-height:0.1;" value=''>${board.title}</h1>
                                <br>

                                <div class="row">
                                    <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png"
                                         style="height:30px; width:55px;">
                                    <p style="font-family: 'Stylish', sans-serif;
						padding:0px 0px 0px 10px;">서수진 · 지리산 대경오토캠핑장</p>
                                </div>
                                <h3 style="color:blue; font-family: 'Stylish', sans-serif;
						line-height:0.1; margin:0px 0px 15px;" value='${board.hashtag}'>#산, #경남, #차박</h3>

                                </div>
                            </div>


                            <!-- 본문 -->
                            <div class="row" id="row-2">
                                <div class="col-12" id="text-2" style="height:340px;">
                                    <h2 type="text" name="text" value='${board.text}'style="color:black; font-family: 'Stylish', sans-serif;">${board.text}</h2>

                                    <div id="line" style="height:3px; width:100%; background-color:black;"></div>

                                </div>
                            </div> <!-- row-2 끝 -->

                            <div class="row" id="row-3" style="width:1300px; position:relative; left:26px;">
                                <div class="col-xl-12" id="ad" style="background-color:#FAEBD7; height:300px; line-height:0.01;">
                                    <c:forEach items="${item}" var="t">
                                            <a href = ${t.link}>
                                            <image src="${t.image}" style="height:270px; width:270px;
                    object-fit: cover; object-position: top; border-radius: 50%;
                    position:relative;
                    margin: 15px 20px 0 20px; float: left" alt="제품상세사진"/>
                                            </a>
                                    </c:forEach>
                                </div>
                            </div> <!-- row-3 끝 -->


                        <div>
                            <form id="reply">
                                <h3>댓글</h3>
                                <ul>
                                    <li><a href="/campingHome/userPage">userId 1</a></li>
                                    <input type="hidden" id="bdIdx" value='${board.bdIdx}'/>
                                    <input type="text" id ="context">
                                    <input type="submit" value="Send Message" class="primary">
                                    <br>

                                    <div id="replies">
                                        <c:forEach items="${replies}" var="replies">
                                        <tr>
                                            <p>${replies.context}</p>
                                        </tr>
                                        </c:forEach>

                                    </div>

                                </ul>
                            </form>
                        </div>


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