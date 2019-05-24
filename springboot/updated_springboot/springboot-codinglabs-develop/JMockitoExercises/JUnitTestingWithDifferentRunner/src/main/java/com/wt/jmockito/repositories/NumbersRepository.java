package com.wt.jmockito.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class NumbersRepository {
	public int[] retrieveAllNumbers() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}
