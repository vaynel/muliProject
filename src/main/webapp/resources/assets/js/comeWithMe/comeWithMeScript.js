let classAddEventListener = function(cssSelector, ev){
	let element = $(cssSelector);
	for(let i = 0; i < element.length; i++){
		element[i].addEventListener('click', ev);
	}
}

let matchList = [ "어디로 가고싶나요?", "어떤 캠핑을 하고싶나요?", "원하는 연령층은?"];

let selectMatchList = [
						["산", "바다"],
						["오토", "모토", "차박"],
						["20대", "30대", "40대"]
					  ];
let answer = [];

let selectIndex = 0;

let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

let matchFinish = async(answer)=>{
	let data={
			place : answer[0],
			campingWay : answer[1],
			ageAverage : answer[2]
	};
	
	let sendData = await fetch("http://localhost:8080/comewithme/comeWithMeMatch",{
		method : 'post',
		headers : {
			'header' : header,
			'X-CSRF-Token' : token,
			'Content-Type' : 'application/json'
		},
		redirect : 'follow',
		body : JSON.stringify(data)
		
	}).then((response)=>{
		let jsonTest = response.text();
		console.log(answer);
		window.location.href = "http://localhost:8080/comewithme/matchFinish?page=1";
	}).catch((err)=>{
		alert("삐요삐요 에러발생", err);
	})
	
}


let selectQuestion = () =>{
	if(selectIndex == 3){
		matchFinish(answer);
		return;
	}
	
	matchStart.replaceChildren();
	let selectIdx = selectIndex;
	
	for(let i = 0; i < selectMatchList[selectIndex].length; i++){
		console.log(selectMatchList);
		matchQuestion.innerText = matchList[selectIdx];
		let option = createElement('li', {prop:{className:'option'}});
		let a = createElement('a', {prop:{className:"button primary small fit", innerText:selectMatchList[selectIndex][i],idx:option}});
		let br = createElement('br');
		option.prepend(a);
		option.prepend(br);
		option.addEventListener('click', ev =>{
			answer.push(a.innerText);
			console.log(answer);
		})
		
		$('.matchStart').append(option);
	}
	
	classAddEventListener('.option', selectQuestion);
	selectIndex++;
}

classAddEventListener('.option', selectQuestion);
selectQuestion();







	//해시태그
	$(document).ready(function() {
		var tag = {};
		var counter = 0;
		// 입력한 값을 태그로 생성한다.
		function addTag(value) {
			tag[counter] = value;
			counter++; // del-btn 의 고유 id 가 된다.
		}
		// tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
		function marginTag() {
			return Object.values(tag).filter(function(word) {
				return word !== "";
			});
		}
		// 서버에 제공
		$("#tag-form").on("submit", function(e) {
			var value = marginTag(); // return array
			$("#rdTag").val(value);
			$(this).submit();
		});
		$("#tag").on("keypress",function(e) {
							var self = $(this);
							// 엔터나 스페이스바 눌렀을때 실행
							if (e.key === "Enter" || e.keyCode == 32) {
								var tagValue = self.val(); // 값
															// 가져오기
								// 해시태그 값 없으면 실행X
								if (tagValue !== "") {
									// 같은 태그가 있는지 검사한다. 있다면 해당값이
									// array 로 return 된다.
									var result = Object
											.values(tag)
											.filter(
													function(word) {
														return word === tagValue;
													})
									// 해시태그가 중복되었는지 확인
									if (result.length == 0) {
										$("#tag-list")
												.append(
														"<li class='tag-item'>"
																+ tagValue
																+ "<span class='del-btn' idx='"
																+ counter
																+ "'>x</span></li>");
										addTag(tagValue);
										self.val("");
									} else {
										alert("태그값이 중복됩니다.");
									}
								}
								e.preventDefault(); // SpaceBar 시
													// 빈공간이 생기지 않도록
													// 방지
							}
						});
		// 삭제 버튼
		// 인덱스 검사 후 삭제
		$(document).on("click", ".del-btn", function(e) {
			var index = $(this).attr("idx");
			tag[index] = "";
			$(this).parent().remove();
		});
	})