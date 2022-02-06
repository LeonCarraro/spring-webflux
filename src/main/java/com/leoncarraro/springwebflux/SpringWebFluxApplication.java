package com.leoncarraro.springwebflux;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leoncarraro.springwebflux.domain.document.Coffee;
import com.leoncarraro.springwebflux.repository.CoffeeRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebFluxApplication implements ApplicationRunner {

	private final CoffeeRepository coffeRepository;

	public SpringWebFluxApplication(final CoffeeRepository coffeRepository) {
		this.coffeRepository = coffeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxApplication.class, args);
	}

	@Override
	public void run(final ApplicationArguments args) {
		// Just to add some data in application initialization
		Flux.just(
						new Coffee(null, "Big Latte", BigDecimal.valueOf(10.0)),
						new Coffee(null, "Big Decaf", BigDecimal.valueOf(12.0)),
						new Coffee(null, "Green Tea", BigDecimal.valueOf(8.0)))
				.flatMap(coffeRepository::save)
				.thenMany(coffeRepository.findAll())
				.subscribe(coffee -> System.out.println(coffee.getName()));
	}

}
