package com.trillon.camp.common.exception;

import com.trillon.camp.common.code.ErrorCode;

public class HandlableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8581776016849830069L;
	
	public ErrorCode error;

	public HandlableException(ErrorCode error) {
		this.error = error;
	}
	
	public HandlableException(ErrorCode error, Exception e) {
		this.error = error;
		e.printStackTrace();
	}
	
	
	
	

}
