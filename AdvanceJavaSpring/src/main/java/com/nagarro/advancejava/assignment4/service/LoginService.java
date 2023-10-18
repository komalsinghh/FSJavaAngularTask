/**
 * 
 */
package com.nagarro.advancejava.assignment4.service;

/**
 * The Interface LoginService.
 *
 * @author komalsingh01
 */
public interface LoginService {

	/**
	 * Check user.
	 *
	 * @param userName     the user name
	 * @param userPassword the user password
	 * @return true, if successful
	 */
	public abstract boolean checkUser(String userName, String userPassword);
}
