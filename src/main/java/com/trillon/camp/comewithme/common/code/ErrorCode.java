package com.trillon.camp.comewithme.common.code;

public enum ErrorCode {

	FAILED_UPLOAD_FILE("파일 업로드 작업 중 에러가 발생했습니다");

	
	public String msg;
	public String redirect;
	
	
	private ErrorCode(String msg) {
		this.msg = msg;
		this.redirect = "/index";
	}
	
	ErrorCode(String msg, String redirect) {
		this.msg = msg;
		this.redirect = redirect;
	}
}
