/**
 * 
 */
package com.nagarro.advancejava.assignment4.service.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nagarro.advancejava.assignment4.dao.impl.UserDaoImpl;
import com.nagarro.advancejava.assignment4.service.LoginService;

/**
 * The Class LoginServiceImpl.
 *
 * @author komalsingh01
 */
public class LoginServiceImpl implements LoginService {

	/** The ctx. */
	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

	/** The user dao. */
	UserDaoImpl userDao = ctx.getBean(UserDaoImpl.class);

	/**
	 * Check user.
	 *
	 * @param userName     the user name
	 * @param userPassword the user password
	 * @return true, if successful
	 */
	@Override
	public boolean checkUser(String userName, String userPassword) {
		if (userDao.checkUserInDB(userName, userPassword))
			return true;
		return false;
	}

}
