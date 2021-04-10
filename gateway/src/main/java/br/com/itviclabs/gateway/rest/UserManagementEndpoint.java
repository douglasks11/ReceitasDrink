package br.com.itviclabs.gateway.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itviclabs.gateway.dto.CreateUserRequest;
import br.com.itviclabs.gateway.dto.UserResponse;
import br.com.itviclabs.gateway.service.UserManagementService;

@RestController
@RequestMapping("/users-management")
@CrossOrigin("*")
public class UserManagementEndpoint {
	
	@Autowired
	private UserManagementService userManagementService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody @Valid CreateUserRequest request) {
		userManagementService.createUser(request);
	}
	
	@GetMapping
	public List<UserResponse> findAll(){
		return userManagementService.findAll();
	}
}
