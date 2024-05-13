package com.dmazui.hotelapi.domain.models;

import java.io.Serializable;
import java.time.LocalDate;

import com.dmazui.hotelapi.domain.enums.Situacao;

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
@Table(name = "reservas")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id", nullable = false)
	@SequenceGenerator(name = "reservas_sequence", sequenceName = "reservas_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservas_sequence")
	private Long id;
	
	private LocalDate dataInicio;

	private LocalDate dataFim;
	
	private Situacao situacao;
	
	//TODO deve ser one to many 
	private Long hospedeId;

	
}
