let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

const form = document.getElementById('form');

form.addEventListener('submit', async (e)=>{
    e.preventDefault();

    let data = {
        title: title.value,
        text: text.value,
        hashtag:hashtag.value
    }
    await fetch("http://localhost:8080/campingHome/board/new",{
        method : 'post',
        //redirect: 'follow',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then((response)=>{
            window.location.href = "http://localhost:8080/campingHome/boards";
        }).catch((err)=>{
            console.log("err",err);
        })

});

