package com.leoncarraro.springwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.leoncarraro.springwebflux.domain.document.Coffee;

@Repository
public interface CoffeeRepository extends ReactiveMongoRepository<Coffee, String> {
}
