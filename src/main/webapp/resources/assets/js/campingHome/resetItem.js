
const resetButton = document.getElementById('resetItem');

resetButton.addEventListener('click', async (e)=>{
    e.preventDefault();

    console.log("resetButton 입성");

    document.getElementById('itemBlock').remove();

});
