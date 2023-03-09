package com.trillon.camp.common.code;

public enum ErrorCode {
	
	UNAUTHORIZED_REQUEST("니한테 권한없어");
	
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
