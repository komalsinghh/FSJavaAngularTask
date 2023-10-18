package com.nagarro.advancejava.assignment1.main;
import java.util.*;

import com.nagarro.advancejava.assignment1.entities.TshirtsData;
import com.nagarro.advancejava.assignment1.entities.UserInputData;
import com.nagarro.advancejava.assignment1.service.DisplayService;
import com.nagarro.advancejava.assignment1.service.FetchInputData;
import com.nagarro.advancejava.assignment1.service.InputService;

/**
 * @author komalsingh01
 *
 */
 
public class ProductService {

	public static void main(String[] args)throws Exception {
	

		InputService tshirtDetails=new InputService();
		UserInputData userData=tshirtDetails.getTshirtDetails();
		
		FetchInputData fetchData=new FetchInputData();
		List<TshirtsData> ListOfTshirts=new ArrayList<TshirtsData>();
		ListOfTshirts=fetchData.getShirtList();
		
		DisplayService viewData=new DisplayService();
		viewData.viewTshirts(userData,ListOfTshirts);
		
	}

}
