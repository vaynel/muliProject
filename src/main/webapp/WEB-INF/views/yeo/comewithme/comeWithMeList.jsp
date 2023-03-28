<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!-- head 설정 -->
<body class="is-preload">
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
}

/* 페이지네이션 스타일 */
.pagination {
  display: inline-block;
}

.pagination li {
  display: inline;
  margin: 0 5px;
}

.pagination li a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  border: 1px solid #ddd;
}

.pagination li.active a {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination li a:hover:not(.active) {
  background-color: #ddd;
}

h1 {
  font-size: 36px;
  margin-bottom: 15px;
}


button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 12px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}
</style>

   <!-- Wrapper -->
   <div id="wrapper">

      <!-- Main -->
      <div id="main">
         <div class="inner">

            <%@ include file="/WEB-INF/views/include/header.jsp"%>

            <!-- Content -->
            <section>
               <header class="main">
                  <h1>같이갈래 목록</h1>
                  <hr>
                  <li><a href="/comewithme/comeWithMeMatch">매칭하러가기</a></li>
                  <li><a href="/comewithme/comeWithMeCreateBoard">게시글 작성하러 가기</a></li>
               </header>
               <tr>
                  <th style="width: 10%; height: 20%;"><span>| 번호 |</span></th>
                  <th style="width: 70%;"><span> 제목 |</span></th>
                  <th style="width: 10%;"><span> 내용 |</span></th>
                  <th style="width: 10%;"><span> 좋아요 |</span></th>
                  <th style="width: 10%;"><span> 등록일 |</span></th>
                  <th style="width: 10%;"><span> 모집 인원 수 |</span></th>
                  <br>
               </tr>
               <c:forEach items="${boardList}" var="boardList">
                        <tr>
                           <td>${boardList.bdIdx}</td>
                           <td><a href="${context}/comewithme/detail?bdIdx=${boardList.bdIdx}">${boardList.title}</a></td>
                           <td>${boardList.content}</td>
                           <td>${boardList.likeCount}</td>
                           <td>${boardList.createDate}</td>
                           <td>${boardList.numOfPerson}</td>
                           <br>
                        </tr>
               
               </c:forEach><br>
               
               <div class="row mt-3">
      <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
         
          <li class="page-item">
            <a class="page-link" href="/comewithme/comeWithMeList?page=${paging.prevPage}">Previous</a>
          </li>
         
          <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
             <li class="page-item"><a class="page-link" href="/comewithme/comeWithMeList?page=${page}">${page}</a></li>
          </c:forEach>
        
          <li class="page-item">
            <a class="page-link" href="/comewithme/comeWithMeList?page=${paging.nextPage}">Next</a>
          </li>
          
        </ul>
      </nav>
   </div>
            </section>

         </div>
      </div>
      
      
      <!-- Sidebar -->
      <%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

   </div>

   <!-- Scripts -->
   <%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

</body>
</html>