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

                    <div class="row">


                        <div class="col-6 col-12-large">
                            <div class="container">
                                <div class ="album">

                                    <div class="images">
                                        <c:forEach items="${files}" var="files">
                                                <img src="/campingHome/images/${files.gnIdx}/${files.renameFileName}" alt="캠핑의집">
                                        </c:forEach>
                                    </div>

                                </div>
                                <button class="previous">이전</button>
                                <button class="next">다음</button>

                            </div>

                        </div>



                        <div class="col-6 col-12-large" border="1px solid black">

                            <c:forEach items="${item}" var="t">
                                <div>
                                    <p>제품 상세페이지</p>
                                    <a href = ${t.link}>${t.itemName}</a>
                                    <image src="${t.image}" alt="제품상세사진"/>
                                </div>
                            </c:forEach>

                            <div>
                                <p>
                                    해시태그 작성란입니다.
                                    <input type="text" name="hashtag" value='${board.hashtag}' readonly>
                                </p>
                            </div>

                            <div>
                                <p>텍스트 작성란 입니다.</p>
                                <input type="text" name="text" value='${board.text}' readonly>
                            </div>



                        </div>

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