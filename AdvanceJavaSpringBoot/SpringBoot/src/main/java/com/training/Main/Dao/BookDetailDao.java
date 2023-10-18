package com.training.Main.Dao;

import com.training.Main.Model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailDao extends JpaRepository<BookDetails,Integer> {

}
