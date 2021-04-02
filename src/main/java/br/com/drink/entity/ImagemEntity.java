package br.com.drink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "IMAGEM")
@AllArgsConstructor
@NoArgsConstructor

public class ImagemEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String data;
}
