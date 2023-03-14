let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;


const form = document.getElementById('form');

// let result = fetch("http://localhost:8080/campingHome/board/new", {
//
//     method : 'post',
//     headers: {
//         'header': header,
//         'X-CSRF-Token': token,
//         'Content-Type': 'application/json',
//     },
//     body: JSON.stringify(data), // json으로 변경해줘야하나?
// });
//
// form.addEventListener('submit',(e) =>{
//     e.preventDefault();
//
//     const title = document.getElementById("text").value;  //
//     const content = document.getElementById("content").value; //
//
//     data = {title : title, content : content};
//
//     result.then(function(response) {
//         return response.text()
//     }).then(function(text) {
//         console.log('got text', text)
//     }).catch(function(ex) {
//         console.log('failed', ex)
//     });

let data = {title : title.value, text : text.value};

async function PostTest(){
    let response = await fetch("http://localhost:8080/campingHome/boards/new",{
        method : 'post',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then((result)=>{
        return result;
    } )
    console.dir(response);
}

form.addEventListener('submit',PostTest);


