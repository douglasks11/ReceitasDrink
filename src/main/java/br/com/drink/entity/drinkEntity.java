package br.com.drink.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@Table(name = "DRINK")
public class drinkEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID DO DRINK", name= "ID", value = "1")
	private Long id;
	@NotNull @NotEmpty
	@ApiModelProperty(notes = "NOME DO DRINK", name= "NOME", value = "CHEVET")
	private String nome;
	@OneToMany(cascade = {CascadeType.ALL})
	@NotNull
	private List<ingredientesEntity> ingredientes;
	@NotNull @NotEmpty
	@ApiModelProperty(notes = "FORMA DE PREPARO", name= "PREPARO", value = "MISTURAR TUDO")
	private String  modoPreparo;

	public drinkEntity(Long id, String nome, List<ingredientesEntity> ingredientes, String modoPreparo) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.modoPreparo = modoPreparo;
	}

	public drinkEntity() {
	}
}
