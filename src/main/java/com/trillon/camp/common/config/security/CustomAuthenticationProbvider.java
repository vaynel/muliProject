package com.trillon.camp.common.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class CustomAuthenticationProbvider implements AuthenticationProvider{


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {			
		
		log.info("{}", authentication);
		
		
		
		return null;	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
	}

}
