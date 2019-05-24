package com.example.demo;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.model.Users1;

public class UserItemProcessor implements ItemProcessor<Users1, Users1> {

	 @Override
	 public Users1 process(Users1 user) throws Exception {
	  return user;
	 }

	}