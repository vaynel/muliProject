let classAddEventListener= function(cssSelector,ev){
    
    let element = $(cssSelector);
    for(let i =0 ; i<element.length;i++){
        element[i].addEventListener('click',ev);
    }
}

 //paging 버튼 만들기
let createPaging = function(paging){
    
     let row_mt_3 = $('<div class = "row mt-3">');
     let nav = $('<nav aria-label="Page navigation example" >');
     let ul_pagination = $('<ul class="pagination justify-content-center">');
     let pagingPrevPage = $('<li class="page-item"><a class="page-link" href="/suggest/select2?page=${paging.prevPage}">Previous</a></li>');
     let pagingNextPage = $('<li class="page-item"><a class="page-link" href="/suggest/select2?page=${paging.nextPage}">Next</a></li>');
 
     ul_pagination.append(pagingPrevPage);
     for (let page_num = 1; page_num < paging.blockEnd; page_num++) {
         let paging = $('<li class="page-item"></li>');
         let a_paging = $('<a class="page-link">'+page_num+'</a>');

         a_paging.on('click',e=>{
            let data ={
                induty : $('input[name=induty]:checked').val(),
                doNm : $('select[name=doNm]').val(),
                sigunguNm : $('select[name=sigunguNm]').val(),
                lctCl : $('input[name=lctCl]:checked').val(),
            }
            console.dir(data);
        
            let url = "http://localhost:8080/suggest/select2?page="+page_num;
            DataToServer(url,data);
        });

        paging.append(a_paging);
        ul_pagination.append(paging);
     }
     ul_pagination.append(pagingNextPage);
     nav.append(ul_pagination);
     row_mt_3.append(nav);
     $('#campsiteList').append(row_mt_3);





 

}

// 캠핑장 리스트 추천 
let createCampingList = function(campingList){
     campingList.forEach(campsite => {
        let row = $('<div class ="row">');
        let h2 = $('<h2>'+campsite.facltNm+'</h2>')
        let homepage = $('<a href="'+campsite.homepage+'">'+campsite.homepage+'</a><br>');
        let div_col_6_col_12_small = $('<div class="col-6 col-12-small">');
        let div_image_left_fit = $('<div class="image left fit"><img src='+campsite.firstImageUrl+' alt="" /><');
        let div_col_6_col_12_small_left = $('<div class="col-6 col-12-small left">');
        let h3 = $('<h3>캠핑장 소개</h3>');
        let ul = $('<ul><li>'+campsite.lineIntro+'<br></li><li>'+campsite.intro+'<br></li><li>'+campsite.addr1+'<br></li><li>'+campsite.tel+'<br></li></ul>');

        div_col_6_col_12_small_left.append(h3);
        div_col_6_col_12_small_left.append(ul);
        div_col_6_col_12_small.append(div_image_left_fit);
        row.append(div_col_6_col_12_small);
        row.append(div_col_6_col_12_small_left);
        $('#campsiteList').append(h2);
        $('#campsiteList').append(homepage);
        $('#campsiteList').append(row);



        
     });
 
     

}


let showCampingListWithPaging = async function(data){
    let campingList 
    let paging
    await data.then((a)=>{
      campingList = a.campsites;
      paging = a.paging;
    })
    console.dir(campingList);
    console.dir(paging);
    // CampsiteList 만들기
    $('#campsiteList').empty();
    createCampingList(campingList);
    createPaging(paging);




   
}   

async function DataToServer(url,data){
    
    let sendData = await fetch(url, {
        method : 'post',
        headers: {
            'header': header,
            'X-CSRF-Token': token,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)

    }).then((data)=>{
        let receiveData = data.json();
        showCampingListWithPaging(receiveData);
        
        // $('#campsiteList').empty();
        // var html = jQuery('<div>').html(data);
        // console.dir(html);

      //  window.location.href = "http://localhost:8080/suggest/select2";
    })
};


let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;


let 경기도 = ["수원시", "성남시", "고양시", "용인시", "부천시", "안산시", "안양시", "남양주시", "화성시", "평택시", "의정부시", "시흥시", "파주시", "광명시", "김포시", "군포시", "광주시", "이천시", "양주시", "오산시", "구리시", "안성시", "포천시", "의왕시", "하남시", "여주시", "여주군", "양평군", "동두천시", "과천시", "가평군", "연천군"]
let 강원도 = ["춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시", "홍천군", "횡성군", "영월군", "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군"]
let 충청북도 = ["청주시", "충주시", "제천시", "청원군", "보은군", "옥천군", "영동군", "진천군", "괴산군", "음성군", "단양군", "증평군"]
let 충청남도 = ["천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "당진군", "금산군", "연기군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"]
let 전라북도 = ["전주시", "군산시", "익산시", "정읍시", "남원시", "김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군"]
let 전라남도 = ["목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군", "신안군"]
let 경상북도 = ["포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군"]
let 경상남도 = ["창원시", "마산시", "진주시", "진해시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군"]
let 제주특별자치도 = ["제주시", "서귀포시", "북제주군", "남제주군"]



// 도 선택하면 시,군 보여줌
$('select[name=doNm]').on("change",function(){
    console.log("시군면을 선택하세요");
    $('select[name=sigunguNm] option').remove();
    let doNm = $('select[name=doNm]').val();
    for (let i = 0; i <eval(doNm).length;i++) {
        let option = '<option>'+eval(doNm)[i]+'</option>';
        $('select[name=sigunguNm]').append(option);
    }
})


btnSummit.addEventListener('click',e=>{
    let data ={
        induty : $('input[name=induty]:checked').val(),
        doNm : $('select[name=doNm]').val(),
        sigunguNm : $('select[name=sigunguNm]').val(),
        lctCl : $('input[name=lctCl]:checked').val()
    }
    console.dir(data);

    let url = "http://localhost:8080/suggest/select2";
    DataToServer(url,data);
});


