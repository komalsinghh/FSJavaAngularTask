/**
 * 
 */
package com.nagarro.advancejava.assignment4.service;

import java.util.List;

import com.nagarro.advancejava.assignment4.entities.TshirtData;

/**
 * The Interface SearchService.
 *
 * @author komalsingh01
 */
public interface SearchService {

	/**
	 * Search tshirt.
	 *
	 * @param tshirtColor    the tshirt color
	 * @param tshirtGender   the tshirt gender
	 * @param tshirtSize     the tshirt size
	 * @param userPreference the user preference
	 * @return the list
	 */
	public abstract List<TshirtData> searchTshirt(String tshirtColor, String tshirtGender, String tshirtSize,
			String userPreference);

}
