package com.springboot.book.jdbc.book.repository;

import java.util.List;
import com.springboot.book.jdbc.book.beans.Book;

public interface BookDao {
	int addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(int bookId);
	int updateBook(Book book);
	int deleteBook(int bookId);
	List<Book> searchBook(Object key, int bookId, double price, int year);
}
