package com.training.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.Model.Login;
import com.training.Service.AppService;
import com.training.Service.LoginService;

/**
 * App Controller linked with index.jsp
 * 
 * @author komalsingh01
 *
 */
@Controller
public class AppController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	AppService appService;

	/**
	 * add method linked with form action so that index.jsp will be show
	 * 
	 * @param request
	 * @param response
	 * @return index.jsp/result.jsp
	 */

	@RequestMapping("add")
	public String login(@ModelAttribute Login user, Model model, HttpServletRequest request) {

		boolean isUser = loginService.checkUser(user.getName(), user.getPassword());
		if (isUser) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", user.getName());
			return "result";
		}
		return "index.jsp";
	}

	/**
	 * Mapping to log out from website.
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout( HttpServletRequest request) {
		
		return appService.logout(request);
		
	}
}
