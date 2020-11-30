package br.com.drink.dto;



import java.util.List;
import java.util.stream.Collectors;

import br.com.drink.model.Drink;
import br.com.drink.model.Ingredientes;

public class DrinkDto {

	private String nome;
	private Ingredientes ingredientes;
	
	
	public DrinkDto(String nome, Ingredientes ingredientes) {
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


	public Ingredientes getIngredientes() {
		return ingredientes;
	}
	
	public static List<DrinkDto> converter(List<Drink> drinks) {
		
		return drinks.stream().map(DrinkDto::new).collect(Collectors.toList());
		
	}
	public Drink toEntity() {
		return new Drink(null, this.nome, this.ingredientes);
	}
}
