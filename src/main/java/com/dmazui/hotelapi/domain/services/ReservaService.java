package com.dmazui.hotelapi.domain.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dmazui.hotelapi.domain.models.Reserva;
import com.dmazui.hotelapi.repositories.ReservaRepository;

@Service
public class ReservaService {

	ReservaRepository repository;

	public ReservaService(ReservaRepository repository) {
		this.repository = repository;
	} 
	
	public Reserva save(Reserva source) {
		return repository.save(source);
	}


	public Reserva findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Reserva> findAll() {
	    Sort sort = Sort.by(Direction.DESC, "dataInicio");
	    return repository.findAll(sort);
	}

	public Reserva update(Long id, Reserva source) {
		source.setId(id);
		return repository.save(source);    
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
