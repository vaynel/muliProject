<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
	<div class="input-form-backgroud row">
                  <div class="input-form col-md-12 mx-auto">
                     <h4 class="mb-3">회원가입</h4>
                     <form class="validation-form" novalidate>
                        <div class="row">
                           <div class="col-md-6 mb-3">
                              <label for="name">이름</label> <input type="text"
                                 class="form-control" id="name" placeholder="" value=""
                                 required>
                              <div class="invalid-feedback">이름을 입력해주세요.</div>
                           </div>
                           <div class="col-md-6 mb-3">
                              <label for="nickname">닉네임</label> <input type="text"
                                 class="form-control" id="nickname" placeholder="" value=""
                                 required>
                              <div class="invalid-feedback">닉네임을 입력해주세요.</div>
                           </div>
                        </div>

                        <div class="mb-3">
                           <label for="email">이메일</label> <input type="email"
                              class="form-control" id="email" placeholder="you@example.com"
                              required>
                           <div class="invalid-feedback">이메일을 입력해주세요.</div>
                        </div>

                        <div class="mb-3">
                           <label for="address">주소</label> <input type="text"
                              class="form-control" id="address" placeholder="서울특별시 강남구"
                              required>
                           <div class="invalid-feedback">주소를 입력해주세요.</div>
                        </div>

                        <div class="mb-3">
                           <label for="address2">상세주소<span class="text-muted">&nbsp;(선택 
                                 사항)</span></label> <input type="text" class="form-control" id="address2"
                              placeholder="상세 주소를 입력해주세요.">
                        </div>

                        <div class="row">
                           <div class="col-md-8 mb-3">
                              <label for="root">가입 경로</label> <select
                                 class="custom-select d-block w-100" id="root">
                                 <option value=""></option>
                                 <option>검색</option>
                                 <option>SNS</option>
                                 <option>지인 추천</option>
                              </select>
                              <div class="invalid-feedback">가입 경로를 선택해주세요.</div>
                           </div>
                           <div class="col-md-4 mb-3">
                              <label for="code">추천인 코드</label> <input type="text"
                                 class="form-control" id="code" placeholder="" required>
                              <div class="invalid-feedback">추천인 코드를 입력해주세요.</div>
                           </div>
                        </div>
                        <hr class="mb-4">
                        <div class="custom-control custom-checkbox">
                           <input type="checkbox" class="custom-control-input"
                              id="aggrement" required> <label
                              class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
                        </div>
                        <div class="mb-4"></div>
                        <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>


                     </form>
                  </div>
               </div>
         </div>
      </div>
</body>
</html>