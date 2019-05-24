package com.unimoni.spring.cloud.hystrix.rest.producer;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

  Optional<Greeting> findByName(String name);
}
