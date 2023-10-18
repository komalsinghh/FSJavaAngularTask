package com.nagarro.assignment3.service;

import com.nagarro.assignment3.dao.LoginDao;

/**
 * Service to call loginDao
 * @author komalsingh01
 *
 */
public class LoginService {

	/**
	 * method calling Logindao.
	 * @param uname
	 * @param password
	 * @return boolean
	 */
	public boolean checkUser(String uname, String password) {
		
		LoginDao loginDao = new LoginDao();
		return loginDao.checkUser(uname, password);
		
	}
}
