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
    
    async function PostTest(){
        let data = {title : title.value};
        let response = await fetch("http://localhost:8080/schedule/addTodo",{
            method : 'post',
            headers: {
                'header': header,
                'X-CSRF-Token': token,
                'Content-Type': 'application/json',
            },
            
            redirect:'follow',
            
            body: JSON.stringify(data)
        }).then((result)=>{
            return result;
        } ).then((response)=>{
        	
        	window.location.href="http://localhost:8080/schedule/calendar";
	
        })
   
        console.dir(response);
    }

    form.addEventListener('submit',e=>{
        PostTest();
        
        });