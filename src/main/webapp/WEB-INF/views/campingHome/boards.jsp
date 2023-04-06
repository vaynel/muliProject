<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!-- head 설정 -->
<body class="campingHome">

<style>
    @import url('https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Stylish&display=swap');


    #g1 {

    }

    #g2 {

    }

    .material-symbols-outlined {
        font-variation-settings:
                'FILL' 0,
                'wght' 400,
                'GRAD' 0,
                'opsz' 48
    }

</style>

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <%@ include file="/WEB-INF/views/include/header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
                    <h1 style="font-family: 'Stylish', sans-serif;
						text-align: center;">캠핑의 집</h1>
                    <h2 style="font-family: 'Stylish', sans-serif;
						text-align: center; line-height: 0.1;">Camping Home</h2>
                </header>
                <br>
                <br>
                <div class="row">

                    <c:forEach items="${boards}" var="boards">
                        <div class="col-xs-6 col-sm-4" style="
						height:600px;
						box-shadow: 10px 5px 5px gray;">
                            <!-- 게시글 사진-->
                            <br>
                            <a href="/campingHome/board/${boards.gnIdx}">
                            <img src="/campingHome/images/${boards.gnIdx}/${boards.renameFileName}"  width="400px" height="300px" alt="캠핑의집" href="/campingHome/board/${boards.gnIdx}" style="height:50%; width:100%;" >
                            </a>
                            <!--게시글 제목-->
                            <br>
                            <h2 style="font-family: 'Stylish', sans-serif;">${boards.title}</h2>

                            <br>
                            <h3 style="font-family: 'Stylish', sans-serif; line-height : 0.1;">서지윤</h3>
                            <p style="color:blue;">${boards.text}</p>

                            <div class="line" style="background-color:black;
							height:2px; width:100%;
							line-height:0.1;">
                            <br>
                            </div>

                            <div id="icon" style="text-align: right;
							margin : 2px 1em 0 auto;">
                                <!-- 하트 -->
                                <img src="https://cdn-icons-png.flaticon.com/512/2961/2961957.png" style="height:30px; width:30px;
							margin: 0 1em 0 0;">
                                <!-- 책갈피 -->
                                <img src="https://cdn-icons-png.flaticon.com/512/5948/5948594.png" style="height:30px; width:30px;
							margin: 0 1em 0 0;">
                                <!-- 엄지 -->
                                <img src="https://cdn-icons-png.flaticon.com/512/456/456257.png" style="height:30px; width:30px;
							">
                            </div>
                        </div>
                    </c:forEach>



                </div>

                <div class="row mt-3">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">

                            <li class="page-item">
                                <a class="page-link" href="/campingHome/boards?page=${paging.prevPage}">Previous</a>
                            </li>

                            <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
                                <li class="page-item"><a class="page-link" href="/campingHome/boards?page=${page}">${page}</a></li>
                            </c:forEach>

                            <li class="page-item">
                                <a class="page-link" href="/campingHome/boards?page=${paging.nextPage}">Next</a>
                            </li>

                        </ul>
                    </nav>
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