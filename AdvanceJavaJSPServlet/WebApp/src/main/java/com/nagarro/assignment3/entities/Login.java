package com.nagarro.assignment3.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Pojo class for login
 * @author komalsingh01
 *
 */
@Entity
public class Login {
	
	@Id
	private String name;
	private String password;
	
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
