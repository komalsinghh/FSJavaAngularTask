package com.nagarro.assignment1.service;

import com.nagarro.assignment1.entities.Car;

public class DisplayService {
	private String carModel;
	private String carType;
	private int carPrice;
	private String carInsuranceType;
	private int insuranceAmount;

	public DisplayService(Car car) {
		this.carModel = car.getCarModel();
		this.carType = car.getCarType();
		this.carPrice = car.getCarPrice();
		this.carInsuranceType = car.getCarInsuranceType();
		this.insuranceAmount = car.getInsuranceAmount();
	}

	@Override
	public String toString() {
		return " [Car Model=" + carModel + ", Car Type=" + carType + ", Car Price=" + carPrice + ", Car Insurance Type="
				+ carInsuranceType + ", Total Amount to be paid=" + insuranceAmount + "]";

	}

}
