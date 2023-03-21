<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!-- head 설정 -->
<body class="campingHome">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <%@ include file="/WEB-INF/views/include/header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
                    <h1>캠핑의 집</h1>
                </header>

                <div>



                    <c:forEach items="${boards}" var="boards">
                        <div class="col-6 col-12-large">
                            <ul>
                                <tr>
                                    <td><a href="/campingHome/board/${boards.bdIdx}" class="button primary small">${boards.bdIdx}</a></td>
                                    <td>${boards.title}</td>
                                    <td>${boards.text}</td>
                                    <td>${boards.hashtag}</td>
                                    <br>
                                 </tr>

                                <div class="image object">
                                    <a href="/campingHome/boardDetail">
                                        <img src="/resources/images/campingHome01.png"  width="400px" height="300px" alt="캠핑의집" >
                                    </a>
                                </div>
                                <ul class = "actions">
                                    <li>
                                        <a class="button primary">Like</a>
                                    </li>
                                    <li>
                                        <a class="button primary">Comment</a>
                                    </li>
                                    <li>
                                        <a class="button primary">Save</a>
                                    </li>
                                </ul>
                            </ul>

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