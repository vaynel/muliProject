/**
 * 
 */





let classAddEventListener= function(cssSelector,ev){
    
    let element = $(cssSelector);
    for(let i =0 ; i<element.length;i++){
        element[i].addEventListener('click',ev);
    }
}


let selectList = [
    ["가족","친구","연인","모임"],
    ["경기도", "충청도", "전라도", "경상도", "강원도"],
    ["바다","산","무관"]
]

let questionList =[
    "누구와 함께 가고 싶나요?",
    "어디로 가고 싶나요(지역)?",
    "어디로 가고 싶나요(산/바다)?"

]

let answer =[];

let selectIndex = 0;

let suggestPlaceURL=()=>{

    let token = document.querySelector("meta[name='_csrf']").content;
    let header = document.querySelector("meta[name='_csrf_header']").content;

    console.dir(token);
    console.dir(header);

    // let url = "http://localhost:8081/suggest/suggestPlace";
    let url = "http://localhost:8080/suggest/suggestPlace";
    let data={
        who: answer[0],
        location : answer[1],
        terrain : answer[2]
    }
    data=JSON.stringify(data);
    console.dir(data);

    let xhr = new XMLHttpRequest();
    
    xhr.open("POST", url);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader(header,token);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.dir(this.responseText);
        }
    };
    xhr.send(data);

    location.href = url;
}

let changeSelectQuestion= ()=>{
    questionnaire.replaceChildren();
    if(selectIndex==3){
        suggestPlaceURL();
        return;
    }
    for(let i=0; i<selectList[selectIndex].length;i++){
        question.innerText=questionList[selectIndex];
        let option = createElement('li', {prop:{className:'option'}});
        let a = createElement('a',{prop:{ className:"button primary small fit", innerText:selectList[selectIndex][i],id:option}})
        let br= createElement('br');
        option.prepend(a);
        option.prepend(br);
        option.addEventListener('click',ev=>{
            answer.push(a.innerText);
        })

        $('.questionnaire').append(option);
    }

    classAddEventListener('.option',changeSelectQuestion)
    selectIndex++;
    
}

classAddEventListener('.option',changeSelectQuestion)
changeSelectQuestion();



let MYKEY ="Xoc%2Fw%2B%2FnadLCHKskLv3utx5JAtAnnq2P0fPezsNoWQcAIrAcAlIVL%2FQAZRKISe8eCMimo5u98Qhpe5vAyT%2BwZg%3D%3D";
let GoCampingURL= "http://apis.data.go.kr/B551011/GoCamping/basedList?serviceKey=";
let _type = "&_type=json";

// "https://cros-anywhere.herokuapp.com/"+

// get방식으로 해야함 -> cros 오류로 인하여 get으로 작성해야함 -> suggest/select에서 paramsList를 받아서 url를 작성하고 get으로 받아서 data parsing을 해야함
// get으로 받는 것 까지는 성공적으로 하였음 -> post 실패 후 원인은 서버에서 cros를 방지하기 위해 post방식을 막은 것으로 생각이 듬
// server에 데이터를 업데이트,추가 하는 것이 아니고 서버에 있는 데이터를 불러오기만하기 때문에 get으로 하는 것이 옳은 방식임

let result = fetch(GoCampingURL+MYKEY+"&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=TestApp"+_type, {
	method : 'get',
	})
    result.then(function(response) {
      console.log('response', response)
      console.log('header', response.headers.get('Content-Type'))
      return response.text()
    }).then(function(text) {
      console.log('got text', text)
    }).catch(function(ex) {
      console.log('failed', ex)
    });


let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

console.dir(token);
console.dir(header);