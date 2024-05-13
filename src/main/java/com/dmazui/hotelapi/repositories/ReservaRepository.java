package com.dmazui.hotelapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmazui.hotelapi.domain.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
