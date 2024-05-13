package com.dmazui.hotelapi.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dmazui.hotelapi.domain.models.Valor;
import com.dmazui.hotelapi.repositories.ValorRepository;

@Service
public class ValorService {
	ValorRepository repository;

	public ValorService(ValorRepository repository) {
		this.repository = repository;
	} 
	
	public Valor save(Valor source) {
		return repository.save(source);
	}


	public Valor findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Valor> findAll() {
	    return repository.findAll();
	}

	public Valor update(Long id, Valor source) {
		source.setId(id);
		return repository.save(source);    
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}


}
