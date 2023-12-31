/**
 * 
 */
package com.nagarro.advancejava.assignment4.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class User.
 *
 * @author komalsingh01
 */
@Entity
public class User {

	/** The username. */
	@Id
	private String username;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
