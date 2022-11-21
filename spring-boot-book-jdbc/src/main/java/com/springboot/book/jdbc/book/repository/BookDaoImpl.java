package com.springboot.book.jdbc.book.repository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.book.jdbc.book.beans.Book;
import com.springboot.book.jdbc.bookutils.DBQueries;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	NamedParameterJdbcTemplate template;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int addBook(Book book) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", book.getBookId());
		params.put("title", book.getTitle());
		params.put("author", book.getAuthor());
		params.put("price", book.getPrice());
		params.put("publications", book.getPublications());
		params.put("year", book.getYear());
		int rows = template.update(DBQueries.ADDBOOK, params);
		return rows;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = jdbcTemplate.query(DBQueries.GETALLBOOKS, (ResultSet rs, int rowNum) -> {
			Book book = new Book();
			book.setBookId(rs.getInt(1));
			book.setTitle(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getDouble(4));
			book.setPublications(rs.getString(5));
			book.setYear(rs.getInt(6));
			return book;
		});
		return bookList;
	}

	@Override
	public Book getBookById(int bookId) {
		Book book = jdbcTemplate.queryForObject(DBQueries.GETBOOKBYID, new BeanPropertyRowMapper<Book>(Book.class), bookId);
		return book;
	}

	@Override
	public int updateBook(Book book) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("title", book.getTitle());
		params.put("author", book.getAuthor());
		params.put("price", book.getPrice());
		params.put("publications", book.getPublications());
		params.put("year", book.getYear());
		params.put("bookId", book.getBookId());
		int rows = template.update(DBQueries.UPDATEBOOK, params);
		return rows;
	}

	@Override
	public int deleteBook(int bookId) {
		int rows = jdbcTemplate.update(DBQueries.DELETEBOOKBYID, bookId);
		return rows;
	}

	@Override
	public List<Book> searchBook(Object key, int bookId, double price, int year) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("key", key);
		params.addValue("bookId", bookId);
		params.addValue("price", price);
		params.addValue("year", year);
		List<Book> books = template.query(DBQueries.SEARCHBOOK, params, (ResultSet rs, int rowNum) -> {
			Book book = new Book();
			book.setBookId(rs.getInt(1));
			book.setTitle(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getDouble(4));
			book.setPublications(rs.getString(5));
			book.setYear(rs.getInt(6));
			return book;
		});
		return books;
	}

}
