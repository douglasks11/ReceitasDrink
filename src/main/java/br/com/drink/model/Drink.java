package br.com.drink.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drink{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Ingredientes> ingredientes;
	

	public Drink() {
		
	}
	public Drink(Long id, String nome, List<Ingredientes> ingredientes) {
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
	public List<Ingredientes> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	
	
	
	
}
