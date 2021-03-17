package br.com.drink.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.drink.dto.DrinkRequest;
import br.com.drink.dto.DrinkResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "DRINK")
@AllArgsConstructor
@NoArgsConstructor
public class DrinkEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID DO DRINK", name= "ID", value = "1")
	private Long id;
	@NotNull @NotEmpty
	@ApiModelProperty(notes = "NOME DO DRINK", name= "NOME", value = "CHEVET")
	private String nome;

	@OneToMany(cascade = {CascadeType.ALL})
	@NotNull
	@Default
	private List<IngredientesEntity> ingredientes = new ArrayList<>();
	@NotNull @NotEmpty
	@ApiModelProperty(notes = "FORMA DE PREPARO", name= "PREPARO", value = "MISTURAR TUDO")
	private String  modoPreparo;

	
	public DrinkResponse toResponse() {
		return DrinkResponse.builder()
					.id(this.getId())
					.ingredientes(this.getIngredientes()
									.stream()
									.map(i -> i.toResponse())
									.collect(Collectors.toList()))
					.modoPreparo(this.getModoPreparo())
					.nome(this.getNome())
					.build();
					
	}


	public DrinkEntity update(DrinkRequest drinkRequest) {
		this.nome = drinkRequest.getNome() != null ? drinkRequest.getNome() : this.getNome();
		this.modoPreparo = drinkRequest.getModoPreparo() != null ? drinkRequest.getModoPreparo() : this.getModoPreparo();
		return this;
	}
}
