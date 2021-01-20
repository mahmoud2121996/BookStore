package com.example.testProject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testProject.DTO.Book;
import com.example.testProject.DTO.BookRepository;
import com.example.testProject.Exceptions.ResourceNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book;
		} else
			throw new ResourceNotFoundException("the book you try to get does not exists");
	}

	@Override
	public Book createNewBook(Book newBook) {
		return bookRepository.save(newBook);
	}

	@Override
	public Book updateBook(Book updatedBook, Long id) {
		Optional<Book> _book = bookRepository.findById(id);

		if (_book.isPresent()) {
			Book book = _book.get();
			book.setName(updatedBook.getName());
			book.setPages(updatedBook.getPages());
			return bookRepository.save(book);
		} else
			throw new ResourceNotFoundException("the book you try to update does not exists");

	}

	@Override
	public void deleteBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			bookRepository.deleteById(id);
		} else
			throw new ResourceNotFoundException("the book you try to delete does not exists");
	}
}
