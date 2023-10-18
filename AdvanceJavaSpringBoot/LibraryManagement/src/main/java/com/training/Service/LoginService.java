package com.training.Service;

import org.springframework.stereotype.Service;

import com.training.Dao.LoginDao;

/**
 * Service to call loginDao
 * @author komalsingh01
 *
 */
@Service
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
