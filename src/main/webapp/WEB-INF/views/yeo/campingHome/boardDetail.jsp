<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
<!-- head 설정 -->
<body class="campingHome">
<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&family=Open+Sans&display=swap');
#main-text {
    width: 100%;
    height: 6.25em;
    border: none;
    resize: none;
}

#form-commentInfo{
    width: 100%;
}

#comment-count{
    margin-bottom: 10px; 
}

#comment-input{
    width: 50%;
    height: 3.3em;
}

#submit{
    background-color: rgb(0, 128,255);
    width: 5.5em;
    height: 3.3em;;
    font-size: 15px;
    font-weight: bold;
    color: aliceblue;
}

#voteUp, #voteDown{
    width: 3.5em;
    height: 1.9em;
    background-color: aqua;    
}

#comments{
    margin-top: 10px;
}

.eachComment{   
    width :50%; 
    margin: 10px;  
    padding: 0.5em; 
    border-bottom: 1px solid #c1bcba;
}

.eachComment .name{
    font-size: 1.5em;
    font-weight: bold;
    margin-bottom: 0.3em;
    display: flex;
    justify-content: space-between;
}

.eachComment .inputValue{
    font-size: 1.2em;
    font-style: italic;    
}

.eachComment .time{
    font-size: 0.7em;
    color: #c1bcba;
    font-style: oblique;
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    
}

.eachComment .voteDiv{
    display: flex;
    justify-content: flex-end;
}

.eachComment .deleteComment{
    background-color: red;
    color: aliceblue;
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
					<div class="row">
					<div class="title" style="text-align:left font-family:'Nanum Myeongjo', serif;">
					<!--<h1>${board.title}</h1>  -->
					<h1>게시글 제목</h1>
					</div>
					</div>
                </header>

                    <div class="row">
                        <div class="col-6 col-12-large">
                            <img src="https://s3.amazonaws.com/imagescloud/images/medias/annexes/annexe-camping-2022.jpg"
                            width="600px" height="400px" alt="캠핑의집">
                        </div>
                        <div class="col-6 col-12-large" border="1px solid black">
                       <div class="image2"> 
                       <img src = "http://static1.squarespace.com/static/5584e79fe4b031eca5211e62/t/55b65a2be4b024165dbb8078/1438014006470/?format=1500w"
                       width="600px" height="400px" alt="캠핑의집" position="relative">
                       </div>
					</div>
                            <div class="hashtag-text">
                                    <input type="text" name="text" value='${board.hashtag}' readonly
                                    placeholder="해시태그 입력창"
                                    style="width:1270px;
                                    
                                    font-color: blue;">
                            </div>
							<br>
							<br>
                            <div id="main-text">
                                <input type="text" name="text" value='${board.text}' readonly
                                placeholder="텍스트 입력창"
                                style="height:600px; width:1270px;">
                            </div>
                        
                         <div id="form-commentInfo">
                        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                        <br>
        				<div id="comment-count" style="font-family:'Nanum Myeongjo', serif;">댓글 <span id="count">0</span></div>
       					<input id="comment-input" placeholder="댓글을 입력해 주세요."
       					style="width:1150px;
       					outline: none; border: 1px solid #d3d3d3; border-radius:8px;">
        				<button class="button" style="font-family:'Nanum Myeongjo', serif;
        				background-color:#0099ff; outline: none;
        				box-shadow: none; height : 55px;">
							<span class="submit" style="font-color:black;">확인</span>
							<span class="loading"><i class="fa fa-refresh"></i></span>
							<span class="check"><i class="fa fa-check"></i></span>
						</button>
    					</div>
    					<div id=comments>
    					 <ul style="list-style:none; padding-left:0; margin-left:0;">
    					   <br>
    					   <div class="row">
    					   <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" style="width:65px; height:40px;">
                           <li><a href="/campingHome/userPage">userId 1</a></li>   					   
    					   </div>
    					   <li>댓글을 작성해 주세요</li> 
                           <br>
    					   <div class="row">
    					   <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" style="width:65px; height:40px;">
                           <li><a href="/campingHome/userPage">userId 2</a></li>   					   
    					   </div>
    					   <li>댓글을 작성해 주세요</li> 
                           <br>
                           <div class="row">
    					   <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" style="width:65px; height:40px;">
                           <li><a href="/campingHome/userPage">userId 3</a></li>   					   
    					   </div>
    					   <li>댓글을 작성해 주세요</li> 
                           <br>              
                                    <div>
                                        <c:forEach items="${replies}" var="replies">
                                        <tr>
                                            <input type="text" name="reply" value='${replies.context}' readonly>
                                            <br>
                                        </tr>

                                        </c:forEach>
                                    </div>
                                </ul>

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