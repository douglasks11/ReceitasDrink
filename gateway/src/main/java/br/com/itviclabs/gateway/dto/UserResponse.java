package br.com.itviclabs.gateway.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.itviclabs.gateway.entity.Role;
import br.com.itviclabs.gateway.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserResponse(User user) {
		this.username = user.getUsername();
		this.roles = user.getRoles()
						.stream()
						.map(Role::getName)
						.collect(Collectors.toList());
	}
	
	private String username;
	private List<String> roles;
	
}
