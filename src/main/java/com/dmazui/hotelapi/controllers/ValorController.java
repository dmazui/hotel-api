package com.dmazui.hotelapi.controllers;

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

import com.dmazui.hotelapi.domain.models.Valor;
import com.dmazui.hotelapi.domain.services.ValorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/valores")
public class ValorController {
	ValorService service;

	public ValorController(ValorService service) {
		this.service = service;
	}


	@PostMapping
	public ResponseEntity<Valor> save(@RequestBody @Valid Valor source) throws Exception {
		try {
			return ResponseEntity.ok(service.save(source));
		} catch (Exception e) { }
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Valor> find(@PathVariable("id") Long id) throws Exception {
		return (service.findById(id) != null) ? ResponseEntity.ok(service.findById(id)) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<Valor>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Valor> update(@PathVariable("id") Long id, @RequestBody Valor source) throws Exception {
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
}
