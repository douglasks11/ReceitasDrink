package br.com.itviclabs.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.itviclabs.gateway.config.security.JwtService;
import br.com.itviclabs.gateway.dto.JwtTokenResponse;
import br.com.itviclabs.gateway.dto.UserRequest;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	
	public JwtTokenResponse getAuthorizationToken(UserRequest userRequest) {
		
		log.info("Authentication request received! User payload: {}", userRequest.toString());
		
		return authenticate( new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
	}
	
	protected JwtTokenResponse authenticate (Authentication authentication) {
		
		authenticationManager.authenticate(authentication); //throws UserNotFoundException if bad credentials.
		
		return jwtService.generateToken(authentication);
		
	}
}
