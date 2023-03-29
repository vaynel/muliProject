<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!-- head 설정 -->
<body class="is-preload">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <%@ include file="/WEB-INF/views/include/header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
                    <h1> My PAGE</h1>
                    <div class="actions small">
                        <a href="/campingHome/board/new" class="button primary small">게시글 작성</a>
                    </div>
                </header>

                <div class="row">
                    <div class="col-4 col-12-large">
                        프로필 사진
                        유저 아이디 등등
                    </div>

                    <div class="col-8 col-12-large">
                        <div class="row">
                            <div class="col-6 col-12-large">
                                <a href="/campingHome/boardDetail">
                                    <img src="/resources/images/campingHome01.png"  width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class = "actions">
                                    <li><a class="button primary">Like</a></li>
                                    <li><a class="button primary">Comment</a></li>
                                    <li><a class="button primary">Save</a></li>
                                </ul>
                            </div>
                            <div class="col-6 col-12-large">
                                <a href="/campingHome/boardDetail">
                                    <img src="/resources/images/campingHome01.png"  width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class = "actions">
                                    <li><a class="button primary">Like</a></li>
                                    <li><a class="button primary">Comment</a></li>
                                    <li><a class="button primary">Save</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6 col-12-large">
                                <a href="/campingHome/boardDetail">
                                    <img src="/resources/images/campingHome01.png"  width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class = "actions">
                                    <li><a class="button primary">Like</a></li>
                                    <li><a class="button primary">Comment</a></li>
                                    <li><a class="button primary">Save</a></li>
                                </ul>
                            </div>
                            <div class="col-6 col-12-large">
                                <a href="/campingHome/boardDetail">
                                    <img src="/resources/images/campingHome01.png"  width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class = "actions">
                                    <li><a class="button primary">Like</a></li>
                                    <li><a class="button primary">Comment</a></li>
                                    <li><a class="button primary">Save</a></li>
                                </ul>
                            </div>
                        </div>

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

</body>
</html>

