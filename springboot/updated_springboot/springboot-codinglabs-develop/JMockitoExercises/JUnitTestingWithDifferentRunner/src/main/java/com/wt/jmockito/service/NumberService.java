package com.wt.jmockito.service;

import org.springframework.stereotype.Service;

import com.wt.jmockito.repositories.NumbersRepository;

@Service
public class NumberService {
	
	private NumbersRepository numberRepository;

	public NumberService(NumbersRepository numberRepository) {
		super();
		this.numberRepository = numberRepository;
	}
	
	public int findMaximumValue() {
		int[] data = numberRepository.retrieveAllNumbers();
		int max = Integer.MIN_VALUE;
		for(int val:data) {
			if(val>max) {
				max = val;
			}
		}
		return max;
	}
}
