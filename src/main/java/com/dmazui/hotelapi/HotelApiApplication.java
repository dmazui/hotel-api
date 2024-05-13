package com.dmazui.hotelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EntityScan(basePackages = {"com.dmazui.hotelapi.domain.models"})
public class HotelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApiApplication.class, args);
	}
	
	@GetMapping
	public String hello() {
		return "{\"api\": \"hotel\", \"by\" : \"dmazui\"}";
	}

	
	
}
