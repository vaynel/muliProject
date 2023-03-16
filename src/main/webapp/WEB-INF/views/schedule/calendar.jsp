<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- fullcalender -->
<link href='${pageContext.request.contextPath}/resources/fullcalendar/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar/lib/main.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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
			
			if(item.startTime!="00:00:00"){	
				return {
				title : item.title,
				start : item.date + "T" + item.startTime,
				end	  : item.dateEnd + "T24:00:00"
			}}
			
			else if(item.date==item.dateEnd){
			return {
				title : item.title,
				start : item.date + "T" + item.startTime,
				end	  : item.dateEnd + "T24:00:00",
				allDay:true
			}
			
		}
			else{
				return {
					title : item.title,
					start : item.date ,
					end	  : item.dateEnd+"T24:00:00",
					allDay:true
					
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



</head>
<body>

	<input type="button" value="일정 추가" onclick="location.href='/schedule/schedulePopUp'">

	<div id='calendar'></div>
	
	<script>
		
		
	</script>
	
	
</body>
</html>
