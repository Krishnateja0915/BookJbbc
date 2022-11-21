package com.springboot.book.jdbc.book.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import com.springboot.book.jdbc.book.beans.Book;
import com.springboot.book.jdbc.book.repository.BookDao;

@SpringBootTest
class BookTest {
	@Autowired
	BookDao dao;
	
	@Test
	public void testAddBook() {
		Book book = new Book();
		book.setBookId(303);
		book.setTitle("ORM with JPA");
		book.setAuthor("TaTa Mc");
		book.setYear(2015);
		book.setPrice(750);
		assertEquals(1,dao.addBook(book));
	}
	@Test
	public void testGetAllBooks() {
		List<Book> booklist = dao.getAllBooks();
		assertNotNull(booklist);
	}
	@Test
	public void testGetBookId() {
		Book book = dao.getBookById(303);
		assertNotNull(book);
	}
	
	@Test
	public void testDataAccessException() {
		Exception ex = assertThrows(DataAccessException.class, () -> {
			dao.getBookById(107);
		});
		String expected = "Incorrect result size: expected 1, actual 0";
		String actual = ex.getMessage();
		assertTrue(actual.contains(expected));
	}
}
