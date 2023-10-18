package com.nagarro.advancejava.assignment1.entities;

public class UserInputData {
	private String tshirtColor;
	private String tshirtSize;
	private String tshirtGender;
	private int inputPreference;

	public UserInputData() {

	}

	public UserInputData(String tshirtColor, String tshirtSize, String tshirtGender, int inputPreference) {
		super();
		this.tshirtColor = tshirtColor;
		this.tshirtSize = tshirtSize;
		this.tshirtGender = tshirtGender;
		this.inputPreference = inputPreference;
	}

	public String getTshirtColor() {
		return tshirtColor;
	}

	public void setTshirtColor(String tshirtColor) {
		this.tshirtColor = tshirtColor;
	}

	public String getTshirtSize() {
		return tshirtSize;
	}

	public void setTshirtSize(String tshirtSize) {
		this.tshirtSize = tshirtSize;
	}

	public String getTshirtGender() {
		return tshirtGender;
	}

	public void setTshirtGender(String tshirtGender) {
		this.tshirtGender = tshirtGender;
	}

	public int getInputPreference() {
		return inputPreference;
	}

	public void setInputPreference(int inputPreference) {
		this.inputPreference = inputPreference;
	}

}
