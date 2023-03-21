package com.trillon.camp.common.config;

import javax.sql.DataSource;

/*import org.springframework.boot.autoconfigure.security.servlet.PathRequest;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity // 
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final DataSource dataSource;
	/* private final UserDetailsService userDetailsService; */
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.headers().frameOptions().sameOrigin();
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,  "/**").permitAll()
		.antMatchers(HttpMethod.POST,  "/**").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/sample/admin").permitAll()
		.antMatchers(HttpMethod.GET,  "/index").permitAll()
		.antMatchers(HttpMethod.GET,  "/elements").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/suggest/**").permitAll() 
		.antMatchers(HttpMethod.POST, "/suggest/**").permitAll()
				
		.antMatchers(HttpMethod.GET,  "/sample/admin").permitAll()
		.antMatchers(HttpMethod.GET, "/members/signin").permitAll()
		.antMatchers(HttpMethod.POST, "/mail").permitAll()
		.antMatchers(HttpMethod.GET, "/comewithme/comeWithMeList", "/comewithme/comeWithMeSelect", "/comewithme/comeWithMeBoard").permitAll()
		.antMatchers(HttpMethod.GET,  "/members/login").permitAll()
		.antMatchers(HttpMethod.GET,  "/board/list", "/board/detail", "/board/download").permitAll()

		.antMatchers(HttpMethod.GET,  "/sample/member").hasAuthority("ROLE_MEMBER")

		.anyRequest().authenticated();
		
		
		
	  http.formLogin() .loginProcessingUrl("/members/login")
	  .loginPage("/members/login") .usernameParameter("userId")
	  //.successHandler(authSuccessHandler) //.failureHandler(authFa ilureHandler)
	 
	  .permitAll();
		 
		http.logout()
			.logoutUrl("/members/logout")
			.logoutSuccessUrl("/members/login");
		
		/*
		 * http.rememberMe() .userDetailsService(userDetailsService)
		 * .tokenRepository(tokenRepository());
		 */
		
		
		//http.csrf().disable();
		http.csrf().ignoringAntMatchers("/mail");
//		http.csrf().ignoringAntMatchers("/chat");

	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(HttpMethod.GET,"/resources/**");
	}
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
