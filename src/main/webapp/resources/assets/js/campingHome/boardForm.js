let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

const form = document.getElementById('form');

form.addEventListener('submit', async (e)=>{
    e.preventDefault();


    const formData = new FormData(form);
    const photos = document.querySelector('input[type="file"][multiple]');
    formData.append(`files`, photos.files);

    // for (let i = 0; i < photos.files.length; i++){
    //     formData.append(`files`, photos.files);
    // }


    // let data = {
    //     title: title.value,
    //     text: text.value,
    //     hashtag:hashtag.value,
    // }

    await fetch("http://localhost:8080/campingHome/board/new",{
        method : 'POST',
        //redirect: 'follow',
        headers: {
            'header': header,
            'X-CSRF-Token': token,

        },
        body : formData,
    })
        .then((response)=>{
            response.json()
            //window.location.href = "http://localhost:8080/campingHome/boards?page=1";
        }).then(result => console.log("Success:", result))
        .catch((err)=>{
            console.log("err",err);
        })

});
