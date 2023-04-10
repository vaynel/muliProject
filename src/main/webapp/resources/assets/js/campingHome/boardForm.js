
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
            let itemBlock = document.getElementById('itemBlock');
            let items = document.getElementById('items');
            let newItem = document.createElement('input');

            newItem.setAttribute("id","addItems");
            newItem.setAttribute("name","itemName");
            newItem.setAttribute("type","text");
            newItem.setAttribute("value",item.itemName);
            itemBlock.appendChild(newItem)

    document.getElementById('addItem').value = null;

});

