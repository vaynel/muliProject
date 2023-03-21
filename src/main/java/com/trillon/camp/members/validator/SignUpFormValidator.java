package com.trillon.camp.members.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trillon.camp.members.repository.MemberRepository;
import com.trillon.camp.members.validator.form.SignUpForm;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final MemberRepository memeberRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("SignUpFormValidator.supports 호출");
		return SignUpForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		
		SignUpForm form = (SignUpForm) target;
		
		if(memeberRepository.selectMemberByUserId(form.getUserId()) != null) {
			errors.rejectValue("userId", "existsId", "이미 존재하는 아이디 입니다.");
		}
		

	        


	
		
	}

}
