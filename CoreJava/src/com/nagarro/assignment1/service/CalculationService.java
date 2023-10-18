package com.nagarro.assignment1.service;

import com.nagarro.assignment1.constants.CarConstants;
import com.nagarro.assignment1.entities.Car;

public class CalculationService {
	private String carType;
	private int carPrice;
	private String carInsuranceType;
	private int insuranceAmount;

	public Car calculateInsurance(Car car) {
		carType = car.getCarType().toLowerCase();
		carPrice = car.getCarPrice();
		carInsuranceType = car.getCarInsuranceType().toLowerCase();
		switch (carType) {
		case CarConstants.HATCHBACK:
			if (carInsuranceType.equals(CarConstants.PREMIUM_INSURANCE)) {
				insuranceAmount = (carPrice * 5) / 100;
				insuranceAmount = (insuranceAmount * 20) / 100;
			} else if(carInsuranceType.equals(CarConstants.BASIC_INSURANCE)){
				insuranceAmount = (carPrice * 5) / 100;
			}
			break;

		case CarConstants.SEDAN:
			if (carInsuranceType.equals(CarConstants.PREMIUM_INSURANCE)) {
				insuranceAmount = (carPrice * 8) / 100;
				insuranceAmount = insuranceAmount+((insuranceAmount * 20) / 100);
			} else if(carInsuranceType.equals(CarConstants.BASIC_INSURANCE)){
				insuranceAmount = (carPrice * 8) / 100;
			}
			break;

		case CarConstants.SUV:
			if (carInsuranceType.equals(CarConstants.PREMIUM_INSURANCE)) {
				insuranceAmount = (carPrice * 10) / 100;
				insuranceAmount = (insuranceAmount * 20) / 100;
			} else {
				insuranceAmount = (carPrice * 10) / 100;
			}
			break;
		default:
			System.out.println("Invalid Input, Please Try Again!");break;

		}
		car.setInsuranceAmount(insuranceAmount);
		return car;
	}

	
}
