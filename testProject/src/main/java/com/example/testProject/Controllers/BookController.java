package com.example.testProject.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.testProject.DTO.*;
import com.example.testProject.Services.BookService;

@RestController
@RequestMapping(value = "/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Optional<Book> book = bookService.getBookById(id);
		if (book.isPresent()) {
			return new ResponseEntity<>(book.get(), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book createNewBook(@Valid @RequestBody Book newBook) {
		return bookService.createNewBook(newBook);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> UpdateBook(@Valid @RequestBody Book updatedBook, @PathVariable Long id) {
		Book newUpdatedBook = bookService.updateBook(updatedBook, id);
		if (newUpdatedBook == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
		boolean result = bookService.deleteBook(id);
		if (result == true) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
