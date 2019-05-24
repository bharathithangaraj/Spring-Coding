package com.wavelabs.repository;

import com.wavelabs.entities.User;

public interface IUserRepositoryCustom {
	User findEntity(String entityGraph, String graphType);
}
