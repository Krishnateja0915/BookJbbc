package com.springboot.book.jdbc.bookutils;

public class DBQueries {
	public static final String ADDBOOK = "insert into book values(:bookId,:title,:author,:price,:publications,:year)";
	public static final String GETALLBOOKS = "select * from book";
	public static final String GETBOOKBYID = "select * from book where bookId = ?";
	public static final String UPDATEBOOK = "update book set title=:title,author=:author,price=:price,"
			+ "publications=:publications,year=:year where bookId=:bookId";
	public static final String DELETEBOOKBYID = "delete from book where bookId=?";
	public static final String SEARCHBOOK = "select * from book where bookId = :bookId or title like concat('%',:key,'%') or author like concat('%',:key,'%') or "
			+ "price = :price or publications like concat('%',:key,'%') or year = :year";
}
