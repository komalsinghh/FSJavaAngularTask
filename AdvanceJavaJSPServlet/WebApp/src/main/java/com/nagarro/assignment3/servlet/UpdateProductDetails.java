package com.nagarro.assignment3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.assignment3.dao.ProductDetailsDao;
import com.nagarro.assignment3.dao.UpdateDetailsDao;
import com.nagarro.assignment3.service.UpdateProductService;


/**
 * servlet to update data in database.
 * @author komalsingh01
 *
 */
public class UpdateProductDetails extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String title = request.getParameter("title");
			String image = request.getParameter("image");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int size = Integer.parseInt(request.getParameter("size"));
			int id = Integer.parseInt(request.getParameter("id"));
			
			UpdateProductService updateProductService = new UpdateProductService();
			updateProductService.addDetails(title,quantity,size,image,id);
			
			response.sendRedirect("showData.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
