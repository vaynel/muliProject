<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:set var="context" value="${pageContext.request.contextPath}"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no" />
		<c:set var="context" value="${pageContext.request.contextPath}"/>
		
		
		
		<script src="${context}/resources/assets/js/plugin/webfont/webfont.min.js"></script>
		
		<script>
			WebFont.load({
				google: {"families":["Lato:300,400,700,900"]},
				custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: ['/resources/assets/css/fonts.min.css']},
				active: function() {
					sessionStorage.fonts = true;
				}
			});
		</script>
	
		
		<!-- dashboard css  -->
		<link rel="stylesheet" href="${context}/resources/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="${context}/resources/assets/css/atlantis.min.css">
		
		<!--용구형님 css  -->
		<link rel="stylesheet" href="${context}/resources/assets/css/main.css" />
		
		<script src="${context}/resources/assets/js/common.js"></script>
		
		<%-- <link href="${context}/resources/assets/styles.css" rel="stylesheet" /> --%>
		<%-- <link href="${context}/resource/assets/prism.css" rel="stylesheet" /> --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
</head>

