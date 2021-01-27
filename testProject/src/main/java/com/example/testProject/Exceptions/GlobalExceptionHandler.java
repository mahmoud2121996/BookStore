package com.example.testProject.Exceptions;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.testProject.CustomResponse.CustomResponse;
import com.example.testProject.CustomResponse.ValidationErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public CustomResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
		return new CustomResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

		List<String> errors = new ArrayList<String>();
		exception.getFieldErrors().forEach((error) -> {
			errors.add(error.getDefaultMessage());
		});

		return new ValidationErrorResponse("validation error...", HttpStatus.BAD_REQUEST.value(), errors);
	}

	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public CustomResponse handleAuthException(AuthenticationException exception) {
		return new CustomResponse("username or password is invalid...", HttpStatus.UNAUTHORIZED.value());
	}
}
