package br.com.drink.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class ComboBoxDosagemDTO implements Serializable {
    private Long id;
    private String tipo;
}
