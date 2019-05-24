package com.wavelabs.repository;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wavelabs.entities.User;

public class UserRepositoryImpl implements IUserRepositoryCustom{
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public User findEntity(String entityGraph, String graphType) {
        Map<String, Object> properties = new HashMap<>();
        properties.put(graphType, entityManager.getEntityGraph(entityGraph));
        System.out.println("\n findEntity() method is working before find\n");
        return entityManager.find(User.class, 1, properties);
	}
	
}
