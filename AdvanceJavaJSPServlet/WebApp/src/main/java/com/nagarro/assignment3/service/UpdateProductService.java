package com.nagarro.assignment3.service;

import com.nagarro.assignment3.dao.UpdateDetailsDao;

/**
 * Service to update Products in table
 * @author komalsingh01
 *
 */
public class UpdateProductService {

	/**
	 * method to call dao to update table in database.
	 * @param title
	 * @param quantity
	 * @param size
	 * @param image
	 * @param id
	 */
	public void addDetails(String title, int quantity, int size, String image, int id) {
		UpdateDetailsDao updateDetailsDao = new UpdateDetailsDao();
		updateDetailsDao.addDetails(title,quantity,size,image,id);
	}

	
	
}
