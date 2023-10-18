package com.training.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.Model.BookDetails;
import com.training.Service.OutputService;


/**
 * Class for result.jsp page
 * @author komalsingh01
 *
 */
@Controller
public class OutputController {
	
	@Autowired
	OutputService outputService;
	

	/**
	 * method mapped with result.jsp to show
	 * @param request
	 * @param response
	 * @return result.jsp
	 */
	@RequestMapping("result")
	public ModelAndView bookList(ModelAndView model) {
		
		return outputService.bookList(model);
	}
	
	/**
	 * Mapping to delete data from table
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("code") int code, Model model) {
		
		return outputService.deleteBook(code, model);
	}
	
	/**
	 * Mapping to add data into the table
	 * @param book
	 * @param model
	 * @return
	 */
	@RequestMapping("/addBookForm")
	public String addBook(@ModelAttribute BookDetails book, Model model) {
		
		return outputService.addBook(book,model);

	}
	
	/**
	 * Mapping to go to edit page
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("/editBook")
	public String editBook(@RequestParam("code") int code, Model model) {
		return outputService.editBook(code,model);
	}
	
	/**
	 * Mapping to send updated details to the database
	 * @param book
	 * @param model
	 * @return
	 */
	@RequestMapping("/editBookForm")
	public String editBook(@ModelAttribute BookDetails book, Model model) {
		
		return outputService.editBook(book, model);

	}
}
