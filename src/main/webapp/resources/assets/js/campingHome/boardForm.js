let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

<<<<<<< Updated upstream
const form = document.getElementById('form');

form.addEventListener('submit', async (e)=>{
    e.preventDefault();

    let data = {
        title: title.value,
        text: text.value,
        hashtag:hashtag.value
    }
    await fetch("http://localhost:8081/campingHome/board/new",{
        method : 'post',
        //redirect: 'follow',
=======

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
>>>>>>> Stashed changes
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
<<<<<<< Updated upstream
    })
        .then((response)=>{
            let num = response.text();
            window.location.href = "http://localhost:8080/campingHome/boards?page=1";
        }).catch((err)=>{
            console.log("err",err);
        })

});
=======
    }).then((result)=>{
        return result;
    } )
    console.dir(response);
}

form.addEventListener('submit',PostTest);

>>>>>>> Stashed changes

