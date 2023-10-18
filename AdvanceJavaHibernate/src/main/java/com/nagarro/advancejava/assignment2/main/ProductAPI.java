package com.nagarro.advancejava.assignment2.main;

import com.nagarro.advancejava.assignment2.entities.UserInputData;
import com.nagarro.advancejava.assignment2.service.DisplayService;
import com.nagarro.advancejava.assignment2.service.FetchInputDataService;
import com.nagarro.advancejava.assignment2.service.InputService;
import com.nagarro.advancejava.assignment2.serviceimpl.DisplayServiceImpl;
import com.nagarro.advancejava.assignment2.serviceimpl.FetchInputDataServiceImpl;
import com.nagarro.advancejava.assignment2.serviceimpl.InputServiceImpl;

/**
 * @author komalsingh01
 *
 */
/**
 * The Class ProductAPI.
 */
public class ProductAPI {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {

		InputService tshirtDetails = new InputServiceImpl();
		UserInputData userData = tshirtDetails.getTshirtDetails();

		FetchInputDataService fetchData = new FetchInputDataServiceImpl();
		fetchData.getShirtList();

		DisplayService viewData = new DisplayServiceImpl();
		viewData.viewTshirts(userData);

	}
}
