package com.wavelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wavelabs.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
