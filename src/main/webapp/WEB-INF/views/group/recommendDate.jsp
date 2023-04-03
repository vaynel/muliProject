<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- fullcalender -->
<link href='${pageContext.request.contextPath}/resources/fullcalendar/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar/lib/main.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="${context}/resources/assets/css/main.css" />

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>



<style>
	#btnBox{
	padding-top:3px;
	padding-bottom:5px;
	}
</style>

</head>
<body>
<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<input type="hidden" id="groupIdx"  name="groupIdx" value="${groupIdx}"/>
							<input type="hidden" id="roomId" name="roomId" value="${roomId}" />

							<%@ include file="/WEB-INF/views/include/header.jsp" %>

					<!-- Content -->
					
					<div id='calendar'></div>
							
						</div>
					</div>

				<!-- Sidebar -->
					<%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

			</div>
		<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>
<script type="text/javascript">

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$.ajax({
	url: "/group/get.do?groupIdx="+groupIdx.value,
	type: 'GET',
	success: function(res){
		var list = res;
		console.log(list);
		
		
		var calendarEl = document.getElementById('calendar');
		
		var events = list.map(function(item) {
			
			if(item.startTime!="00:00:00"){	
				return {
				title : item.title,
				start : item.date + "T" + item.startTime,
				end	  : item.dateEnd + "T24:00:00",
				backgroundColor : "rgba(222, 118, 119, 50)",
				borderColor : "rgba(222, 118, 119, 50)",
				textColor : "#ffffff"
			}}
			
			else if(item.date==item.dateEnd){
			return {
				title : item.title,
				start : item.date + "T" + item.startTime,
				end	  : item.dateEnd + "T24:00:00",
				allDay:true,
				backgroundColor : "rgba(222, 118, 119, 50)",
				borderColor : "rgba(222, 118, 119, 50)",
				textColor : "#ffffff"
			}
			
		}
			else{
				return {
					title : item.title,
					start : item.date ,
					end	  : item.dateEnd+"T24:00:00",
					allDay:true,
					backgroundColor : "rgba(222, 118, 119, 50)",
					borderColor : "rgba(222, 118, 119, 50)",
					textColor : "#ffffff"
					
				}	
				
			}
			
		});
		
		
	
		
		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar: {
		          left: 'prev,next today',
		          center: 'title',
		          right: 'dayGridMonth,timeGridWeek'
		        },
		        //locale: 'ko',
		        expandRows : true,
				fixedWeekCount : false,
			events : events,
			eventTimeFormat: { // like '14:30:00'
			    hour: '2-digit',
			    minute: '2-digit',
			    hour12: false
			  },
			eventClick : function(info){
				if(confirm("일정 '"+info.event.title +"' 로 하시겠습니까?")){
					console.dir(info.event.title);
					console.dir(info.event.startStr);
					console.dir(info.event.groupIdx);
					//
					
					
					$.ajax({
						url:"/group/addGroupTodo",
						type:'post',
						data:{
							groupIdx : groupIdx.value,
							title : info.event.title,
							date : info.event.startStr
							
						},
						beforeSend : function(xhr){
							xhr.setRequestHeader(header, token);
						},
						success : function(data) {
							if(data == true)alert("성공");
							
						}
					
						
						
					});
					info.event.remove();
					location.href = "http://localhost:8080/groupChat/chatRoom?roomId="+$('#roomId').val()+"&groupIdx="+$('#groupIdx').val();
				
					
					
					
				}
				
			}  
			  
		});
		calendar.render();
	},
});
      
      
   
      
</script>
	
</body>
</html>
