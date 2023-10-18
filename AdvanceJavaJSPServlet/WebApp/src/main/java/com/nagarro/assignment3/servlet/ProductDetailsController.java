package com.nagarro.assignment3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.assignment3.dao.ProductDetailsDao;
import com.nagarro.assignment3.service.ProductDetailsService;


/**
 * Servelt to take data from user.
 * @author komalsingh01
 *
 */
public class ProductDetailsController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String image = request.getParameter("image");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));
		
		ProductDetailsService detailsService = new ProductDetailsService();
		detailsService.addDetails(title,quantity,size,image);
		
		response.sendRedirect("showData.jsp");
		
		
		
	}

}
