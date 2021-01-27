package com.example.testProject.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.testProject.CustomRequest.SignInRequest;
import com.example.testProject.DTO.EndUser;
import com.example.testProject.DTO.EndUserRepository;
import com.example.testProject.security.JwtUtil;

@Service
public class EndUserService implements UserDetailsService {

	@Autowired
	private EndUserRepository endUserRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		EndUser user = endUserRepository.findByUserName(username);

		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}

	public EndUser save(EndUser user) {
		EndUser newUser = new EndUser();
		newUser.setUserName(user.getUserName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return endUserRepository.save(newUser);
	}

	public String signIn(SignInRequest user) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		final UserDetails userDetails = loadUserByUsername(user.getUserName());

		String jwt = jwtTokenUtil.generateToken(userDetails);

		return jwt;
	}

}
