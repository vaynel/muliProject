<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}"></meta>

<link rel="stylesheet" href="/resources/assets/css/suggest/suggest.css?v=<%= System.currentTimeMillis() %>">



<!-- head 설정 -->
<body class="is-preload">


	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<%@ include file="/WEB-INF/views/include/header.jsp"%>

				<!-- Content -->
				<section>
					<header class="main">
						<h1 id="recommend">장소추천</h1>
					</header>
					<div style="text-align: right;">
					<button class="noChoice1" type="button" id="nochoice" a href="#"> 아무것도 선택하지 않음
					</button>
					</div>
					<h2 id = "h2_1">어떤 종류의 캠핑을 가 보고 싶은가요?</h2>
					<div id="campingContainer">
					<input type="radio" name="typesOfCamping" value="normal"
						id="select01" checked /> <label for="select01">일반 야영장</label>
						<input type="radio" name="typesOfCamping" value="car" id="select02" /> <label
						for="select02">자동차 야영장</label>
						<input type="radio" name="typesOfCamping" value="caravane" id="select03" /> <label
						for="select03">카라반</label>
						<input type="radio" name="typesOfCamping" value="glamping" id="select04" /> <label
						for="select04">글램핑</label>
						</div>
						<br>
					<div id="choosingContainer" style="display: flex; flex-wrap: wrap;">	
					<div id="campingRegion" style="margin-right: 10px;">
						<select onchange="bigRegion(this)">
							<option value="">지역을 선택하세요.</option>
							<option value="a">경기도</option>
							<option value="b">강원도</option>
							<option value="d">충청북도</option>
							<option value="e">충청남도</option>
							<option value="f">전라북도</option>
							<option value="g">전라남도</option>
							<option value="h">경상북도</option>
							<option value="i">경상남도</option>
							<option value="k">제주특별시</option>
						</select>
					</div>					
					<br>
					<div id="smallRegion">
					<select onchange="bigRegion(this)">
						<option value="">세부 지역을 선택하세요.</option>
					</select>
					</div>
					</div>
					<br>
					<div id="whereCamping">
						<h2 id="h2_2">어디로 가 보고 싶은가요?</h2>
						<input type="radio" name="placeOfCamping" value="mountain"
							id="select05" checked /> <label for="select05">산</label> <input
							type="radio" name="placeOfCamping" value="sea" id="select06" />
						<label for="select06">바다</label> <input type="radio"
							name="placeOfCamping" value="valley" id="select07" /> <label
							for="select07">계곡</label> <input type="radio"
							name="placeOfCamping" value="downtown" id="select08" /> <label
							for="select08">도심</label> <input type="radio"
							name="placeOfCamping" value="noCares" id="select09" /> <label
							for="select09">상관없다</label>
					</div>
					<button class="answer" type="button" id="answer" onclick="location.href='jsp파일명.jsp'">확인</button>
			</div>
		</div>

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>

	</div>

	<!-- Scripts -->
	<%@ include file="/WEB-INF/views/include/commonScripts.jsp"%>
	<script>
			let classAddEventListener= function(cssSelector,ev){
			    
			    let element = $(cssSelector);
			    for(let i =0 ; i<element.length;i++){
			        element[i].addEventListener('click',ev);
			    }
			}
			
			function bigRegion(e) {
				var smallRegion_a = ["수원시", "성남시", "고양시", "용인시", "부천시", "안산시", "안양시", "남양주시", "화성시", "평택시", "의정부시", "시흥시", "파주시", "광명시", "김포시", "군포시", "광주시", "이천시", "양주시", "오산시", "구리시", "안성시", "포천시", "의왕시", "하남시", "여주시", "여주군", "양평군", "동두천시", "과천시", "가평군", "연천군"];
				var smallRegion_b = ["춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시", "홍천군", "횡성군", "영월군", "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군"];
				var smallRegion_d = ["청주시", "충주시", "제천시", "청원군", "보은군", "옥천군", "영동군", "진천군", "괴산군", "음성군", "단양군", "증평군"];
				var smallRegion_e = ["천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "당진군", "금산군", "연기군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"];
				var smallRegion_f = ["전주시", "군산시", "익산시", "정읍시", "남원시", "김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군"];
				var smallRegion_g = ["목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군", "신안군"];
				var smallRegion_h = ["포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군"];
				var smallRegion_i = ["창원시", "마산시", "진주시", "진해시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군"];
				var smallRegion_k = ["제주시", "서귀포시", "북제주군", "남제주군"];
				var target = document.getElementById("smallRegion");

				if(e.value == "a") var z = smallRegion_a;
				else if(e.value == "b") var z = smallRegion_b;
				else if(e.value == "d") var z = smallRegion_d;
				else if(e.value == "e") var z = smallRegion_e;
				else if(e.value == "f") var z = smallRegion_f;
				else if(e.value == "g") var z = smallRegion_g;
				else if(e.value == "h") var z = smallRegion_h;
				else if(e.value == "i") var z = smallRegion_i;
				else if(e.value == "k") var z = smallRegion_k;

				target.options.length = 0;

				for (x in z) {
					var opt = document.createElement("option");
					opt.value = z[x];
					opt.innerHTML = z[x];
					target.appendChild(opt);
				}	
			}
			
			let selectIndex = 0;

			let token = document.querySelector("meta[name='_csrf']").content;
			let header = document.querySelector("meta[name='_csrf_header']").content;
			let CampingInformation;

			let suggestPlace = async (answer) => {
			  let data = {
			    induty: answer[0],
			    doNm: answer[1],
			    sigunguNm: answer[2],
			    lctCl: answer[3]
			  };

			  let sendData = await fetch("http://localhost:8080/suggest/select", {
			    method: 'post',
			    headers: {
			      'header': header,
			      'X-CSRF-Token': token,
			      'Content-Type': 'application/json',
			    },
			    redirect: 'follow',
			    body: JSON.stringify(data)
			  }).then((response) => {
			    let testjson = response.text();
			    console.dir(response);
			    window.location.href = "http://localhost:8080/suggest/suggestPlace";
			  }).catch((err) => {
			    console.log("err", err);
			  })
			}

			let changeSelectQuestion = () => {

			  if (selectIndex == 4) {
			    suggestPlace(answer);
			    return;
			  }

			  questionnaire.replaceChildren();
			  if (selectIndex == 2) {
			    for (let i = 0; i < eval(answer[1]).length; i++) {
			      question.innerText = questionList[selectIndex - 1];
			      let option = createElement('li', {
			        prop: {
			          className: 'option',
			          style: 'float:left; margin-right:20px'
			        }
			      });
			      let a = createElement('a', {
			        prop: {
			          className: "button primary small",
			          innerText: eval(answer[1])[i],
			          id: option
			        }
			      })
			      let br = createElement('br');
			      option.prepend(a);
			      option.prepend(br);
			      option.addEventListener('click', ev => {
			        answer.push(a.innerText);
			      })

			      $('.questionnaire').append(option);
			    }

			    classAddEventListener('.option', changeSelectQuestion)
			    selectIndex++;
			    return;
			  }


			  //selectIndex = 0,1,3
			  let selectIdx = selectIndex;
			  if (selectIndex == 3) {
			    selectIdx = selectIndex - 1;
			  }
			  for (let i = 0; i < selectList[selectIndex].length; i++) {
			    question.innerText = questionList[selectIdx];
			    let option = createElement('li', {
			      prop: {
			        className: 'option'
			      }
			    });
			    let a = createElement('a', {
			      prop: {
			        className: "button primary small fit",
			        innerText: selectList[selectIndex][i],
			        id: option
			      }
			    })
			    let br = createElement('br');
			    option.prepend(a);
			    option.prepend(br);
			    option.addEventListener('click', ev => {
			      answer.push(a.innerText);
			    })

			   



//			let questionList =[
//			    "누구와 함께 가고 싶나요?",
//			    "어디로 가고 싶나요(지역)?",
//			    "어디로 가고 싶나요(지형)?"
//			]

//			let selectList = [
//			    ["일반야영장","자동차야영장","카라반","글램핑"],
//			    ["경기도","강원도","충청남도", "충청북도","전라남도", "전라북도","경상남도", "경상북도","제주특별자치도"],
//			    [],
//			    ["산","계곡","해변","도심","무관"]
//			]

//			let 경기도 = ["수원시", "성남시", "고양시", "용인시", "부천시", "안산시", "안양시", "남양주시", "화성시", "평택시", "의정부시", "시흥시", "파주시", "광명시", "김포시", "군포시", "광주시", "이천시", "양주시", "오산시", "구리시", "안성시", "포천시", "의왕시", "하남시", "여주시", "여주군", "양평군", "동두천시", "과천시", "가평군", "연천군"]
//			let 강원도 = ["춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시", "홍천군", "횡성군", "영월군", "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군"]
//			let 충청북도 = ["청주시", "충주시", "제천시", "청원군", "보은군", "옥천군", "영동군", "진천군", "괴산군", "음성군", "단양군", "증평군"]
//			let 충청남도 = ["천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "당진군", "금산군", "연기군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"]
//			let 전라북도 = ["전주시", "군산시", "익산시", "정읍시", "남원시", "김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군"]
//			let 전라남도 = ["목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군", "신안군"]
//			let 경상북도 = ["포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군"]
//			let 경상남도 = ["창원시", "마산시", "진주시", "진해시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군"]
//			let 제주특별자치도 = ["제주시", "서귀포시", "북제주군", "남제주군"]

//			let answer =[];

/* 

			            'header': header,
			            'X-CSRF-Token': token,
			            'Content-Type': 'application/json',
			        },
			        body: JSON.stringify(CampingData)

			    }).then((response)=>{
			        return response;
			    })
			}


			// CampingData = GoCampingAPI();
			// suggestPlaceURL(CampingData);


			// let suggestPlaceURL=(CampingData)=>{
//			     let data;
//			     let dataJson={};
//			     CampingData.then(result=>{
//			         data = result.response.body.items.item;
//			         console.dir(data);
//			         data.forEach((element,index) => {
//			             dataJson[index]= element;
//			         });
//			         console.dir(dataJson);
//			         DataToServer(dataJson);
//			     });
			// } */
			</script>


</body>
</html>



