package com.nagarro.advancejava.assignment1.service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.advancejava.assignment1.entities.TshirtsData;
import com.nagarro.advancejava.assignment1.entities.UserInputData;

import java.io.*;

public class InputService {
	UserInputData tshirtData=new UserInputData();
	private String tShirtType,tShirtSize;
	
	public UserInputData getTshirtDetails() throws Exception {
		Scanner productDetail = new Scanner(System.in);
		System.out.println("Enter T-Shirt Color");
		tshirtData.setTshirtColor(productDetail.next());
		System.out.println("Enter T-Shirt Gender (M=Male, F=Female or U=Unisex)");
		try{
			tShirtType = productDetail.next();
			Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
			Matcher matcher = pattern.matcher(tShirtType);
			if(!matcher.find()) {
				throw new Exception("\nEnter value M, F or U\n");
			}
			tshirtData.setTshirtGender(tShirtType);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Enter Size (S, M, L or XL) :");
		try{
			tShirtSize = productDetail.next();
			Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
			Matcher matcher = pattern.matcher(tShirtSize);
			if(!matcher.find()) {
				throw new Exception("\nEnter size S, M, L or XL.\n");
			}
			tshirtData.setTshirtSize(tShirtSize);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Enter Output Prefernce:	1. Price 2. Rating 3. Both\nEnter Preference Choice Code");
		int choiceCode = productDetail.nextInt();
		tshirtData.setInputPreference(choiceCode);

		productDetail.close();
		return tshirtData;
	}

}
