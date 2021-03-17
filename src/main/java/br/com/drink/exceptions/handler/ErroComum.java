package br.com.drink.exceptions.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErroComum {

	private String code;
	private String message;

}
