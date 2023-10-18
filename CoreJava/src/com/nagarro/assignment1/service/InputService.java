package com.nagarro.assignment1.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.nagarro.assignment1.constants.CarConstants;
import com.nagarro.assignment1.entities.Car;

/**
 * The Class InputService.
 */
public class InputService {

	/**
	 * Gets the input from user.
	 *
	 * @return the input from user
	 * @throws Exception the exception
	 */
	public Car getInputFromUser() throws Exception {
		Scanner sc = new Scanner(System.in);
		Car car=new Car();
		
		System.out.println("Enter the model of car:");
			String carModel = sc.next();
			if(carModel.matches("^\\d+(\\.\\d+)?")) {
				throw new InputMismatchException("Please Enter Valid Car Model");
			}
			car.setCarModel(carModel);
		
		
		System.out.println("Enter Car Type");
		String carType = sc.next();
	
		if(!(carType.equalsIgnoreCase(CarConstants.HATCHBACK)) && !(carType.equalsIgnoreCase(CarConstants.SEDAN)) && !(carType.equalsIgnoreCase(CarConstants.SUV))) {
			throw new Exception("Please Enter Valid Car");
		}
		car.setCarType(carType);
		
		System.out.println("Enter Type of Insurance");
		String carInsurance = sc.next();
			if((!carInsurance.equalsIgnoreCase(CarConstants.BASIC_INSURANCE))&&(!carInsurance.equalsIgnoreCase(CarConstants.PREMIUM_INSURANCE))) {
				throw new Exception("Please Enter Valid Insurance Type");
			}
			
		
		car.setCarInsuranceType(carInsurance);
		
		System.out.println("Enter Car Price");
		
		int carPrice = sc.nextInt();
		car.setCarPrice(carPrice);
		
		return car;

	}
}
