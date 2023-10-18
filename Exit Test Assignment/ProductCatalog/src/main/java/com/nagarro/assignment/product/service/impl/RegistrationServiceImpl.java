/**
 * 
 */
package com.nagarro.assignment.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.product.dao.RegistrationDao;
import com.nagarro.assignment.product.entities.User;
import com.nagarro.assignment.product.service.RegistrationService;

/**
 * The Class RegistrationServiceImpl.
 *
 * @author komalsingh01
 */
@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	/** The registration dao. */
	@Autowired
	private RegistrationDao registrationDao;

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User saveUser(User user) {
		return registrationDao.save(user);
	}
	
	/**
	 * Fetch user by user email.
	 *
	 * @param email the email
	 * @return the user
	 */
	public User fetchUserByUserEmail(String email) {
		return registrationDao.findByUserEmail(email);
	}
	
	/**
	 * Fetch user by user email and password.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the user
	 */
	public User fetchUserByUserEmailAndPassword(String email, String password) {
		return registrationDao.findByUserEmailAndUserPassword(email, password);
	}

}
