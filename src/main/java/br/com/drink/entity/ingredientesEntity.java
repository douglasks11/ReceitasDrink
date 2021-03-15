package br.com.drink.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENTES")
public class ingredientesEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes = "ITEM INGREDIENTE", name= "ITEM", value = "COROTE")
	private String ingrediente;
	@ApiModelProperty(notes = "QUANTIDADE A SER ADICIONADO", name= "QUANTIDADE", value = "200")
	private String quantidade;
	@ApiModelProperty(notes = "TIPO DE DOSAGEM", name= "DOSAGEM", value = "ML")
	private String dosagem;

}
