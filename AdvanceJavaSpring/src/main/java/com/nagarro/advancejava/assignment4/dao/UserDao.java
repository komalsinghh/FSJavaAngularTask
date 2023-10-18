/**
 * 
 */
package com.nagarro.advancejava.assignment4.dao;

/**
 * The Interface UserDao.
 *
 * @author komalsingh01
 */
public interface UserDao {

	/**
	 * Check user in DB.
	 *
	 * @param userName     the user name
	 * @param userPassword the user password
	 * @return true, if successful
	 */
	public abstract boolean checkUserInDB(String userName, String userPassword);
}
