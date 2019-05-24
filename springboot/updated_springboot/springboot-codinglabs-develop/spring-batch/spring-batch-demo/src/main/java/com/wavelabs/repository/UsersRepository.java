package com.wavelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wavelabs.entity.DataUsers;

public interface UsersRepository extends JpaRepository<DataUsers, Long> {
}
