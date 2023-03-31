<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!-- head 설정 -->
<body class="is-preload">
<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');

h1 {
		text-align : center;
		font-family: 'Nanum Myeongjo', serif;
				}
				
h4, h2 {
		font-family: 'Nanum Myeongjo', serif;
				}
				
#favorite-color {
		font-color : #047527;
}

.btn {
  background-color: #a9cce3;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 8px;
  
}

</style>
<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <%@ include file="/WEB-INF/views/include/header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
                    <h1>My PAGE</h1>
                    <br>
                    <div class="actions small">
                        <img="https://cdn-icons-png.flaticon.com/512/1357/1357697.png"
                        height:50px width:50px>
                        <a href="/campingHome/board/new"></a>
                    </div>
                </header>

                <div class="row" id="profile-corner">
                    <div class="col-4 col-12-large">
                        <img src="https://cdn-icons-png.flaticon.com/512/727/727399.png"
                        width="300px" height="300px" alt="프로필 사진" >
                    	<br>
                    	<br>
                    	<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	&nbsp;프로필 사진 변경</h4>
                    	<br>
                    	<h2>이름 : ${member.name}</h2>
                    	<h2>나이 : ${age}</h2>
                    	<h2>성별 : ${member.gender}</h2>
                    </div>                 

                    <div class="col-8 col-12-large">
                        <div class="row">
                            <div class="col-6 col-12-large">
                                <a href="/campingHome/boardDetail">
                                    <img src="/resources/images/campingHome01.png"  width="300px" height="300px" alt="캠핑의집" >
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
                            <div class="col-6 col-12-large">
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
                        </div>
								<h3 a href="#">
								<!-- 우측 정렬로 미세한 조절이 안되어서 그만... -->
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;
								See more...</h3>

						<div class="row">
						<!-- 매칭횟수 -->
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div class="matching_frequency"
                            	style="width : 237px;
                                height : 300px;
                                background-image : url(https://img.poipiku.com/user_img03/002382369/008527853_eFXxEwlrZ.png_640.jpg);">
                                <br>
                                <br>
                                <h2>&nbsp;&nbsp;&nbsp;&nbsp;매칭 횟수</h2>
                                <h1>2</h1>                                
                            </div>
                         <!-- 가장 많이 가 본 지역 -->
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div class="favorite"
                            	style="width : 237px;
                                height : 300px;                                
                                background-image : url(https://img.poipiku.com/user_img03/002382369/008527853_eFXxEwlrZ.png_640.jpg);">      
                            	<br>
                                <br>
                                <h2>좋아하는 장소</h2>
                                <h1 id="favorite-color">#산</h1>
                            </div>
                         <!-- 캠핑횟수 -->
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div class="camping_frequency"
                            	style="width : 237px;
                                height : 300px;
                                background-image : url(https://img.poipiku.com/user_img03/002382369/008527853_eFXxEwlrZ.png_640.jpg);">  
                            	<br>
                            	<br>
                            	<h2>&nbsp;&nbsp;&nbsp;&nbsp;캠핑 횟수</h2>
                            	<h1>7</h1>
                            </div>

                         <div class="row">
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div class="rectangle"
                            style="width:775px; height:500px;
                            background-color : #fff8dc;">
                         	<br>
                         	<br>
                         	<br>
                         	<h1>채팅 최근 답</h1>
                         	<h2>채팅이 없습니다.
                         	다른 사람과 적극적으로 교류해 보세요! </h2>
                         	<div id="btnOK" style="text-align:center;">
                         	<button class="btn" a href="#">확인</button>
                         	</div>
                            </div>









                        

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

</body>
</html>

