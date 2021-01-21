package com.example.testProject.CustomResponse;

import java.util.List;

public class ValidationErrorResponse {
	private String message;
	private int statusCode;
	private List<String> errorList;

	public ValidationErrorResponse(String message, int statusCode, List<String> errorList) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.errorList = errorList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

}
