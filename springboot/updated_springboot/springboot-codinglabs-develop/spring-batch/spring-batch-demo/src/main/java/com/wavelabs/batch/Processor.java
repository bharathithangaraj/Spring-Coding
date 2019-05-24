package com.wavelabs.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wavelabs.entity.DataUsers;
import com.wavelabs.repository.UsersRepository;

@Component
public class Processor implements ItemProcessor<DataUsers, DataUsers> {
 
 @Autowired
 private UsersRepository userRepo;
 
 @Override
 public DataUsers process(DataUsers user) throws Exception {
 Optional<DataUsers> userFromDb = userRepo.findById(user.getUserId());
 if(userFromDb.isPresent()) {
 user.setAccount(user.getAccount().add(userFromDb.get().getAccount()));
 }
 return user;
 }
 
}
