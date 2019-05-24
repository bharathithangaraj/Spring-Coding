package com.wavelabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wavelabs.entities.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long>, JpaRepository<Currency, Long>{

}
