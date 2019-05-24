package com.wavelabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wavelabs.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
