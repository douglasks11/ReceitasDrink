package br.com.drink.dto;



import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.drink.model.Drink;
import br.com.drink.model.Ingredientes;

public class DrinkDto {
	@NotNull @NotBlank
	private String nome;
	@NotNull 
	private List<Ingredientes> ingredientes;
	@NotNull @NotBlank
	private String modoPreparo;
	
	
	public DrinkDto(String nome, List<Ingredientes> ingredientes) {
		this.nome = nome;
		this.ingredientes = ingredientes;
	}


	public DrinkDto(Drink drink) {
		this.nome = drink.getNome();
		this.ingredientes = drink.getIngredientes();
	}


	public String getNome() {
		return nome;
	}


	public List<Ingredientes> getIngredientes() {
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


	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public Drink toEntity() {
		return new Drink(null,this.nome, this.ingredientes, this.modoPreparo);
	}
	
}
