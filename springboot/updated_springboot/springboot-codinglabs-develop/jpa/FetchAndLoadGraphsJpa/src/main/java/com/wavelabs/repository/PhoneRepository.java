package com.wavelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wavelabs.entities.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long>{

}
