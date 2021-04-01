package br.com.drink.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.drink.entity.DrinkEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DrinkResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<IngredientesResponse> ingredientes;
	private String nome;
	private String modoPreparo;
	private LocalDate dataCriacao;
	private boolean aprovado;
	private LocalDate dataAprovacao;
	private int likes;
	
	public DrinkResponse (DrinkEntity entity) {
		this.id = entity.getId();
		this.ingredientes = entity.getIngredientes().stream().map(IngredientesResponse::new).collect(Collectors.toList());
		this.nome = entity.getNome();
		this.modoPreparo = entity.getModoPreparo();
		this.dataCriacao = entity.getDataCriacao();
		this.aprovado = entity.isAprovado();
		this.dataAprovacao = entity.getDataAprovacao();
		this.likes = entity.getLikes();
	}
}
