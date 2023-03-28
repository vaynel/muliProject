let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

const form = document.getElementById('reply');
const bdIdx = document.getElementById('bdIdx').value;

form.addEventListener('submit', async (e)=>{
    e.preventDefault();

    let data = {
        reply:context.value
    }

    console.log(data);
    console.log(bdIdx);


    await fetch("http://localhost:8080/campingHome/board/" + bdIdx,{
        method : 'POST',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
        //body : JSON.stringify(formData),
    })
        .then((response)=>{
            console.log(response);
        }).catch((err)=>{
            console.log("err",err);
        })

});