/**
 * 
 */
package com.nagarro.advancejava.assignment4.dao;

import java.util.List;

import com.nagarro.advancejava.assignment4.entities.TshirtData;

/**
 * The Interface TshirtDao.
 *
 * @author komalsingh01
 */
public interface TshirtDao {

	/**
	 * Insert tshirt.
	 *
	 * @param tshirtList the tshirt list
	 */
	public abstract void insertTshirt(List<TshirtData> tshirtList);

	/**
	 * Search tshirt in DB.
	 *
	 * @param tshirtColor    the tshirt color
	 * @param tshirtGender   the tshirt gender
	 * @param tshirtSize     the tshirt size
	 * @param userPreference the user preference
	 * @return the list
	 */
	public abstract List<TshirtData> searchTshirtInDB(String tshirtColor, String tshirtGender, String tshirtSize,
			String userPreference);
}
