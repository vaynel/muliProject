<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
<style>
#wrapper {
  display: flex;
  flex-wrap: wrap;
}

/* Style for the main content */
#main {
  flex: 3;
  margin-right: 2em;
}

/* Style for the form inputs */
input[type="text"],
textarea,
select {
  width: 100%;
  padding: 0.5em;
  margin-bottom: 1em;
  border-radius: 3px;
  border: none;
  box-shadow: 0 2px 5px rgba(0,0,0,0.1);
  font-size: 1em;
  color: #555;
}

/* Style for the form labels */
li {
  margin-bottom: 0.5em;
  font-size: 1.2em;
}

/* Style for the submit button */
#btnClick {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 1em;
  border-radius: 12px;
  background-color: rgba(222, 118, 119, 50);
  color: #fff;
  font-size: 1.2em;
  border: none;
  cursor: pointer;
}

/* Style for the form error message */
#error-message {
  color: red;
  margin-bottom: 1em;
}

/* Style for the form success message */
#success-message {
  color: green;
  margin-bottom: 1em;
}

/* Style for the tags */
.tr_hashTag_area {
  margin-bottom: 2em;
}

.tag {
  display: inline-block;
  margin-right: 0.5em;
  background-color: #ccc;
  color: #fff;
  padding: 0.5em;
  border-radius: 3px;
  font-size: 0.8em;
}
</style>



<!-- head 설정 -->
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
			<style>
		@import url('https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Stylish&display=swap');



			</style>
				<%@ include file="/WEB-INF/views/include/header.jsp"%>
				<!-- Content -->
				<section>
					<header class="main">
						<h1 style="font-family: 'Stylish', sans-serif;
						text-align: center;">같이갈래</h1>
						<h2 style="font-family: 'Stylish', sans-serif;
						text-align: center; line-height: 0.1;">Come with me</h2>
					</header>
						<br>
						<div class="form-group">
								<input type="text" id="title" size="20" placeholder="제목을 입력하세요." style="width: 1200px;" />
						</div>
								<textarea name="content" placeholder="본문을 입력하세요."
								style="height:800px; position:absolute;"></textarea>
						<div class="tr_hashTag_area">
						<ul id="tag-list"></ul>

						<div class="form-group">
								<input type="text" id="tag" size="7" placeholder="해시태그를 등록해주세요." style="width: 300px;" />
						</div>
                          <br>
                          <button type="button" id="btnClick" class="button primary" style="color:white; width:100%">저장</button>
                          
					</div>
				</section>
			</div>
		</div>

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	</div>

	<!-- Scripts -->
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

	<script defer src="${context}/resources/assets/js/comeWithMe/createBoardJavaScript.js"></script>
</body>
</html>