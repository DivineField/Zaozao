package app.service.impl;

import java.util.List;

import app.dao.BookDao;
import app.domain.Book;
import app.service.BookService;

public class BookServiceImpl implements BookService
{
	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}

	@Override
	public int addBook(Book book)
	{
		return (Integer) bookDao.save(book);
	}

	@Override
	public List<Book> getAllBooks()
	{
		return bookDao.findAll(Book.class);
	}

	@Override
	public void deleteBook(int id)
	{
		bookDao.delete(Book.class, id);
	}
}
