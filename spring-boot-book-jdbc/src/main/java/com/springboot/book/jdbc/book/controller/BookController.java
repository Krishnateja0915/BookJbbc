package com.springboot.book.jdbc.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.book.jdbc.book.beans.Book;
import com.springboot.book.jdbc.book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService service;
	
	@PostMapping
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		int rows = service.addBook(book);
		return new ResponseEntity<String>("inserted " + rows,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> bookList = service.getAllBooks();
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int bookId) {
		Book book = service.getBookById(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		int rows = service.updateBook(book);
		return new ResponseEntity<String>("updated " + rows, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int bookId) {
		int rows = service.deleteBook(bookId);
		return new ResponseEntity<String>("book deleted " + rows, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBook(@RequestParam("keyword") Object key, @RequestParam("id") int id,
			@RequestParam("price") double price, @RequestParam("year") int year) {
		List<Book> books = service.searchByBook(key, id, price, year);
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
}
