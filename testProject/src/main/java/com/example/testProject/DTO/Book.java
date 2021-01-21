package com.example.testProject.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Book")
public class Book {

	@Id
	@GeneratedValue
	Long id;

	@NotBlank(message = "Book Name is Required")
	String bookName;

	@NotBlank(message = "Author Name is Required")
	String authorName;

	@NotNull(message = "Book Pages is Required")
	@Min(value = 200, message = "Book Pages Must Be Atleast 200 Pages")
	int pages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
