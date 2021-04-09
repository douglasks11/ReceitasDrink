package br.com.itviclabs.gateway.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.itviclabs.gateway.entity.Role;
import br.com.itviclabs.gateway.entity.User;
import br.com.itviclabs.gateway.repository.UserRepository;

@Configuration
public class SetupAdmin implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		userRepo.save(User.builder().username("victor").password(new BCryptPasswordEncoder().encode("1234"))
				.roles(Arrays.asList(Role.builder().name("USER").build())
				).build());
	}

}
