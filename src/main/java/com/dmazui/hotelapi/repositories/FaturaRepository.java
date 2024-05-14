package com.dmazui.hotelapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dmazui.hotelapi.domain.models.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura, Long>{

	List<Fatura> findByIdReserva(Long idReserva);

	@Query(value = "SELECT SUM(valor) FROM faturas f where id_reserva = :idReserva", nativeQuery = true)
	Long getTotalFatura(Long idReserva);
	
	
	
}
