package br.com.drink.dto;

import java.io.Serializable;
import java.util.List;

import br.com.drink.entity.DrinkEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DrinkResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<IngredientesResponse> ingredientes;
	private String nome;
	private String modoPreparo;
	
	public DrinkResponse toEntity(DrinkEntity entity) {
		return DrinkResponse.builder()
					.id(this.getId())
					.ingredientes(this.getIngredientes())
					.modoPreparo(this.getModoPreparo())
					.nome(this.getNome())
					.build();
	}
}
