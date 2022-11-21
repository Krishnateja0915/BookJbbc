package com.springboot.book.jdbc.book.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.book.jdbc.book.beans.Book;
import com.springboot.book.jdbc.book.repository.BookDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao dao;
	
	@PostMapping
	public int addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public Book getBookById(int bookId) {
		return dao.getBookById(bookId);
	}

	@Override
	public int updateBook(Book book) {
		return dao.updateBook(book);
	}

	@Override
	public int deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public List<Book> searchByBook(Object keyword, int bookId, double price, int year) {
		return dao.searchBook(keyword, bookId, price, year);
	}

}
