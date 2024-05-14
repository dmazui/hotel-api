package com.dmazui.hotelapi.domain.models;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "faturas")
public class Fatura implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
	    @Column(name = "id", nullable = false)
		@SequenceGenerator(name = "faturas_sequence", sequenceName = "faturas_seq", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faturas_sequence")
		private Long id;
		
		private Long idReserva;
		
		private String descricao;
		
		private Long valor;
		
		private LocalDateTime data;
}
