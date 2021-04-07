package br.com.drink.dto;

import java.io.Serializable;

import br.com.drink.entity.ImagemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ImagemRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String data;
	
	public ImagemEntity toEntity() {
		return ImagemEntity.builder()
					.data(data)
					.build();
	}
}
