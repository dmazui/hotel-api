package com.dmazui.hotelapi.domain.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dmazui.hotelapi.domain.models.Hospede;
import com.dmazui.hotelapi.repositories.HospedeRepository;

@Service
public class HospedeService {

	HospedeRepository repository;

	public HospedeService(HospedeRepository repository) {
		this.repository = repository;
	} 
	
	public Hospede save(Hospede source) {
		return repository.save(source);
	}


	public Hospede findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Hospede> findAll() {
	    Sort sort = Sort.by(Direction.ASC, "nome");
	    return repository.findAll(sort);
	}

	public Hospede update(Long id, Hospede source) {
		source.setId(id);
		return repository.save(source);    
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
