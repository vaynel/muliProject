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
  text-align : center;
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
                  <h1>캠핑의 집 - 목록</h1>
                  <hr>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     
                     
                     <a href="/comewithme/comeWithMeMatch">
                                    <img id="match" src="https://cdn-icons-png.flaticon.com/512/33/33308.png" height="70px" width="70px">
                                    &nbsp;&nbsp;&nbsp;
                     </a>
                     <a href="/comewithme/comeWithMeCreateBoard">
                                    <img id="write" src="https://cdn-icons-png.flaticon.com/512/1357/1357748.png" height="70px" width="70px">
                                    &nbsp;&nbsp;&nbsp;
                     </a>
               </header>
               
                                         
               
               
<br>
               <div class="row">
                <div>
                <h1>1. 제목</h1>
                                <a href="/campingHome/boardDetail">
                                    <img src="https://a0.muscache.com/im/pictures/6aab9a34-f079-4b78-ac19-4ab72f5426d5.jpg?im_w=1920" 
                                    width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class="actions">
                                <li>
                                <a href="#">
                                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <img id="like" src="https://cdn-icons-png.flaticon.com/512/739/739231.png" height="50px" width="50px">
                                	&nbsp;&nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="comment" src="https://cdn-icons-png.flaticon.com/512/13/13673.png" height="50px" width="50px">
                                    &nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="save" src="https://cdn-icons-png.flaticon.com/512/102/102279.png" height="50px" width="50px">
                                </a>
                                </li>
                                </ul>    
                            </div>
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		<div>
                     		<h1>2. 제목</h1>
                                <a href="/campingHome/boardDetail">
                                    <img src="https://images.pexels.com/photos/1539225/pexels-photo-1539225.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" 
                                    width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class="actions">
                                <li>
                                <a href="#">
                                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <img id="like" src="https://cdn-icons-png.flaticon.com/512/739/739231.png" height="50px" width="50px">
                                	&nbsp;&nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="comment" src="https://cdn-icons-png.flaticon.com/512/13/13673.png" height="50px" width="50px">
                                    &nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="save" src="https://cdn-icons-png.flaticon.com/512/102/102279.png" height="50px" width="50px">
                                </a>
                                </li>
                                </ul>    
                            </div>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div>
                            <h1>3. 제목</h1>
                                <a href="/campingHome/boardDetail">
                                    <img src="https://images.pexels.com/photos/756780/pexels-photo-756780.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" 
                                    width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class="actions">
                                <li>
                                <a href="#">
                                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <img id="like" src="https://cdn-icons-png.flaticon.com/512/739/739231.png" height="50px" width="50px">
                                	&nbsp;&nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="comment" src="https://cdn-icons-png.flaticon.com/512/13/13673.png" height="50px" width="50px">
                                    &nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="save" src="https://cdn-icons-png.flaticon.com/512/102/102279.png" height="50px" width="50px">
                                </a>
                                </li>
                                </ul>    
                            </div>
               </div>
               <br>
               <br>
               <br>
                              <div class="row">
                <div>
                <h1>4. 제목</h1>
                                <a href="/campingHome/boardDetail">
                                    <img src="https://images.pexels.com/photos/2376997/pexels-photo-2376997.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" 
                                    width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class="actions">
                                <li>
                                <a href="#">
                                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <img id="like" src="https://cdn-icons-png.flaticon.com/512/739/739231.png" height="50px" width="50px">
                                	&nbsp;&nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="comment" src="https://cdn-icons-png.flaticon.com/512/13/13673.png" height="50px" width="50px">
                                    &nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="save" src="https://cdn-icons-png.flaticon.com/512/102/102279.png" height="50px" width="50px">
                                </a>
                                </li>
                                </ul>    
                            </div>
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		<div>
                     		<h1>5. 제목</h1>
                                <a href="/campingHome/boardDetail">
                                    <img src="https://images.pexels.com/photos/6271635/pexels-photo-6271635.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" 
                                    width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class="actions">
                                <li>
                                <a href="#">
                                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <img id="like" src="https://cdn-icons-png.flaticon.com/512/739/739231.png" height="50px" width="50px">
                                	&nbsp;&nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="comment" src="https://cdn-icons-png.flaticon.com/512/13/13673.png" height="50px" width="50px">
                                    &nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="save" src="https://cdn-icons-png.flaticon.com/512/102/102279.png" height="50px" width="50px">
                                </a>
                                </li>
                                </ul>    
                            </div>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div>
                            <h1>6. 제목</h1>
                                <a href="/campingHome/boardDetail">
                                    <img src="https://images.pexels.com/photos/2126578/pexels-photo-2126578.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" 
                                    width="300px" height="300px" alt="캠핑의집" >
                                </a>
                                <ul class="actions">
                                <li>
                                <a href="#">
                                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <img id="like" src="https://cdn-icons-png.flaticon.com/512/739/739231.png" height="50px" width="50px">
                                	&nbsp;&nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="comment" src="https://cdn-icons-png.flaticon.com/512/13/13673.png" height="50px" width="50px">
                                    &nbsp;&nbsp;&nbsp;
                                </a>
                                </li>
                                <li>
                                <a href="#">
                                    <img id="save" src="https://cdn-icons-png.flaticon.com/512/102/102279.png" height="50px" width="50px">
                                </a>
                                </li>
                                </ul>    
                            </div>
               </div>			
              
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
               
               <div class="row mt-3" id="navigation">
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