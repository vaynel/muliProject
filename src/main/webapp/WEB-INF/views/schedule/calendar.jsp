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

<meta name="_csrf" th:content="${_csrf.token}">
<meta name="_csrf_header" th:content="${_csrf.headerName}">

<script>

$.ajax({
	url: "get.do",
	type: 'GET',
	success: function(res){
		var list = res;
		console.log(list);
		
		var calendarEl = document.getElementById('calendar');
		
		var events = list.map(function(item) {
			
			if(item.madeByGroup){
				if(item.startTime!="00:00:00"){	
					return {
					title : item.title,
					start : item.date + "T" + item.startTime,
					end	  : item.dateEnd + "T24:00:00",
					backgroundColor : "rgba(44, 62, 80, 50)",
					borderColor : "rgba(44, 62, 80, 50)",
					textColor : "#ffffff"
				}}
				
				else if(item.date==item.dateEnd){
				return {
					title : item.title,
					start : item.date + "T" + item.startTime,
					end	  : item.dateEnd + "T24:00:00",
					allDay:true,
					backgroundColor : "rgba(44, 62, 80, 50)",
					borderColor : "rgba(44, 62, 80, 50)",
					textColor : "#ffffff"
				}
				
			}
				else{
					return {
						title : item.title,
						start : item.date ,
						end	  : item.dateEnd+"T24:00:00",
						allDay:true,
						backgroundColor : "rgba(44, 62, 80, 50)",
						borderColor : "rgba(44, 62, 80, 50)",
						textColor : "#ffffff"
						
					}	
					
				}	
			}
			else{
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
				if(confirm("일정 '"+info.event.title +"' 을 삭제하시겠습니까?")){
					console.dir(info.event.title);
					console.dir(info.event.startStr);
					//
					
					
					$.ajax({
						url:"deleteTodo",
						type:'get',
						data:{
							title : info.event.title,
							date : info.event.startStr
							
						}
					
						
						
					});
					info.event.remove();
				
					
					
					
				}
				
			}  
			  
		});
		calendar.render();
	},
});
      
      
   
      
</script>

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

							<%@ include file="/WEB-INF/views/include/header.jsp" %>

					<!-- Content -->
					
									
					<div id='btnBox'>
					<input type="button" value="일정 추가"
						onclick="location.href='/schedule/schedulePopUp'">
					</div>
					<div id='calendar'></div>
								
							
									
					

					</div>
					</div>

				<!-- Sidebar -->
					<%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

			</div>
		<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>
	
</body>
</html>
