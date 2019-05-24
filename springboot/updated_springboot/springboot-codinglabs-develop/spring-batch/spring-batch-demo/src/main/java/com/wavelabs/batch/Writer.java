package com.wavelabs.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wavelabs.entity.DataUsers;
import com.wavelabs.repository.UsersRepository;

@Component
public class Writer implements ItemWriter<DataUsers>{
	
	@Autowired
	private UsersRepository repo;

	@Override
	@Transactional
	public void write(List<? extends DataUsers> users) throws Exception {
		repo.saveAll(users);
	}
	
}
