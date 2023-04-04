<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.trillon.camp.common.code.Code" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width"/>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="context" value="${pageContext.request.contextPath}"/>
    <!-- For development, pass document through inliner -->
    <link rel="stylesheet" href="${context}/resources/assets/css/mail/mail_css.css">

    <style type="text/css">

    /* Your custom styles go here */

    </style>
</head>
<body>
<table class="body-wrap">
    <tr>
        <td class="container">

            <!-- Message start -->
            <table>
                <tr>
                    <td align="center" class="masthead">

                        <h1>새로운 멤버</h1>

                    </td>
                </tr>
                <tr>
                    <td class="content">

                        <h2> 멤버 추가 신청</h2>

                        <p>
							${data.userId}님이 ${data.group.groupName}에 멤버 신청을 보냈습니다. 
						</p>

                        <table>
                            <tr>
                                <td align="center">
                                    <p>
                                        <a href="<%= Code.DOMAIN %>/group/insertNewMemberToGroup?userId=${data.userId}&groupIdx=${data.groupIdx}" class="button">멤버 추가 승인</a>
                                        <a href="#" class="button">멤버 추가 거절</a>
                                    </p>
                                </td>
                            </tr>
                        </table>

                        <p> 유저 페이지 : <a href="http://baconipsum.com">USER</a>.</p>

                    </td>
                </tr>
            </table>

        </td>
    </tr>
    <tr>
        <td class="container">

            <!-- Message start -->
            <table>
                <tr>
                    <td class="content footer" align="center">
                        <p>Sent by <a href="#">Company Name</a>, 1234 Yellow Brick Road, OZ, 99999</p>
                        <p><a href="mailto:">hello@company.com</a> | <a href="#">Unsubscribe</a></p>
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>
</body>
</html>