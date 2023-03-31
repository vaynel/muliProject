<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
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
                <form action="${context}/campingHome/board/new" id="form" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    
                    <div calss="row gtr-uniform">
                        <input type="text" name="title" value="제목을 입력하세요."
                        style="width:1250px;
                        margin-left:auto;">
						<br>
                    <div class="col-12">
                        <input type="text" name="text" value="본문을 입력하세요." rows="20" cols="100"
                        style="vertical-align:top; width:1250px; height : 500px;
                        margin-left:auto;"
                        />
                    </div>
						<br>
                        <div class="col-12">
                        <input type="text" name="hashtag" value="해시태그를 입력하세요" rows="6"
                        style="width:1250px; margin-left:auto;"/>
                        </div>
						<br>
                        <div class="col-12">
                            <strong>사진 등록</strong>
                            <input type="file" name="file" multiple/>
                        </div>
					<br>
                    <div class="col-12">
                        <ul class="actions">
                            <li>
                                <input type="submit" value="전송" class="primary">
                            </li>
                            <li>
                                <input type="reset" value="모두 지움">
                            </li>
                        </ul>
                    </div>

                </div>
                </form>

                <form >

                </form>

            </section>

        </div>
    </div>

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

</div>

<!-- Scripts -->
<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>

<!--<script src="${context}/resources/assets/js/campingHome/boardForm.js"></script>-->

</body>
</html>