let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

//  $(document).ready(function(){

//     var roomName = [[${roomName}]];

//     if(roomName != null)
//         alert(roomName + "방이 개설되었습니다.");

//     $(".btn-create").on("click", function (e){
//         e.preventDefault();

//         var name = $("input[name='name']").val();

//         if(name == "")
//             alert("Please write the name.")
//         else
//             $("form").submit();
//     });

// });

const form = document.getElementById('form');

form.addEventListener('submit', async (e)=>{
    e.preventDefault();

    let data = {
        name: roomName1.value,
    }
    console.dir(data);
    await fetch("http://localhost:8081/chat/room",{
        method : 'post',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .catch((err)=>{
        console.log("err",err);
    })

});

