package com.trillon.camp.common.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trillon.camp.common.exception.HandlableException;


@Component
@ControllerAdvice(basePackages = "com.trillion.camp")
public class ExceptionAdvice {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	// 지정한 예외가 Controller에서 발생하면, 어노테이션이 선언된 메서드가 호출 된다.
		@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(HandlableException.class)
		public String handlableExceptionHandling(HandlableException e,Model model) {
			model.addAttribute("msg", e.error.msg);
			model.addAttribute("redirect", e.error.redirect);
			
			return "common/alert-message";
		
		}

		// DataAccessException : 스프링은 SQLException이 발생할 경우 해당 예외 runtimeException인 
		// DataAccessException 으로 wrapping하여 서비스레이어에 전달
		@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(DataAccessException.class)
		public String handlingDataAccessException(DataAccessException e,Model model) {
			
			// {} : 객체
			// logger.error(test {}, member.getUserName()) => hello hmd
			// logger에 두번째 매개변수로 Exception객체를 넘기면 stacktrace를 출력해준다.
			log.error("{}",e);
			model.addAttribute("msg", "데이터베이스 접속에 문제가 생겼습니다.");
			model.addAttribute("redirect", "/index");
			return "common/alert-message";
				
			
		}
	

}
