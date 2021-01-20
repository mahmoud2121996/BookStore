package com.example.testProject.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.testProject.DTO.*;
import com.example.testProject.Services.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Book> getAllBook() {
		return bookService.getAllBooks();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Optional<Book> getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public Book createNewBook(@RequestBody Book newBook) {
		return bookService.createNewBook(newBook);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Book UpdateBook(@RequestBody Book updatedBook, @PathVariable Long id) {
		return bookService.updateBook(updatedBook, id);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void UpdateBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}
}
