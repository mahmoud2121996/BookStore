package com.example.testProject.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.testProject.CustomResponse.CustomResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public CustomResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
		return new CustomResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
	}
}
