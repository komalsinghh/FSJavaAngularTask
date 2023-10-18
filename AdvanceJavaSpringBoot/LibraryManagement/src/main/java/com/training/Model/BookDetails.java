package com.training.Model;

import javax.persistence.Id;

import javax.persistence.Entity;
import java.util.Date;
//@author komalsingh01
@Entity
public class BookDetails {

	@Id
	private int bookCode;
	private String bookName;
	private String bookAuthor;
	private String date;

	@Override
	public String toString() {
		return "BookDetails [bookCode=" + bookCode + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", date="
				+ date + "]";
	}

	public BookDetails() {
		super();
	}

	public BookDetails(int bookCode, String bookName, String bookAuthor) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {

		this.date = date;
	}

}
