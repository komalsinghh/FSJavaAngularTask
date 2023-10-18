package com.nagarro.assignment3.service;

import com.nagarro.assignment3.dao.ProductDetailsDao;

/**
 * class to call product details dao
 * @author komalsingh01
 *
 */
public class ProductDetailsService {

	public void addDetails(String title, int quantity, int size, String image) {
		
		ProductDetailsDao productDetailsDao = new ProductDetailsDao();
		productDetailsDao.addDetails(title, quantity, size, image);
		
	}
}
