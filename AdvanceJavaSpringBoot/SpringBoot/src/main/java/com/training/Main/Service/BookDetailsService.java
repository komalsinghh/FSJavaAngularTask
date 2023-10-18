package com.training.Main.Service;

import com.training.Main.Model.BookDetails;

import java.util.List;

public interface BookDetailsService {

    public List<BookDetails> getAllBookDetails();

   public BookDetails getBookDetails(int bookCode);

    public BookDetails addBookDetails(BookDetails bookDetails);

    public BookDetails updateBookDetails(BookDetails bookDetails, int parseInt);

    public void deleteBookDetails(int id);
}
