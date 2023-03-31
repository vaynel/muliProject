<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>

<!-- head 설정 -->
<body class="is-preload">

   <!-- Wrapper -->
   <div id="wrapper">

      <!-- Main -->
      <div id="main">
         <div class="inner">

            <%@ include file="/WEB-INF/views/include/header.jsp"%>

            <!-- Content -->
            <section>
               <header class="main">
                  <h1>${boardList.title}<a type="button" id="btnLike">♡</a></h1>
                           <li>작성일 : ${boardList.createDate}</li>
                           <li><a href="/comewithme/comeWithMeList">목록으로 돌아가기</a></li>
                  <hr>
                
               </header>
               
                  <div class="row">
                        <div class="col-6 col-12-large">
                            <c:forEach items="${files}" var="files">
                                <tr>
                                    <img src="/comewithme/images/${files.groupName}/${files.savePath}${files.renameFileName}" width="400px" height="300px" alt="같이갈래">
                                    <br>
                                </tr>

                            </c:forEach>

                            <br>

                        </div>
                        </div>
              
                        <tr>
                           <td>인원수 : ${boardList.numOfPerson}</td><br>
                           <td>장소 : ${boardList.place}</td><br>
                           <td>모집 연령층 : ${boardList.ageAverage}</td><br>
                           <td>캠핑 방식 : ${boardList.campingWay}</td><br>
                           <td>좋아요 갯수 : ${boardList.likeCount}</td><br>
                           <br>
                        </tr>
                        <pre>${boardList.content}</pre></td><br>
            </section>
               
            <form action="/comewithme/remove" method="get">
            <input  type="hidden" value="${boardList.bdIdx}" name="bdIdx">
            <button id="btnDel"><span>삭제</span></button>	
            </form>
            
            <form action="/comewithme/modify" method="get">
          	<input type="hidden" value="${boardList.bdIdx}" name="bdIdx"/> 
          	<button id="btnModify"><span>수정</span></button>
          </form>	
  
         </div>
      </div>
      
      
      <!-- Sidebar -->
      <%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

   </div>

   <!-- Scripts -->
   <%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

</body>
</html>