/**
 * 
 */
package com.nagarro.advancejava.assignment4.main;

import com.nagarro.advancejava.assignment4.service.impl.ReadCSV;

/**
 * The Class ProductSearchAPI.
 *
 * @author komalsingh01
 */
public class ProductSearchAPI {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {
		try {
			ReadCSV read = new ReadCSV();
			read.getShirtList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
