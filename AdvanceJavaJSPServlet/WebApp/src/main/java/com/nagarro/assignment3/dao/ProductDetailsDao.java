package com.nagarro.assignment3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.assignment3.entities.ProductDetails;

/**
 * ProductDetailsDao to set value into the database.
 * @author komalsingh01
 *
 */
public class ProductDetailsDao {

	/**
	 * method to set data to database.
	 * @param title
	 * @param quantity
	 * @param size
	 * @param image
	 */
	public void addDetails(String title, int quantity, int size, String image) {
		
		Configuration cfg  = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        ProductDetails productDetails = new ProductDetails();
        productDetails.setImage(image);
        productDetails.setQuantity(quantity);
        productDetails.setSize(size);
        productDetails.setTitle(title);
        
        session.saveOrUpdate(productDetails);
        
        transaction.commit();
        session.close();
        factory.close();
		
	}
}
