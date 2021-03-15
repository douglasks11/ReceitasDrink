package br.com.drink.dto;



import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.drink.entity.drinkEntity;
import br.com.drink.entity.ingredientesEntity;

public class drinkDto {
	@NotNull @NotBlank
	private String nome;
	@NotNull 
	private List<ingredientesEntity> ingredientes;
	@NotNull @NotBlank
	private String modoPreparo;
	
	
	public drinkDto(String nome, List<ingredientesEntity> ingredientes) {
		this.nome = nome;
		this.ingredientes = ingredientes;
	}


	public drinkDto(drinkEntity drinkEntity) {
		this.nome = drinkEntity.getNome();
		this.ingredientes = drinkEntity.getIngredientes();
	}


	public String getNome() {
		return nome;
	}


	public List<ingredientesEntity> getIngredientes() {
		return ingredientes;
	}


	public String getModoPreparo() {
		return modoPreparo;
	}


	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setIngredientes(List<ingredientesEntity> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public drinkEntity toEntity() {
		return new drinkEntity(null,this.nome, this.ingredientes, this.modoPreparo);
	}
	
}
