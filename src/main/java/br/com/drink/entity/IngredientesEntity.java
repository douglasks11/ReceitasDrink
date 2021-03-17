package br.com.drink.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

import br.com.drink.dto.IngredientesResponse;

@Entity
@Table(name = "INGREDIENTES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientesEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes = "ITEM INGREDIENTE", name= "ITEM", value = "COROTE")
	private String ingrediente;
	@ApiModelProperty(notes = "QUANTIDADE A SER ADICIONADO", name= "QUANTIDADE", value = "200")
	private String quantidade;
	@ApiModelProperty(notes = "TIPO DE DOSAGEM", name= "DOSAGEM", value = "ML")
	private String dosagem;

	
	public IngredientesResponse toResponse() {
		return IngredientesResponse.builder()
					.id(this.getId())
					.ingrediente(this.getIngrediente())
					.quantidade(this.getQuantidade())
					.dosagem(this.getDosagem())
					.build();
					
	}
}
