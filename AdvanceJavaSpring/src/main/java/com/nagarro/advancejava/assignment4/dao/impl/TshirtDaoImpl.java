package com.nagarro.advancejava.assignment4.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.advancejava.assignment4.dao.TshirtDao;
import com.nagarro.advancejava.assignment4.entities.TshirtData;
import com.nagarro.advancejava.assignment4.entities.User;

/**
 * The Class TshirtDaoImpl.
 */
@Repository
public class TshirtDaoImpl implements TshirtDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Insert tshirt.
	 *
	 * @param tshirtList the tshirt list
	 */
	@Override
	public void insertTshirt(List<TshirtData> tshirtList) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for (TshirtData tShirt : tshirtList) {
			session.save(tShirt);
		}
		tx.commit();
		session.close();
	}

	/**
	 * Search tshirt in DB.
	 *
	 * @param tshirtColor    the tshirt color
	 * @param tshirtGender   the tshirt gender
	 * @param tshirtSize     the tshirt size
	 * @param userPreference the user preference
	 * @return the list
	 */
	@Override
	public List<TshirtData> searchTshirtInDB(String tshirtColor, String tshirtGender, String tshirtSize,
			String userPreference) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "";
		if (userPreference.equals("Rating")) {
			hql = "from TshirtData where tshirtColor=:c and tshirtGender=:g and tshirtSize=:s"
					+ " order by tshirtRating";
		} else if (userPreference.equals("Price")) {
			hql = "from TshirtData where tshirtColor=:c and tshirtGender=:g and tshirtSize=:s"
					+ " order by tshirtPrice desc";
		}
		Query<TshirtData> query = session.createQuery(hql);
		query.setParameter("c", tshirtColor);
		query.setParameter("g", tshirtGender);
		query.setParameter("s", tshirtSize);
		List<TshirtData> tshirtList = query.list();
		tx.commit();
		session.close();
		return tshirtList;
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
