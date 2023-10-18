package com.training.Main.Service;

import com.training.Main.Dao.BookDetailDao;
import com.training.Main.Model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookDetailsServiceImpl implements BookDetailsService {

    @Autowired
    BookDetailDao bookDetailsDao;

    @Override
    public List<BookDetails> getAllBookDetails() {

        return bookDetailsDao.findAll();
    }

    @Override
    public BookDetails getBookDetails(int bookCode) {
        return bookDetailsDao.findById(bookCode).get();
    }

    @Override
    public BookDetails addBookDetails(BookDetails bookDetails1) {
        bookDetailsDao.save(bookDetails1);
        return bookDetails1;
    }

    @Override
    public BookDetails updateBookDetails(BookDetails bookDetails1, int parseInt) {
        return bookDetailsDao.save(bookDetails1);
    }

    @Override
    public void deleteBookDetails(int id) {
        BookDetails bookDetails = bookDetailsDao.getReferenceById(id);
        bookDetailsDao.delete(bookDetails);
    }
}
