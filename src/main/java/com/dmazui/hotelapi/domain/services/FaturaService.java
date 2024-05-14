package com.dmazui.hotelapi.domain.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dmazui.hotelapi.domain.models.Fatura;
import com.dmazui.hotelapi.repositories.FaturaRepository;

@Service
public class FaturaService {

	FaturaRepository repository;

	public FaturaService(FaturaRepository repository) {
		this.repository = repository;
	} 
	
	public Fatura save(Fatura source) {
		return repository.save(source);
	}

	public List<Fatura> findByIdReserva(Long id) {
		return repository.findByIdReserva(id);
	}

	public List<Fatura> findAll() {
	    Sort sort = Sort.by(Direction.DESC, "data");
	    return repository.findAll(sort);
	}

	public Fatura update(Long id, Fatura source) {
		source.setId(id);
		return repository.save(source);    
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
