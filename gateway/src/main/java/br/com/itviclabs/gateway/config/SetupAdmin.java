package br.com.itviclabs.gateway.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.itviclabs.gateway.entity.Role;
import br.com.itviclabs.gateway.entity.User;
import br.com.itviclabs.gateway.repository.RoleRepository;
import br.com.itviclabs.gateway.repository.UserRepository;

@Configuration
public class SetupAdmin implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		roleRepo.save(Role.builder().name("USER").build());
		userRepo.save(User.builder().username("victor").password(new BCryptPasswordEncoder().encode("1234"))
				.roles(Arrays.asList(roleRepo.findById(1L).get())
				).build());
	}

}
