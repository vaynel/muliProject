var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");


	
		
		function signIn() {

			if(!tell.value || !gender.value || !birth.value)
				{
				alert('모든 항목을 입력해 주시기 바랍니다');
				return 0;
				}

			console.log(birth.value);
			console.log(tell.value);
			
			$.ajax({
				url : "googleSignin",
				type : "post",
				data : {
					tell : tell.value,
					gender : gender.value,
					birth : birth.value
						

				},beforeSend : function(xhr){
					xhr.setRequestHeader(header, token);
				},
				success: function(data){
					
					console.log("통신 성공");
					
					if(data === 'success')
					{
						alert('회원가입 성공! 재로그인이 필요합니다');
						
						window.location.href="http://localhost:8080/members/login";	
					}
					
					else{
						alert('회원가입 실패!');
					}
						
					
					}

			});

		}
		
		
		
		
		
		
	
		
		btnSign.addEventListener('click',e=>{
			signIn();
			
		        
		        });