package com.example.testProject.CustomResponse;

public class SignInResponse {
	private String JwtToken;

	public SignInResponse(String jwtToken) {
		JwtToken = jwtToken;
	}

	public String getJwtToken() {
		return JwtToken;
	}

	public void setJwtToken(String jwtToken) {
		JwtToken = jwtToken;
	}

}
