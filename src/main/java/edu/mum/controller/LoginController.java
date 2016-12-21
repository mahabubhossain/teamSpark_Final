package edu.mum.controller;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.Authority;
import edu.mum.domain.UserCredentials;
import edu.mum.security.AuthenticateUser;
import edu.mum.service.AuthorityService;
import edu.mum.service.MemberService;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("member")
public class LoginController {

	String userAuthority;
	
	@Autowired
	UserCredentialsService credentialsService;
	
	@Autowired
	AuthorityService authorityService; 
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	
	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model) {

		UserCredentials validCredentials = credentialsService.findOne(credentials.getUsername());
		
		AuthenticateUser authenticateUser = new AuthenticateUser();
	     try {
	    	 ApplicationContext ctx = new ClassPathXmlApplicationContext("context/DispatcherServlet-context.xml");
	    	 AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");
	  		authenticateUser.authenticate(authenticationManager, credentials.getUsername(), credentials.getPassword());
	  	} catch (Exception e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	}
 
	     try {
	    	 userAuthority = authorityService.findAuthority(credentials.getUsername());
	    	 
	     }catch(AccessDeniedException e){
	    	 System.out.println( );
	 		   System.out.println("****** ACCESS DENIED !  **********");
			   System.out.println( );
	     }
	     
		if (validCredentials == null)
			return  "login";
		else{
			model.addAttribute("member", validCredentials.getMember());
			if(userAuthority == "ROLE_ADMIN")
				return  "redirect:/admin";
			else if(userAuthority == "ROLE_USER")
				return  "redirect:/client";
			else if(userAuthority == "ROLE_PRODUCT_MGR")
				return  "redirect:/productManager";
			else if(userAuthority == "ROLE_WAREHOUSE_MGR")
				return  "redirect:/warehouseManager";
		}
		//model.addAttribute("member", validCredentials.getMember());
 		//return "redirect:/welcome";
		return userAuthority;
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
 		return "redirect:/welcome";
 	}
}
