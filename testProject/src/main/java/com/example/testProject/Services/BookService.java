package com.example.testProject.Services;

import java.util.List;
import java.util.Optional;

import com.example.testProject.DTO.Book;

public interface BookService {
	public List<Book> getAllBooks();

	public Optional<Book> getBookById(Long Id);

	public Book createNewBook(Book newBook);

	public Book updateBook(Book updatedBook, Long Id);

	public void deleteBook(Long id);
}
