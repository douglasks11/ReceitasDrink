package br.com.itviclabs.gateway.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class UserRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 866643508523711010L;
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
}
