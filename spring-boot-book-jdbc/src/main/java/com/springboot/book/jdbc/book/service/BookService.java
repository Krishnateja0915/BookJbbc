package com.springboot.book.jdbc.book.service;

import java.util.List;
import com.springboot.book.jdbc.book.beans.Book;

public interface BookService {
	int addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(int bookId);
	int updateBook(Book book);
	int deleteBook(int bookId);
	List<Book> searchByBook(Object keyword, int bookId, double price, int year);
}
