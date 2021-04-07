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
public class IngredientesRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ingrediente;
	private String quantidade;
	private String dosagem;
	
	public IngredientesEntity toEntity() {
		return IngredientesEntity.builder()
					.ingrediente(this.getIngrediente())
					.quantidade(this.getQuantidade())
					.dosagem(this.getDosagem())
					.build();
	}
}
