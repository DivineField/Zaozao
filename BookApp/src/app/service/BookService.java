package app.service;

import java.util.List;

import app.domain.Book;

public interface BookService
{
	// 添加图书
	int addBook(Book book);

	List<Book> getAllBooks();
	
	void deleteBook(int id);
}
