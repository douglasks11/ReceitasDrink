package br.com.itviclabs.gateway.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
	@PostMapping
	public JwtTokenResponse getAuthorizationToken(@RequestBody @Valid UserRequest userRequest) {
		return authenticationService.getAuthorizationToken(userRequest);
	}
}
