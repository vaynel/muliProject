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
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity // 
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final DataSource dataSource;
	
	
	
	@Configuration
	   public class AppConfig {
	       @Bean(name = "mvcHandlerMappingIntrospector")
	       public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
	           return new HandlerMappingIntrospector();
	       }
	   }
	
	
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	
		http.headers().frameOptions().sameOrigin();
		
		http.authorizeRequests()
//		.antMatchers(HttpMethod.GET,  "/mail/**").permitAll()
		.antMatchers(HttpMethod.POST,  "/mail/**").permitAll()
		
//		.antMatchers(HttpMethod.GET,  "/mail-template/**").permitAll()
//		.antMatchers(HttpMethod.GET,  "/mailTemplate/**").permitAll()
//		.antMatchers(HttpMethod.POST,  "/mail-template/**").permitAll()
//		.antMatchers(HttpMethod.POST,  "/mailTemplate/**").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/resources/**").permitAll()
		.antMatchers(HttpMethod.POST,  "/resources/**").permitAll()
		.antMatchers("/resources/**").permitAll()

		.antMatchers(HttpMethod.GET,  "/comewithme/comeWithMeList").permitAll()
		.antMatchers(HttpMethod.POST,  "/comewithme/comeWithMeList").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/campingHome/boards/").permitAll()
		.antMatchers(HttpMethod.POST,  "/campingHome/boards/").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/campingHome/images/**").permitAll()
		.antMatchers(HttpMethod.POST,  "/campingHome/images/**").permitAll()
		
		.antMatchers(HttpMethod.GET,  "/members/**").permitAll()
		.antMatchers(HttpMethod.POST,  "/members/**").permitAll()

		.antMatchers(HttpMethod.GET,  "/index").permitAll()
		.antMatchers(HttpMethod.GET,  "/elements").permitAll()
		
		
		.antMatchers(HttpMethod.GET,  "/schedule/**").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/schedule/**").hasRole("USER")
				
		.antMatchers(HttpMethod.GET,  "/campingHome/board/new").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/campingHome/board/new").hasRole("USER")
		
		.antMatchers(HttpMethod.GET,  "/groupChat/*").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/groupChat/*").hasRole("USER")
		
		.antMatchers(HttpMethod.GET,  "/group/*").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/group/*").hasRole("USER")
		
		.antMatchers(HttpMethod.GET,  "/suggest/*").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/suggest/*").hasRole("USER")
		
		.antMatchers(HttpMethod.GET,  "/comewithme/comeWithMeCreateBoard").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/comewithme/comeWithMeCreateBoard").hasRole("USER")
		
		.antMatchers(HttpMethod.GET,  "/comewithme/detail").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/comewithme/detail").hasRole("USER")

		.anyRequest().authenticated();
		
		
		
	  http.formLogin() .loginProcessingUrl("/members/login")
	  .loginPage("/members/login") .usernameParameter("userId")

	 
	  .permitAll();
		 
		http.logout()
			.logoutUrl("/members/logout")
			.logoutSuccessUrl("/members/login")
			.invalidateHttpSession(true);
		

		
		http.csrf().ignoringAntMatchers("/mail/**");
		http.csrf().ignoringAntMatchers("/mailTemplate/**");


		http.csrf().ignoringAntMatchers("/members/**");
	}
	
	
	  @Override public void configure(WebSecurity web) {
	  web.ignoring().antMatchers(HttpMethod.GET,"/resources/**", "/storage/**"); 
	
      web.ignoring().antMatchers("/resources/**");
   
	  
	  }
	 
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}
	
	

	

}
