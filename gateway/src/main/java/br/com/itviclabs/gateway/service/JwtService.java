package br.com.itviclabs.gateway.service;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.itviclabs.gateway.dto.JwtTokenResponse;

@Service
public class JwtService {

	private final static String ISSUER = "ReceitasDrinksSecurityGateway";
	
	public JwtTokenResponse generateToken(Authentication authentication) {
		return JwtTokenResponse.builder()
			.authenticationToken(JWT.create()
					.withIssuer(ISSUER)
					.withIssuedAt(new Date())
					.withSubject(authentication.getPrincipal().toString()).sign(Algorithm.none()))
			.build();
	}

}
