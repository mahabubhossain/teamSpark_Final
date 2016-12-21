package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.UserCredentials;
import edu.mum.service.AuthorityService;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("member")
public class LoginController {

	String userAuthority;

	@Autowired
	UserCredentialsService credentialsService;

	@Autowired
	AuthorityService authorityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model) {
		/*
		 * AuthenticateUser authenticateUser = new AuthenticateUser(); Boolean
		 * isLogin = authenticateUser.authenticate(credentials.getUsername(),
		 * credentials.getPassword());
		 * 
		 * if (!isLogin) return "login";
		 */

		UserCredentials validCredentials = credentialsService.findOne(credentials.getUsername());

		userAuthority = authorityService.findAuthority(credentials.getUsername());

		if (validCredentials == null)
			return "login";
		else {
			model.addAttribute("member", validCredentials.getMember());
			return "redirect:/welcome";
		}
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/welcome";
	}
}
