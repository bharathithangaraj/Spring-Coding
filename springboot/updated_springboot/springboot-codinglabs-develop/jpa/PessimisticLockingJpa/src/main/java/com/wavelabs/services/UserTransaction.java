package com.wavelabs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavelabs.jpaentities.Student;
import com.wavelabs.repository.StudentRepository;

@Service
@Transactional
public class UserTransaction {
	@Autowired
	StudentRepository repository;

	public void runUser1Transaction() {
        System.out.println(" -- user 1 reading Article entity --");
        long start = System.currentTimeMillis();
        Student student1 = null;
        try {
        	student1 = repository.findStudentForRead(1L);
        } catch (Exception e) {
            System.err.println("User 1 got exception while acquiring the database lock:\n " + e);
            return;
        }
        System.out.println("user 1 got the lock, block time was: " + (System.currentTimeMillis() - start));
        //delay for 2 seconds
        ThreadSleep(3000);
        System.out.println("User 1 read article: " + student1);
    }
	
	public void runUser2Transaction() {
        ThreadSleep(500);//let user1 acquire optimistic lock first
        System.out.println(" -- user 2 writing Article entity --");
        long start = System.currentTimeMillis();
        Student student2 = null;
        try {
        	student2 = repository.findStudentForWrite(1L);
        } catch (Exception e) {
            System.err.println("User 2 got exception while acquiring the database lock:\n " + e);
            return;
        }
        System.out.println("user 2 got the lock, block time was: " + (System.currentTimeMillis() - start));
        student2.setName("Suraj Kumar");
        student2.setPassportNumber("12345678");
        repository.save(student2);
        System.out.println("User 2 updated article: " + student2);
    }
	
	private void ThreadSleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
