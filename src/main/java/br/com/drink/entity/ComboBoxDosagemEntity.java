package br.com.drink.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "COMBO_BOX_DOSAGEM")
@Data
public class ComboBoxDosagemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;

}
