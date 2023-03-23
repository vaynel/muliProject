package com.trillon.camp.common.code;

public enum ErrorCode {
	
	UNAUTHORIZED_REQUEST("니한테 권한없어"),
	FAILED_UPLOAD_FILE("파일 업로드 작업 중 에러가 발생했습니다");


	public String msg;
	public String redirect;

	private ErrorCode(String msg, String redirect) {
		this.msg = msg;
		this.redirect = redirect;
	}
	
	private ErrorCode(String msg) {
		this.msg = msg;
		this.redirect = "/index";
	}
	
	

}
