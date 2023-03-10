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

    let url = "http://localhost:8081/suggest/suggestPlace";
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