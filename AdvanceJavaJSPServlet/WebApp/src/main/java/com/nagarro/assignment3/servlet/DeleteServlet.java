package com.nagarro.assignment3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.assignment3.entities.ProductDetails;
import com.nagarro.assignment3.utils.FactoryProvider;


/**
 * Servelet to delete data from database.
 * @author komalsingh01
 *
 */
public class DeleteServlet extends HttpServlet {
	
    public DeleteServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id").trim());
			
			Session session = FactoryProvider.getFactory().openSession();
			Transaction transaction = session.beginTransaction();
			ProductDetails productDetails =  session.get(ProductDetails.class, id);
			session.delete(productDetails);
			transaction.commit();
			session.close();
			response.sendRedirect("showData.jsp");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	

}
