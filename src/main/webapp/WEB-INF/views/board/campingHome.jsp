<%--
  Created by IntelliJ IDEA.
  User: 우리집
  Date: 2023-03-06
  Time: 오후 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${context}/resources/assets/css/main.css" />
</head>
<body>
    <a>캠핑의 집</a>
    <!-- main-->
    <div class="image object">
        <a>대체 이미지</a>
        <img src="/resources/images/campingHome01.png" alt="캠핑의집" >
    </div>
</body>
</html>
