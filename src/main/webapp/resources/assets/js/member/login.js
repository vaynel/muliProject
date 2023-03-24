
var token = $("meta[name='_csrf']").attr("content");
	 var header = $("meta[name='_csrf_header']").attr("content");
		function btnlogin() {

			$.ajax({
				url : "afterlogin",
				type : "post",
				data : {
					userId : userId.value,
					password : password.value

				},beforeSend : function(xhr){
					xhr.setRequestHeader(header, token);
				},
				success: function(data){
					
					console.log("통신 성공");
					console.log(data);
					
					if(data === 'failEmpty'){
						alert('아이디나 비밀번호를 입력해주세요.');
					}
					else if(data === 'failWrong'){
						alert('아이디나 비밀번호가 틀렸습니다.');
					}
					else if(data === 'successLogin'){
						// let url='http://localhost:8080/'+ data;
						// console.log(url);
						// location.replace(url);
						
						window.location.href="http://localhost:8080/index";	
					}	
					else{
						alert('오류');
					}	
			
					
				
					
				}

			});

		}
		
		function btnSignin(){
			
			window.location.href="http://localhost:8080/members/signin";	
		}
		
		
		 btnClick.addEventListener('click',e=>{
			 	btnlogin();
		        
		        });
		
		 btnSign.addEventListener('click',e=>{
			 btnSignin();
		        
		        });
		 