
let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;


const button = document.getElementById('itemButton');
const form = document.getElementById('form');
const addItem = document.getElementById('addItem');

button.addEventListener('click', async (e)=>{
    e.preventDefault();

    console.log("button 입성");

    let item ={
        itemName:addItem.value
    }

            let items = document.getElementById('items');
            let newItem = document.createElement('input');

            newItem.setAttribute("id","items");
            newItem.setAttribute("name","itemName");
            newItem.setAttribute("type","text");
            newItem.setAttribute("value",item.itemName);
            items.appendChild(newItem)

    document.getElementById('addItem').value = null;

});


// form.addEventListener('submit', async (e)=>{
//     e.preventDefault();
//
//     console.log("null제거 입성 입성");
//
//     if(!addItem.value){
//         addItem.setAttribute('disabled','true')
//     }
//
//
//     const formData = new FormData(form);
//     console.log(formData);
//
//
//     await fetch("http://localhost:8080/campingHome/board/new" ,{
//         method : 'POST',
//         //redirect : 'follow',
//         headers: {
//             'header': header,
//             'X-CSRF-Token': token,
//         },
//         body: formData
//     })
//         .then((response)=>{
//             console.log(response.json());
//             //window.location.href = "http://localhost:8080/campingHome/boards?page=1";
//         }).then(result => console.log("Success:", result))
//         .catch((err)=>{
//             console.log("err",err);
//         })
// });
