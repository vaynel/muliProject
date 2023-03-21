let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

createRoom.addEventListener('submit', async (e)=>{
    e.preventDefault();

    let data = {
        userId: userId.value,
        groupName: groupName.value,
        maxMember: maxMember.value,
        roomMaster: roomMaster.value,
        currentMember : 1
    }
    console.dir(data);
    await fetch("http://localhost:8081/groupChat/createChat",{
        method : 'post',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then((response)=>{
        console.dir(response);
        window.location.href = "http://localhost:8081/groupChat/groupChatList";
        
    })
    .catch((err)=>{
        console.log("err",err);
    })

});