package br.com.drink.dto;

import java.io.Serializable;

import br.com.drink.entity.IngredientesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class IngredientesResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String ingrediente;
	private String quantidade;
	private String dosagem;
	
	public IngredientesResponse(IngredientesEntity entity) {
		this.id = entity.getId();
		this.ingrediente = entity.getIngrediente();
		this.quantidade = entity.getQuantidade();
		this.dosagem = entity.getDosagem();
	}
}
