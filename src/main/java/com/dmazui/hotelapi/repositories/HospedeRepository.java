package com.dmazui.hotelapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmazui.hotelapi.domain.models.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long>{

}
