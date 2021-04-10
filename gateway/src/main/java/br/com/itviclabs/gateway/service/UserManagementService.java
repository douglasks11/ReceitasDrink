package br.com.itviclabs.gateway.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.itviclabs.gateway.dto.CreateUserRequest;
import br.com.itviclabs.gateway.dto.UserResponse;
import br.com.itviclabs.gateway.entity.User;
import br.com.itviclabs.gateway.repository.RoleRepository;
import br.com.itviclabs.gateway.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserManagementService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void createUser(CreateUserRequest request) {
		
		log.info("Request to create a User received! Payload: {}", request.toString());
						
		userRepository.save(User.builder()
							.username(request.getUsername())
							.password(encoder.encode(request.getPassword()))
							.roles(Arrays.asList(roleRepository.findByName("USER")))
							.build()
							);
	}

	public List<UserResponse> findAll() {
		return userRepository.findAll()
					.stream()
					.map(UserResponse::new)
					.collect(Collectors.toList());
	}

}
