package br.com.drink.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.drink.entity.DrinkEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DrinkRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private List<IngredientesRequest> ingredientes;
	private String modoPreparo;

	public DrinkEntity toEntity() {
		return DrinkEntity.builder()
				.nome(this.getNome())
				.modoPreparo(this.getModoPreparo())
				.ingredientes(ingredientes.stream()
							.map(i -> i.toEntity())
							.collect(Collectors.toList()))
				.build();
	}

	
}
