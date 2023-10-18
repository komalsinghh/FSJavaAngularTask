package com.nagarro.assignment3.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.assignment3.entities.ProductDetails;
import com.nagarro.assignment3.utils.FactoryProvider;

/**
 * Class to update data in database
 * @author komalsingh01
 *
 */
public class UpdateDetailsDao {

	/**\
	 * Method to update data in database
	 * @param title
	 * @param quantity
	 * @param size
	 * @param image
	 * @param id
	 */
	public void addDetails(String title, int quantity, int size, String image, int id) {
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		ProductDetails productDetails = session.get(ProductDetails.class, id);
		productDetails.setImage(image);
        productDetails.setQuantity(quantity);
        productDetails.setSize(size);
        productDetails.setTitle(title);
		
		transaction.commit();
		
		session.close();
		
	}
	
	

}
