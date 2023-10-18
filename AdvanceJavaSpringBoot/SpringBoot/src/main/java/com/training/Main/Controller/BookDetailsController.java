package com.training.Main.Controller;

import com.training.Main.Model.BookDetails;
import com.training.Main.Service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Rest controller for API's
 */
@RestController
public class BookDetailsController {


	@Autowired
	private BookDetailsService bookDetailsService;

	/**
	 *Get book Details from Database.
	 */
	@GetMapping("/getBookDetails")
	public List<BookDetails> getAllBookDetails(){
		return this.bookDetailsService.getAllBookDetails();
	}

	/**
	 *Get book Details from Database using id.
	 */
	@GetMapping("/getBookDetails/{bookCode}")
	public BookDetails getBookDetails(@PathVariable String bookCode){
		return this.bookDetailsService.getBookDetails(Integer.parseInt(bookCode));
	}

	/**
	 *Get book Details from Database.
	 */
	@PostMapping("/getBookDetails")
	public BookDetails addBookDetails(@RequestBody BookDetails bookDetails){
		return this.bookDetailsService.addBookDetails(bookDetails);
	}

	/**
	 *Update book Details from Database.
	 */
	@PostMapping("/update/{id}")
	public BookDetails updateBookDetails(@RequestBody BookDetails bookDetails, @PathVariable String id){
		return this.bookDetailsService.updateBookDetails(bookDetails,Integer.parseInt(id));
	}

	/**
	 *Delete book Details from Database.
	 */
	@DeleteMapping("/deleteBookDetails/{id}")
	public ResponseEntity<HttpStatus> deleteBookDetails(@PathVariable String id){
		try {
			this.bookDetailsService.deleteBookDetails(Integer.parseInt(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e){
			return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
