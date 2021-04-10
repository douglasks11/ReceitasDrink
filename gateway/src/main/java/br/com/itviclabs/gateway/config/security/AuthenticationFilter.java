package br.com.itviclabs.gateway.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.itviclabs.gateway.entity.User;
import br.com.itviclabs.gateway.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AuthenticationFilter extends OncePerRequestFilter {

	//@Autowired
	//private AuthenticationService authenticationService;
	
	//@Autowired
	private JwtService jwtService;
	
	private UserRepository userRepository;
	
	public AuthenticationFilter(JwtService jwtService, UserRepository userRepository) {
		this.jwtService = jwtService;
		this.userRepository = userRepository;
	}
	
	public static final String AUTHORIZATION = "Authorization";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getAuthorizationToken(request);
		
		log.info("Authorization token: {} ", token);
		
		if (token != null && jwtService.isValidToken(token)) {
			
			authorize(token);
		}
		
		filterChain.doFilter(request, response);
	}

	protected String getAuthorizationToken(HttpServletRequest request) {
		String authorizationToken = request.getHeader(AUTHORIZATION);
		if (authorizationToken == null || authorizationToken.isEmpty() || ! authorizationToken.startsWith("Bearer")) {
			return null;
		}
		
		return authorizationToken.substring(7);
	}
	
	protected void authorize(String token) {
		String username = jwtService.getUsername(token);
		User user =  userRepository.findByUsername(username).get();
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
