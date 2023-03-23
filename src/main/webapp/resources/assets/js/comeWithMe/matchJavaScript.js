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


