package com.trillon.camp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		System.out.println("/");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	@GetMapping("/index")
	public void index() {
		System.out.println("index.jsp");
	}
	
	@GetMapping("/generic")
	public void generic() {
		System.out.println("generic.jsp");
	}
	
	@GetMapping("/elements")
	public void elements() {
		System.out.println("elements.jsp");
	}
	
	@GetMapping("/sample/all")
	public void doAll() {
		log.info("do all can access everybody");
	}
	
	@GetMapping("/sample/member")
	public void doMember() {
		log.info("logined member");
		System.out.println("member");
	}
	
	@GetMapping("/sample/admin")
	public void doAdmin() {
		log.info("admin only");
	}
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/mail/mail-template")
	public void mail() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
