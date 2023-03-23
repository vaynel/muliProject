let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

const form = document.getElementById('form');

form.addEventListener('submit', async (e)=>{
    e.preventDefault();

    const formData = new FormData();
    const photos = document.querySelector('input[type="file"][multiple]');

    formData.append('title','title');
    formData.append('text','text');
    formData.append('hashtag','hashtag');
    for (let i = 0; i< photos.files.length; i++){
        formData.append(`photos_${i}`,photos.files[i]);
    }




    // let data = {
    //     title: title.value,
    //     text: text.value,
    //     hashtag:hashtag.value,
    //     photos_1:photos.files[1]
    // }


    await fetch("http://localhost:8080/campingHome/board/new",{
        method : 'post',
        //redirect: 'follow',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        //body: JSON.stringify(data)
        body : JSON.stringify(formData)
    })
        // .then((response) => response.json())
        // .then((result) => {
        //     console.log('성공:', result);
        // })
        // .catch((error) => {
        //     console.error('실패:', error);
        // })

        .then((response)=>{
            window.location.href = "http://localhost:8080/campingHome/boards?page=1";
        }).catch((err)=>{
            console.log("err",err);
        })

});

