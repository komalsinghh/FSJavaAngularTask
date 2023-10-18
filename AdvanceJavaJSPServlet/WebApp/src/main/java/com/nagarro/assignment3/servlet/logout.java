package com.nagarro.assignment3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servelt to logout from app.
 * @author komalsingh01
 *
 */
public class logout extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		
		response.sendRedirect("index.jsp");
	}

	

}
