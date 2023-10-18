package com.nagarro.advancejava.assignment1.service;

import java.util.*;

import com.nagarro.advancejava.assignment1.constants.Constant;
import com.nagarro.advancejava.assignment1.entities.TshirtsData;
import com.nagarro.advancejava.assignment1.entities.UserInputData;

public class SearchService {
	List<TshirtsData> tshirtList = new ArrayList<TshirtsData>();
	UserInputData userData = null;
	List<TshirtsData> ListOfTShirt = null;

	public SearchService(UserInputData userData, List<TshirtsData> ListOfTShirt){
		this.userData=userData;
		this.ListOfTShirt=ListOfTShirt;
		
	}

	public List<TshirtsData> getListOfTShirt() {
		for(TshirtsData tShirtObject : ListOfTShirt) {
			String color = tShirtObject.getTshirtColor();
			String size = tShirtObject.getTshirtSize();
			String gender = tShirtObject.getTshirtGender();
 			if(gender.equalsIgnoreCase(userData.getTshirtGender())
 			   && size.equalsIgnoreCase(userData.getTshirtSize())
 			   && color.equalsIgnoreCase(userData.getTshirtColor())
 			   && tShirtObject.getTshirtAvailability().equalsIgnoreCase(Constant.YES)) {
 				
 				tshirtList.add(tShirtObject);
 				
 			}
		}
		return tshirtList;
	}
}
