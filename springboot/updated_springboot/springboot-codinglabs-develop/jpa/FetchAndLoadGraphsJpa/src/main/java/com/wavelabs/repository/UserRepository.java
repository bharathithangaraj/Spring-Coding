package com.wavelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wavelabs.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, IUserRepositoryCustom{

}
