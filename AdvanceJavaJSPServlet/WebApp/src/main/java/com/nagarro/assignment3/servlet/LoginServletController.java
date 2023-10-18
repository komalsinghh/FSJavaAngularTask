package com.nagarro.assignment3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.assignment3.dao.LoginDao;
import com.nagarro.assignment3.service.LoginService;



/**
 * Servelt to login user into app
 * @author komalsingh01
 *
 */
public class LoginServletController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		
		
		if(loginService.checkUser(uname,password)) {
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username", uname);
			response.sendRedirect("showData.jsp");
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
