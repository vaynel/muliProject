package com.trillon.camp.comewithme.common.exception;

import com.trillon.camp.comewithme.common.code.ErrorCode;

public class HandlableException extends RuntimeException {

	private static final long serialVersionUID = -8895874584274123578L;
	
	public ErrorCode error;
	
	public HandlableException(ErrorCode error) {
		this.error = error;
	}
	
	public HandlableException(ErrorCode error, Exception e) {
		this.error = error;
		e.printStackTrace();
	}
	 
	
}
