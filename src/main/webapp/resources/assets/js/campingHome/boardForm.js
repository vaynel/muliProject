
const button = document.getElementById('itemButton');

button.addEventListener('click', async (e)=>{
    e.preventDefault();

    console.log("button 입성");

    let item ={
        itemName:itemName.value
    }

            let items = document.getElementById('items');
            let newItem = document.createElement('input');

            newItem.setAttribute("id","items");
            newItem.setAttribute("name","itemName");
            newItem.setAttribute("type","text");
            newItem.setAttribute("value",item.itemName);
            items.appendChild(newItem)

    document.getElementById('itemName').value = null;

});



