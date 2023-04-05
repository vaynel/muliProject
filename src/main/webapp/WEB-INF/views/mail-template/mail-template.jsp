<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.trillon.camp.common.code.Code" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width"/>
    
    <meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
	<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
	<link rel="stylesheet" href="${context}/resources/assets/css/mail/mail_css.css">
    

</head>
<body>
<style>

* { margin: 0; padding: 0; font-size: 100%;  line-height: 1.65; }

img { max-width: 100%; margin: 0 auto; display: block; }

body, .body-wrap { width: 100% !important; height: 100%; background: #f8f8f8; }

a { color: #71bc37; text-decoration: none; }

a:hover { text-decoration: underline; }

.text-center { text-align: center; }

.text-right { text-align: right; }

.text-left { text-align: left; }

.button { display: inline-block; color: white; background: #71bc37; border: solid #71bc37; border-width: 10px 20px 8px; font-weight: bold; border-radius: 4px; }

.button:hover { text-decoration: none; }

h1, h2, h3, h4, h5, h6 { margin-bottom: 20px; line-height: 1.25; }

h1 { font-size: 32px; }

h2 { font-size: 28px; }

h3 { font-size: 24px; }

h4 { font-size: 20px; }

h5 { font-size: 16px; }

p, ul, ol { font-size: 16px; font-weight: normal; margin-bottom: 20px; }

.container { display: block !important; clear: both !important; margin: 0 auto !important; max-width: 580px !important; }

.container table { width: 100% !important; border-collapse: collapse; }

.container .masthead { padding: 80px 0; background: #71bc37; color: white; }

.container .masthead h1 { margin: 0 auto !important; max-width: 90%; text-transform: uppercase; }

.container .content { background: white; padding: 30px 35px; }

.container .content.footer { background: none; }

.container .content.footer p { margin-bottom: 0; color: #888; text-align: center; font-size: 14px; }

.container .content.footer a { color: #888; text-decoration: none; font-weight: bold; }

.container .content.footer a:hover { text-decoration: underline; }
</style>




<table class="body-wrap">
    <tr>
        <td class="container">

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
						<form action="<%= Code.DOMAIN %>/group/insertNewMemberToGroup" method="get">
							
                        <table>
                            <tr>
                                <td align="center">
                                    <p>
                                    	<input  type="hidden" name="userId" value="${data.userId}"/>
                                    	<input  type="hidden" name="groupIdx" value="${data.groupIdx}"/>
                                    <%-- 	<input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
                                    	<button type="submit" class="button">멤버 추가 승인</button> 
                              
                                        <a href="#" class="button">멤버 추가 거절</a>
                                    </p>
                                </td>
                            </tr>
                        </table>
						</form>
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
                        <p>Sent by <a href="#">Trillion</a></p>
                        <p><a href="mailto:">trillion@multicampus.com</a></p>
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>
</body>
</html>