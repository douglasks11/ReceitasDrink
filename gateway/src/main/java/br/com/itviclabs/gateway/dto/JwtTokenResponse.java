package br.com.itviclabs.gateway.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JwtTokenResponse implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1477792023996344862L;

	private String authenticationToken;
}
