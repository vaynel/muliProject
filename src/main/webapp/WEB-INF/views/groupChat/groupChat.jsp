<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link rel="stylesheet"
	href="${context}/resources/assets/css/chat/chatRoom.css" />


</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<%@ include file="/WEB-INF/views/include/header.jsp"%>

				<section style="background-color: #eee;">
					<div class="container py-5">

						<div class="col-md-6 col-lg-7 col-xl-8">

							<ul class="list-unstyled">
								<li class="d-flex justify-content-between mb-4"><img
									src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
									alt="avatar"
									class="rounded-circle d-flex align-self-start me-3 shadow-1-strong"
									width="60">
									<div class="card">
										<div class="card-header d-flex justify-content-between p-3">
											<p class="fw-bold mb-0">Brad Pitt</p>
											<p class="text-muted small mb-0">
												<i class="far fa-clock"></i> 12 mins ago
											</p>
										</div>
										<div class="card-body">
											<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
												adipiscing elit, sed do eiusmod tempor incididunt ut labore
												et dolore magna aliqua.</p>
										</div>
									</div></li>
								<li class="d-flex justify-content-between mb-4">
									<div class="card w-100">
										<div class="card-header d-flex justify-content-between p-3">
											<p class="fw-bold mb-0">Lara Croft</p>
											<p class="text-muted small mb-0">
												<i class="far fa-clock"></i> 13 mins ago
											</p>
										</div>
										<div class="card-body">
											<p class="mb-0">Sed ut perspiciatis unde omnis iste natus
												error sit voluptatem accusantium doloremque laudantium.</p>
										</div>
									</div> <img
									src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-5.webp"
									alt="avatar"
									class="rounded-circle d-flex align-self-start ms-3 shadow-1-strong"
									width="60">
									</li>
								
								
							
								<li class="bg-white mb-3">
									<div class="form-outline">
										<textarea class="form-control" id="textAreaExample2" rows="4"></textarea>
										<label class="form-label" for="textAreaExample2"></label>
									</div>
								</li>
								<a class="button" href="/group/newGroupTodo?groupIdx=${groupIdx}">모임생성</a>
								 <a class="button" href="/group/recommendDate?groupIdx=${groupIdx}">날짜 추천</a>
								<button type="button" class="btn float-end">전송</button>
							</ul>

						</div>

					</div>
				</section>




			</div>
		</div>


		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	</div>
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>

</body>
</html>
