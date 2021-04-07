package br.com.drink.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DosagemRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank	
	private String tipo;
}
