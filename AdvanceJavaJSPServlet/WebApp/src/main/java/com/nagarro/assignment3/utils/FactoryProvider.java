package com.nagarro.assignment3.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// @author komalsingh01
/**
 * The Class FactoryProvider.
 */
public class FactoryProvider {
	 
	/** The factory. */
	public static SessionFactory factory;
	
	/**
	 * Gets the factory.
	 *
	 * @return the factory
	 */
	public static SessionFactory getFactory() {
		
		if(factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
	
	/**
	 * Close factory.
	 */
	public void closeFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}

}
