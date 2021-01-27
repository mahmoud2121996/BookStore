package com.example.testProject.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.testProject.CustomRequest.SignInRequest;
import com.example.testProject.CustomResponse.SignInResponse;
import com.example.testProject.DTO.EndUser;
import com.example.testProject.Services.EndUserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:3000")
public class EndUserController {

	@Autowired
	private EndUserService endUserService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@Valid @RequestBody EndUser user) throws Exception {
		return ResponseEntity.ok(endUserService.save(user));
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public SignInResponse saveUser(@Valid @RequestBody SignInRequest user) throws Exception {
		String JwtToken = endUserService.signIn(user);
		return new SignInResponse(JwtToken);
	}

}
