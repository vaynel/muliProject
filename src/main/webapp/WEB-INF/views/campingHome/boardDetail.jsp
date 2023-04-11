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
                    <h2 style="font-family: 'Stylish', sans-serif;
						text-align: center; line-height: 0.1;">Camping Home</h2>

                    <div style="display: inline-block;">
                        <form action="/campingHome/board/modify" method="get">
                            <input type="hidden" value="${board.bdIdx}" name="bdIdx"/>
                            <button id="btnModify" class="rightbutton" style="text-align: left">
                                <img src="https://cdn-icons-png.flaticon.com/512/6996/6996496.png" style="width:50px; height:50px; display: inline-block;">
                            </button>
                        </form>
                    </div>

                    <div style="display: inline-block;">
                        <form action="/campingHome/board/remove" method="get">
                            <input type="hidden" value="${board.bdIdx}" name="bdIdx">
                            <button id="btnDel" class="leftbutton">
                                <img src="https://cdn-icons-png.flaticon.com/512/6996/6996573.png" style="width:50px; height:50px;">
                            </button>
                        </form>
                    </div>
                </header>

                        <div class="container">
                            <br>
                            <br>
                            <div class="row" id="row-1" >
                                <div class="col-xs-6 col-sm-6"  id="left-1" style="height:430px; text-align:center;">

                                    <div class="con">
                                        <div class="album">

                                            <div class = "images" id="image">
                                                <c:forEach items="${files}" var="files">
                                                        <img src="/campingHome/images/${files.gnIdx}/${files.renameFileName}" alt="캠핑의집">
                                                </c:forEach>
                                            </div>

                                        </div>

                                        <img class="previous" src="https://cdn-icons-png.flaticon.com/512/2989/2989985.png" style="width:50px; height:50px; z-index:100;
                                position:absolute; top:190px; right:460px;"/>
                                        <img class="next" src="https://cdn-icons-png.flaticon.com/512/2989/2989988.png" style="width:50px; height:50px; z-index:100;
                                position:absolute; top:190px; right:0px;"/>

                                    </div>

                                </div>

                            <div class="col-xs-6 col-sm-6" id="right-1" style="height:430px;">
                                <div class="row">
                                    <h3 style="font-family: 'Stylish', sans-serif;
						text-align: left;">${board.title}</h3>
                                </div>

                                <div class="row">

                                    <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png"
                                         style="height:30px; width:55px;">
                                    <p style="font-family: 'Stylish', sans-serif;
						padding:0px 0px 0px 10px;">서수진 · 지리산 대경오토캠핑장</p>
                                </div>
                                <div class="row" style="width:500px; position:relative; left:26px;margin-bottom: 10px " >

                                        <c:forEach items="${item}" var="t">
                                            <a href = ${t.link}>
                                                <image src="${t.image}" style="height:100px; width:100px;
                    object-fit: cover; object-position: top; border-radius: 50%;
                    position:relative;
                    margin: 10px 20px 0 20px; float: left" alt="제품상세사진"/>
                                            </a>
                                        </c:forEach>

                                </div> <!-- row-3 끝 -->
                                <div class="row" id="row-2">
                                    <div class="col-12" id="text-2" style="height:340px;">
                                        <br>
                                        <pre type="textarea" name="text" style="color:black; font-family: 'Stylish', sans-serif; font-size: large;">${board.text}</pre>
                                    </div>
                                </div> <!-- row-2 끝 -->
                                <!-- 제품 상세화면 나오면 좋을듯 -->

                                </div>
                            </div>


                            <!-- 본문 -->





                        <div>
                            <form id="reply">
                                <h3>댓글</h3>
                                <ul>
                                    <li><a href="/campingHome/userPage">userId 1</a></li>
                                    <input type="hidden" id="bdIdx" value='${board.bdIdx}'/>
                                    <input type="text" id ="context">
                                    <input type="submit" value="Send" class="primary" style="width: 100px">
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