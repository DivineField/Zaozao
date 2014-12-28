package app.action;

import java.util.List;

import app.domain.Book;
import app.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport
{
	private BookService bookService;
	// 依赖注入BookService组件必须的setter方法。
	// 该方法的方法名要与BookService的配置id对应
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	private Book book;
	private List<Book> books;
	private int id;
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
	
	public List<Book> getBooks()
	{
		return books;
	}
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	// 处理添加图书的add()方法
	public String add()
	{
		if(book != null)
		{
			// 调用业务逻辑组件的addBook()方法来处理用户请求		
			int result = bookService.addBook(book);
			if(result > 0)
			{
				addActionMessage("Hi, add successfully.");
				return SUCCESS;
			}
		}
		addActionMessage("Hi, failed.");
		return INPUT;
	}
	public String list()
	{
		setBooks(bookService.getAllBooks());
		return SUCCESS;
	}
	public String delete()
	{
		bookService.deleteBook(id);
		return SUCCESS;
	}	
}
