package jpa.compositekey;

import java.util.Arrays;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jpa.compositekey.idclass.Book;
import jpa.compositekey.idclass.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	BookRepository bookRepo;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	@Transactional
	public void testBook() {
	    bookRepo.saveAll(Arrays.asList(new Book("Hello Koding 1", new Date())));
		
		System.out.println("My books: " + bookRepo.findAll());
	}

}
