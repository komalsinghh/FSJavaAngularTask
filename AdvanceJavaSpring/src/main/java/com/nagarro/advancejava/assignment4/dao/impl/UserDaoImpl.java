/**
 * 
 */
package com.nagarro.advancejava.assignment4.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.advancejava.assignment4.dao.UserDao;
import com.nagarro.advancejava.assignment4.entities.User;

/**
 * The Class UserDaoImpl.
 *
 * @author komalsingh01
 */
@Repository
public class UserDaoImpl implements UserDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Check user in DB.
	 *
	 * @param userName     the user name
	 * @param userPassword the user password
	 * @return true, if successful
	 */
	@Override
	public boolean checkUserInDB(String userName, String userPassword) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<User> query = session.createQuery("from User where username=:u and password=:p");
		query.setParameter("u", userName);
		query.setParameter("p", userPassword);
		User user = query.uniqueResult();
		if (user == null)
			return false;
		tx.commit();
		session.close();
		return true;
	}

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
