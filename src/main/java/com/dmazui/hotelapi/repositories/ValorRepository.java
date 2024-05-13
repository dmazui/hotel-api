package com.dmazui.hotelapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmazui.hotelapi.domain.models.Valor;

public interface ValorRepository extends JpaRepository<Valor, Long>{

}
