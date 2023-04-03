<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
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
                    <h1>${board.title}</h1>
                </header>



                    <div class="row">
                        <div class="col-6 col-12-large">
                            <c:forEach items="${files}" var="files">
                                <tr>
                                    <img src="/campingHome/images/${files.gnIdx}/${files.renameFileName}" width="400px" height="300px" alt="캠핑의집">
                                    <br>
                                </tr>

                            </c:forEach>

                            <br>

                        </div>
                        <div class="col-6 col-12-large" border="1px solid black">


                            <div>
                                <p>
                                    해시태그 작성란입니다.
                                    <input type="text" name="text" value='${board.hashtag}' readonly>
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
                                    <input type="hidden" id="bdIdx" value='${board.bdIdx}'></input>
                                    <input type="text" id ="context">
                                    <input type="submit" value="Send Message" class="primary">
                                    <li>댓글 1 댓글을 작성해 주세요</li>
                                    <br>
                                    <li><a href="/campingHome/userPage">userId 2</a></li>
                                    <li>댓글 2 댓글을 작성해 주세요</li>
                                    <br>
                                    <div>
                                        <c:forEach items="${replies}" var="replies">
                                        <tr>
                                            <input type="text" name="reply" value='${replies.context}' readonly>
                                            <br>
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


</body>
</html>