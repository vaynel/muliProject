let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

const form = document.getElementById('reply');
//const context = document.getElementById('context').value
const bdIdx = document.getElementById('bdIdx').value;


form.addEventListener('submit', async (e)=>{
    e.preventDefault();

    let reply = {
        context:context.value,
    }

    let formData = new FormData();
    formData.append('context',context.value);

    await fetch("http://localhost:8080/campingHome/board/" + bdIdx,{
        method : 'POST',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(reply)
    })
        .then((response) => response.json())
        .then(data=>{

            let replies = document.getElementById('replies');
            let newReply = document.createElement('p');
            newReply.innerHTML = data.context;
            newReply.setAttribute("id","reply");
            replies.appendChild(newReply)

        })
        .catch((err)=> console.log(err));

    document.getElementById('context').value = null;
});



