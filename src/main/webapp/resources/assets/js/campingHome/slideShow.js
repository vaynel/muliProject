let imageIndex = 0;
let postion = 0;
const IMAGE_WIDTH = 400;  // css에서 설정한 width 값과 동일하게 맞춰주세요
const btnPrevious = document.querySelector(".previous")
const btnNext = document.querySelector(".next")
const images = document.querySelector(".images")

const image = document.getElementById("image");
const imageNum = image.childElementCount;

function previous(){
    if(imageIndex > 0){
        btnNext.removeAttribute("disabled")
        postion += IMAGE_WIDTH;
        images.style.transform = `translateX(${postion}px)`;
        imageIndex = imageIndex - 1;
    }
    if(imageIndex == 0){
        btnPrevious.setAttribute('disabled', 'true')
    }
}
function next(){
    if(imageIndex < imageNum-1){
        btnPrevious.removeAttribute("disabled")
        postion -= IMAGE_WIDTH;
        images.style.transform = `translateX(${postion}px)`;
        imageIndex = imageIndex + 1;
    }
    if(imageIndex == imageNum-1){
        btnNext.setAttribute('disabled', 'true')
    }
}

function init(){
    btnPrevious.setAttribute('disabled', 'true')
    btnPrevious.addEventListener("click", previous)
    btnNext.addEventListener("click", next)
}

init();