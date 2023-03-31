
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
		
	
		

        function handleCredentialResponse(response) {
            // decodeJwtResponse() is a custom function defined by you
            // to decode the credential response.
            const responsePayload = parseJwt(response.credential);

            console.log("ID: " + responsePayload.sub);
            console.log('Full Name: ' + responsePayload.name);
            console.log('Given Name: ' + responsePayload.given_name);
            console.log('Family Name: ' + responsePayload.family_name);
            console.log("Image URL: " + responsePayload.picture);
            console.log("Email: " + responsePayload.email); 

            
            $.ajax({
				url : "google",
				type : "post",
				data : {
					userId : responsePayload.sub,
					name : responsePayload.name,
					email : responsePayload.email

				},beforeSend : function(xhr){
					xhr.setRequestHeader(header, token);
				},
				success: function(data){
					
					console.log("통신 성공");
					console.log(data);
					

					if(data === 'firstLogin'){
						alert('구글로그인 회원가입 창으로 이동합니다.');
						window.location.href="http://localhost:8080/members/googleSignin";	
					}				
					else if(data === 'successLogin'){

						window.location.href="http://localhost:8080/index";	
					}	
					else{
						alert('오류');
					}	
				
					
				}

			});

            
            
            
        };

        function parseJwt (token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));

            return JSON.parse(jsonPayload);
        };


		
		
		
		
		
		
		
		
		
		
		
		 btnClick.addEventListener('click',e=>{
			 	btnlogin();
		        
		        });
		
		 btnSign.addEventListener('click',e=>{
			 btnSignin();
		        
		        });
		 
		 
		 
		 
