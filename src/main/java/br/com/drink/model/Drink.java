package br.com.drink.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Drink{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToOne(cascade = {CascadeType.ALL})
	private Ingredientes ingredientes;
	

	public Drink() {
		
	}
	public Drink(Long id, String nome, Ingredientes ingredientes) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Ingredientes getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Ingredientes ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	
	
	
	
}
