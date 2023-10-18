package com.nagarro.advancejava.assignment1.entities;

public class TshirtsData {
	private String tshirtId;
	private String modelName;
	private String tshirtColor;
	private String tshirtSize;
	private String tshirtGender;
	private double tshirtPrice;
	private float tshirtRating;
	private String tshirtAvailability;

	public TshirtsData(String tshirtId, String modelName, String tshirtColor, String tshirtSize, String tshirtGender,
			double tshirtPrice, float tshirtRating, String tshirtAvailability) {
		super();
		this.tshirtId = tshirtId;
		this.modelName = modelName;
		this.tshirtColor = tshirtColor;
		this.tshirtSize = tshirtSize;
		this.tshirtGender = tshirtGender;
		this.tshirtPrice = tshirtPrice;
		this.tshirtRating = tshirtRating;
		this.tshirtAvailability = tshirtAvailability;
	}

	public TshirtsData() {
	}

	public String getTshirtId() {
		return tshirtId;
	}

	public void setTshirtId(String tshirtId) {
		this.tshirtId = tshirtId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

	public double getTshirtPrice() {
		return tshirtPrice;
	}

	public void setTshirtPrice(double tshirtPrice) {
		this.tshirtPrice = tshirtPrice;
	}

	public float getTshirtRating() {
		return tshirtRating;
	}

	public void setTshirtRating(float tshirtRating) {
		this.tshirtRating = tshirtRating;
	}

	public String getTshirtAvailability() {
		return tshirtAvailability;
	}

	public void setTshirtAvailability(String tshirtAvailability) {
		this.tshirtAvailability = tshirtAvailability;
	}

	@Override
	public String toString() {
		return String.format("%-14s", this.tshirtId) + "|" + String.format("%-37s", this.modelName) + "|"
				+ String.format("%-10s", this.tshirtColor) + "|" + String.format("%-5s", this.tshirtGender) + "|"
				+ String.format("%-10s", this.tshirtSize) + "|" + String.format("%-6s", this.tshirtPrice) + "|"
				+ String.format("%-6s", this.tshirtRating) + "|" + this.tshirtAvailability;
	}
}
