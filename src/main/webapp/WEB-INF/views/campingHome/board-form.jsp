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
                    <h1>게시글 작성</h1>
                </header>

                <!-- form -->
                <form method ="post" action="/campingHome/boardDetail">

                <div calss="row gtr-uniform">
                    <div class="col-12">
                        <textarea name="board" placeholder="게시글 내용을 입력해주세요" rows="6"></textarea>
                    </div>

                    <div class="col-12">
                        <ul class="actions">
                            <li>
                                <input type="submit" value="Send Message" class="primary">
                            </li>
                            <li>
                                <input type="reset" value="Reset">
                            </li>
                        </ul>
                    </div>

                </div>
                </form>

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



