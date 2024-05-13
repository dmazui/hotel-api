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
	
	public String save(Hospede source) {
		
		return "";
	}


	public String findById(Long id) {
		return "";
	}

	public List<Hospede> findAll() {
	    Sort sort = Sort.by(Direction.DESC, "nome");
	    return repository.findAll(sort);
	}

	public String update(Long id, Hospede source) {
		source.setId(id);
		return "";    
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
