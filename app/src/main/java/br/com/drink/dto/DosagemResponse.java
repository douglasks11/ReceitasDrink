package br.com.drink.dto;

import java.io.Serializable;

import br.com.drink.entity.DosagemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DosagemResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tipo;
	
	public DosagemResponse(DosagemEntity entity) {
		this.id = entity.getId();
		this.tipo = entity.getTipo();
	}
}
