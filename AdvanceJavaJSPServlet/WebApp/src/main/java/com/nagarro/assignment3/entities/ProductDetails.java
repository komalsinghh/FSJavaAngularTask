package com.nagarro.assignment3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * pojo class for ProductDetails
 * @author komalsingh01
 *
 */
@Entity
public class ProductDetails {
	
	
	private String title;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pId",nullable= false)
    private int productId;
	private int quantity;
	private int size;
	private String image;
	
	@Override
	public String toString() {
		return "ProductDetails [title=" + title + ", quantity=" + quantity + ", size=" + size + ", image=" + image
				+ "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ProductDetails() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
