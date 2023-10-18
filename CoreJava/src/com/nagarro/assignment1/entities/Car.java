package com.nagarro.assignment1.entities;

public class Car {
	private String carModel;
	private String carType;
	private int carPrice;
	private String carInsuranceType;
	private int insuranceAmount;
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarInsuranceType() {
		return carInsuranceType;
	}

	public void setCarInsuranceType(String carInsuranceType) {
		this.carInsuranceType = carInsuranceType;
	}
	public int getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(int insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
}
