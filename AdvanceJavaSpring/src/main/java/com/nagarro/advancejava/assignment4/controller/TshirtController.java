/**
 * 
 */
package com.nagarro.advancejava.assignment4.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advancejava.assignment4.entities.TshirtData;
import com.nagarro.advancejava.assignment4.service.LoginService;
import com.nagarro.advancejava.assignment4.service.SearchService;
import com.nagarro.advancejava.assignment4.service.impl.LoginServiceImpl;
import com.nagarro.advancejava.assignment4.service.impl.SearchServiceImpl;

/**
 * The Class TshirtController.
 *
 * @author komalsingh01
 */
@Controller
public class TshirtController {

	/**
	 * Handle form.
	 *
	 * @param userName     the user name
	 * @param userPassword the user password
	 * @return the string
	 */
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@RequestParam("username") String userName,
			@RequestParam("userpassword") String userPassword) {
		System.out.println(userName + " " + userPassword);
		LoginService login = new LoginServiceImpl();
		if (login.checkUser(userName, userPassword)) {
			return "tshirt";
		}
		return "index";
	}

	/**
	 * Search tshirt.
	 *
	 * @param tshirtColor    the tshirt color
	 * @param tshirtGender   the tshirt gender
	 * @param tshirtSize     the tshirt size
	 * @param userPreference the user preference
	 * @return the model and view
	 */
	@RequestMapping(path = "/search")
	public ModelAndView searchTshirt(@RequestParam("color") String tshirtColor,
			@RequestParam("gender") String tshirtGender, @RequestParam("size") String tshirtSize,
			@RequestParam("preference") String userPreference) {
		ModelAndView view = new ModelAndView();
		System.out.println(tshirtColor + " " + tshirtGender + " " + tshirtSize + " " + userPreference);
		SearchService searchTshirt = new SearchServiceImpl();
		List<TshirtData> tshirtList = searchTshirt.searchTshirt(tshirtColor, tshirtGender, tshirtSize, userPreference);
		view.addObject("tshirts", tshirtList);
		view.setViewName("tshirt");
		return view;
	}
}
