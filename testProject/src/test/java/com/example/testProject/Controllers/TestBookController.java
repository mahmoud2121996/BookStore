package com.example.testProject.Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.testProject.DTO.Book;
import com.example.testProject.Services.BookService;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

@WebMvcTest(BookController.class)
public class TestBookController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	// get all

	@Test
	void test_GetAllBooks_StatusIsOk() throws Exception {
		List<Book> bookList = new ArrayList<>();

		Mockito.when(bookService.getAllBooks()).thenReturn(bookList);

		mockMvc.perform(get("/book")).andExpect(status().isOk());

	}

	// get by id

	@Test
	void test_getBookById_StatusIsNotFound() throws Exception {
		Optional<Book> book = Optional.empty();
		Mockito.when(bookService.getBookById((long) 1)).thenReturn(book);
		mockMvc.perform(get("/book/1")).andExpect(status().isNotFound());
	}

	@Test
	void test_getBookById_StatusIsOk() throws Exception {
		Optional<Book> book = Optional.of(new Book("course one", "mahmoud", 300));
		Mockito.when(bookService.getBookById((long) 1)).thenReturn(book);
		mockMvc.perform(get("/book/1")).andExpect(status().isOk());
	}

	// not done yet
	@Test
	void test_getBookById_ReturnJsonPayLoad() throws Exception {
		Optional<Book> book = Optional.of(new Book("course one", "mahmoud", 300));
		Mockito.when(bookService.getBookById((long) 1)).thenReturn(book);
		mockMvc.perform(get("/book/1")).andExpect(status().isOk());
	}

	// create new book
	@Test
	void test_createNewBook_StatusIsCreated() throws Exception {
		Book book = new Book("course one", "mahmoud", 300);

		Mockito.when(bookService.createNewBook(book)).thenReturn(book);

		String bookToJson = "{\"bookName\" : \"" + book.getBookName() + "\",\"authorName\" : \"" + book.getAuthorName()
				+ "\",\"pages\":\"" + book.getPages() + "\"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/book").accept(MediaType.APPLICATION_JSON)
				.content(bookToJson).contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isCreated());
	}

	// not done yet
	@Test
	void test_createNewBook_ReturnJsonPayload() throws Exception {
		Book book = new Book("course one", "mahmoud", 300);
		book.setId((long) 1);

		Mockito.when(bookService.createNewBook(book)).thenReturn(book);

		String bookToJson = "{\"bookName\" : \"" + book.getBookName() + "\",\"authorName\" : \"" + book.getAuthorName()
				+ "\",\"pages\":\"" + book.getPages() + "\"}";

		String returnedJsonBook = "{\"id\" :" + book.getId() + ",\"bookName\" : \"" + book.getBookName()
				+ "\",\"authorName\" : \"" + book.getAuthorName() + "\",\"pages\":" + book.getPages() + "}";

		System.out.println("json response is  : " + returnedJsonBook);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/book").accept(MediaType.APPLICATION_JSON)
				.content(bookToJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(returnedJsonBook, result.getResponse().getContentAsString(), false);
	}

	// update book

	// delete book

	@Test
	void test_deleteBookById_StatusIsNoContent() throws Exception {

		Mockito.when(bookService.deleteBook((long) 1)).thenReturn(true);
		mockMvc.perform(delete("/book/1")).andExpect(status().isNoContent());
	}

	@Test
	void test_deleteBookById_StatusIsNotFound() throws Exception {

		Mockito.when(bookService.deleteBook((long) 14)).thenReturn(false);
		mockMvc.perform(delete("/book/14")).andExpect(status().isNotFound());
	}
}
