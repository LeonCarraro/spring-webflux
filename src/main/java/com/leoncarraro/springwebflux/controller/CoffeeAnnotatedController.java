package com.leoncarraro.springwebflux.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoncarraro.springwebflux.domain.document.Coffee;
import com.leoncarraro.springwebflux.repository.CoffeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/annotated")
public class CoffeeAnnotatedController {

	private final CoffeeRepository coffeeRepository;

	public CoffeeAnnotatedController(final CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}

	@GetMapping("/")
	public Flux<Coffee> findAll() {
		return coffeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Coffee>> findById(@PathVariable String id) {
		return coffeeRepository.findById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping("/")
	public Mono<Coffee> update(@RequestBody Coffee coffee) {
		return coffeeRepository.save(coffee);
	}

}
