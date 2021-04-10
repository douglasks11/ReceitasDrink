package br.com.itviclabs.gateway.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itviclabs.gateway.dto.JwtTokenResponse;
import br.com.itviclabs.gateway.dto.UserRequest;
import br.com.itviclabs.gateway.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationEndpoint {

	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping
	public JwtTokenResponse getAuthorizationToken(@RequestBody @Valid UserRequest userRequest) {
		return authenticationService.getAuthorizationToken(userRequest);
	}
	
	
}
