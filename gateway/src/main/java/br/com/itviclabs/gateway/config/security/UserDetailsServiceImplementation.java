package br.com.itviclabs.gateway.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.itviclabs.gateway.exception.UnauthorizedException;
import br.com.itviclabs.gateway.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserDetailsServiceImplementation implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("UserDetailsServiceImplementation called! searching for username: {}", username);
		return userRepository.findByUsername(username).orElseThrow(() -> new UnauthorizedException("User doesn't exist"));
	}

}
