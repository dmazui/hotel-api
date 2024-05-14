package com.dmazui.hotelapi.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmazui.hotelapi.domain.enums.Situacao;
import com.dmazui.hotelapi.domain.models.Reserva;
import com.dmazui.hotelapi.domain.services.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/reservas")
public class ReservaController {
	ReservaService service;

	public ReservaController(ReservaService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Reserva> save(@RequestBody @Valid Reserva source) throws Exception {
		try {
			source.setSituacao(Situacao.ABERTA);
			return ResponseEntity.ok(service.save(source));
		} catch (Exception e) { }
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Reserva> find(@PathVariable("id") Long id) throws Exception {
		return (service.findById(id) != null) ? ResponseEntity.ok(service.findById(id)) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<Reserva>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Reserva> update(@PathVariable("id") Long id, @RequestBody Reserva source) throws Exception {
		return (service.findById(id) != null) ? ResponseEntity.ok(service.update(id, source)) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception {
		if (service.findById(id) != null) {
			service.delete(id);
			return ResponseEntity.ok("success");
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}/checkin")
	public ResponseEntity<Reserva> checkin(@PathVariable("id") Long id, @RequestBody Reserva source) throws Exception {
		// int hourCheckin = LocalDateTime.now().getHour();
		// if (hourCheckin < 14) 
		// validacao de horario deve ser feita no FRONT
		// NAO FAZ SENTIDO FAZER NO BACK
		
		source.setSituacao(Situacao.ATIVA);
		return (service.findById(id) != null) ? ResponseEntity.ok(service.update(id, source)) : ResponseEntity.notFound().build();
	}
	
}
