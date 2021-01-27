package com.example.testProject.CustomRequest;

import javax.validation.constraints.NotBlank;

public class SignInRequest {

	@NotBlank(message = "you must enter a username")
	private String userName;

	@NotBlank(message = "you must enter a password")
	private String Password;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
