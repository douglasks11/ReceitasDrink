package br.com.drink.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	@NotNull
	@ApiModelProperty(notes = "NOME DO DRINK", name= "NOME", value = "CHEVET")
	private String nome;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@Default
	private List<ImagemEntity> imagens = new ArrayList<>();
	
	@OneToMany(cascade = {CascadeType.ALL})
	@Default
	private List<IngredientesEntity> ingredientes = new ArrayList<>();
	
	@NotEmpty
	@ApiModelProperty(notes = "FORMA DE PREPARO", name= "PREPARO", value = "MISTURAR TUDO")
	private String  modoPreparo;
	
	private int likes;
	@Default
	private LocalDate dataCriacao = LocalDate.now();
	private boolean aprovado;
	private LocalDate dataAprovacao;
	

	public DrinkEntity update(DrinkRequest drinkRequest) {
		this.nome = drinkRequest.getNome() != null ? drinkRequest.getNome() : this.getNome();
		this.modoPreparo = drinkRequest.getModoPreparo() != null ? drinkRequest.getModoPreparo() : this.getModoPreparo();
		
		//TODO verificar se os ingredientes que estão sendo alterados existem no banco
		
	/*	this.ingredientes = ! drinkRequest.getIngredientes().isEmpty() && drinkRequest.getIngredientes() != null ? 
				drinkRequest.getIngredientes().stream().map(IngredientesRequest::toEntity).collect(Collectors.toList()) : this.getIngredientes(); */
		return this;
	}
}
