package com.nagarro.advancejava.assignment2.dao;

import java.util.List;

import com.nagarro.advancejava.assignment2.entities.TshirtsData;

/**
 * @author komalsingh01
 *
 */
public interface SearchTshirtsDao {
	
	/**
	 * Gets the list of T shirt.
	 *
	 * @return the list of T shirt
	 */
	List<TshirtsData> getListOfTShirt();
}
