/**
 * 
 */
 
 function check(obj){
		if(obj.checked)
			document.getElementById('timeBox').style.display='none';
		else
			document.getElementById('timeBox').style.display='block';
	}
	
	let token = document.querySelector("meta[name='_csrf']").content;
    let header = document.querySelector("meta[name='_csrf_header']").content;
    
    function PostTest(){
    	
    	if(!title.value)
		{
		alert('일정 이름을 입력해 주시기 바랍니다');
		return 0;
		}
    	
    	if(!date.value)
		{
		alert('시작 날짜를 입력해 주시기 바랍니다');
		return 0;
		}
    	
    	if(!dateEnd.value)
		{
		alert('종료 날짜를 입력해 주시기 바랍니다');
		return 0;
		}

    	
        let data = {title : title.value, date : date.value, dateEnd : dateEnd.value, startTime: startTime.value};
        
        let response = fetch("http://localhost:8080/schedule/addTodo",{
            method : 'post',
            headers: {
                'header': header,
                'X-CSRF-Token': token,
                'Content-Type': 'application/json',
            },
                      //redirect:'follow',            
            body: JSON.stringify(data)
        }).then((response)=>{     
        	console.dir(response);
        	window.close();
        	//window.location.href="http://localhost:8080/schedule/calendar";	
        	
        })      
    }

    function canPage(){
    	window.location.href="http://localhost:8080/schedule/calendar";	
    	
    }
    
    
    btnClick.addEventListener('click',e=>{
        PostTest();
        
        });
    
    btnCan.addEventListener('click',e=>{
    	canPage();
        
        });
    