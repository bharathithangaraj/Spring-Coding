package com.example.demo.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SBICustomer;

@Repository
public interface SBICustomerRepository extends JpaRepository<SBICustomer, Long> {

}
