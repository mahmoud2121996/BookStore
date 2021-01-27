package com.example.testProject.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class EndUser {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "UserName Name is Required")
	private String userName;

	@Email(message = "Email Must Be Valid")
	@NotBlank(message = "Email Name is Required")
	private String email;

	@NotBlank(message = "Password Name is Required")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
