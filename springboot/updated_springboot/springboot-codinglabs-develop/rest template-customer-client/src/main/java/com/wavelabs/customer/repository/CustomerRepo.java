package com.wavelabs.customer.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wavelabs.customer.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer ,Integer > {

}
