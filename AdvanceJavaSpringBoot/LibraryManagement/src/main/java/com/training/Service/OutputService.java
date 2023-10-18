package com.training.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.training.Model.BookDetails;

/**
 * Service for outputcontroller
 * @author komalsingh01
 *
 */
@Service
public class OutputService {

	/**
	 * Method for book list
	 * @param model
	 * @return
	 */
	public ModelAndView bookList(ModelAndView model) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		ResponseEntity<List<BookDetails>> responseEntity = restTemplate.exchange("http://localhost:8180/getBookDetails", HttpMethod.GET, null, new ParameterizedTypeReference<List<BookDetails>>() {});
		List<BookDetails> books = responseEntity.getBody();
		System.out.println(books);
		model.addObject("book_list", books);
		model.setViewName("result.jsp");
		return model;
	}

	/**
	 * Service to delete data from database.
	 * @param code
	 * @param model
	 * @return
	 */
	public String deleteBook(int code, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<BookDetails> entity = new HttpEntity<BookDetails>(headers);
	    try {
	        restTemplate.exchange("http://localhost:8180/deleteBookDetails/"+code, HttpMethod.DELETE, entity, String.class);
	    } catch (HttpClientErrorException ex) {
	        String message = ex.getResponseBodyAsString();
	        System.out.println(message);
	    }
		return "redirect:result";
	}

	/**
	 * add book to the table
	 * @param book
	 * @param model
	 * @return
	 */
	public String addBook(BookDetails book, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<BookDetails> entity = new HttpEntity<BookDetails>(book,headers);
	    restTemplate.exchange("http://localhost:8180/getBookDetails", HttpMethod.POST, entity, BookDetails.class);
		return "redirect:result";
	}

	/**
	 * Service to Edit go to edit book page.
	 * @param code
	 * @param model
	 * @return
	 */
	public String editBook(int code, Model model) {

		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		ResponseEntity<BookDetails> responseEntity = restTemplate.exchange("http://localhost:8180/getBookDetails/"+code, HttpMethod.GET, null, BookDetails.class);
		BookDetails books = responseEntity.getBody();
		model.addAttribute("book", books);
		System.out.println(books);
		return "edit.jsp";
	
	}

	public String updateBook(BookDetails book, Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<BookDetails> entity = new HttpEntity<BookDetails>(book,headers);
	    restTemplate.exchange("http://localhost:8180/update/"+book.getBookCode(), HttpMethod.PUT, entity, BookDetails.class);
		return "redirect:bookList";
		
	}

	public String editBook(BookDetails book, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<BookDetails> entity = new HttpEntity<BookDetails>(book,headers);
	    restTemplate.exchange("http://localhost:8180/update/"+book.getBookCode(), HttpMethod.PUT, entity, BookDetails.class);
		return "redirect:bookList";
	}
	
	

}
