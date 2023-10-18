package com.nagarro.assignment3.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.assignment3.entities.Login;


/**
 * LoginDao to check username and password
 * @author komalsingh01
 *
 */
public class LoginDao {
	
	/**
	 * method to check username and password
	 * @param uname
	 * @param password
	 * @return Boolean value
	 */
	public Boolean checkUser(String uname, String password) {
		Configuration cfg  = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
      
		
		Login login = new Login();
		
		Query query=session.createQuery("from Login where name=:username and password=:password");
	    query.setParameter("username", uname);
	    query.setParameter("password", password);
	    
        login= (Login) ((org.hibernate.query.Query) query).uniqueResult();
        
		session.close();
        
	    if(login!=null) {
	       return true;
	    }
		
		return false;
	}

}
