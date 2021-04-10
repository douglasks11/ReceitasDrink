package br.com.itviclabs.gateway.exception;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InvalidUserRolesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> roles;
	
	public InvalidUserRolesException(String msg) {
		super(msg);
	}
	
	public InvalidUserRolesException(String msg, List<String> roles) {
		super(msg);
		this.roles = roles;
	}
}
