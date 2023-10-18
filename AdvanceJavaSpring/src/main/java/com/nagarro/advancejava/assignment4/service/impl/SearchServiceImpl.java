/**
 * 
 */
package com.nagarro.advancejava.assignment4.service.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nagarro.advancejava.assignment4.dao.impl.TshirtDaoImpl;
import com.nagarro.advancejava.assignment4.entities.TshirtData;
import com.nagarro.advancejava.assignment4.service.SearchService;

/**
 * The Class SearchServiceImpl.
 *
 * @author komalsingh01
 */
public class SearchServiceImpl implements SearchService {

	/** The ctx. */
	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

	/** The tshirt dao. */
	TshirtDaoImpl tshirtDao = ctx.getBean(TshirtDaoImpl.class);

	/**
	 * Search tshirt.
	 *
	 * @param tshirtColor    the tshirt color
	 * @param tshirtGender   the tshirt gender
	 * @param tshirtSize     the tshirt size
	 * @param userPreference the user preference
	 * @return the list
	 */
	@Override
	public List<TshirtData> searchTshirt(String tshirtColor, String tshirtGender, String tshirtSize,
			String userPreference) {
		List<TshirtData> tshirts = tshirtDao.searchTshirtInDB(tshirtColor, tshirtGender, tshirtSize, userPreference);
		return tshirts;
	}

}
