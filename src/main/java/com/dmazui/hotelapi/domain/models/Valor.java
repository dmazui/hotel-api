package com.dmazui.hotelapi.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "valores")
public class Valor {
	//TODO nao sei se é o melhor caminho
	
	@Id
    @Column(name = "id", nullable = false)
	@SequenceGenerator(name = "valores_sequence", sequenceName = "valores_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valores_sequence")
	private Long id;
	
	@Column(length = 50)
	private String descricao;
	
	private Long valor;
	

}
