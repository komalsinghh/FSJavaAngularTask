package com.training.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

/**
 * Service for AppController
 * @author komalsingh01
 *
 */
@Service
public class AppService {

	/**
	 * Service to logout from app
	 * @param request
	 * @return
	 */
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("uname");
		session.invalidate();
		return "index.jsp";
	}
	
	
}
