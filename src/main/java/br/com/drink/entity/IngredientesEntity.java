package br.com.drink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
}
