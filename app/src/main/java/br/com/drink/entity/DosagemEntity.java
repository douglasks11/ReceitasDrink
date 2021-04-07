package br.com.drink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.drink.dto.DosagemRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_DOSAGENS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DosagemEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;

	public DosagemEntity update(DosagemRequest dosagemRequest) {
		this.tipo = dosagemRequest.getTipo() != null ? dosagemRequest.getTipo() : this.getTipo();
		return this;
	}
}
