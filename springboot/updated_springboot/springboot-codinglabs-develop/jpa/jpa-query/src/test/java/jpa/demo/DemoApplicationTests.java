package jpa.demo;

import jpa.repo.*;
import jpa.repo.AccountRepository;
import jpa.entity.Account;
import jpa.entity.Employee;
import jpa.entity.EmployeeIdentity;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	EmployeeRepository empRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	public void queryMethod() {

		String name = RandomStringUtils.random(10, true, true);
		String accountNumber = RandomStringUtils.random(5, true, false) + "-"
				+ RandomStringUtils.random(5, false, true);
		Account account = accountRepository.save(new Account().setAccountNumber(accountNumber).setName(name));
		Assert.assertNotNull(account.getId());
		Assert.assertNotNull(accountRepository.findByName(name));
		Assert.assertNotNull(accountRepository.findByNameAndAccountNumber(name, accountNumber));
		// query by invalid name
		Assert.assertNull(accountRepository.findByName(name + "randomtext"));

		// delete account
		accountRepository.deleteByName(name);
		// find after deleting should return null
		Assert.assertNull(accountRepository.findByName(name));

	}

	@Test
	public void testEmp() {
		EmployeeIdentity id = new EmployeeIdentity("11Wl11156", "WL");
		Employee emp1 = new Employee(id, "emp", "emp@example.in", "9332518864");
		empRepository.save(emp1);
		Optional<Employee> emp2 = empRepository.findById(id);
		if (emp2.isPresent()) {
			System.out.println(emp2.get().getEmail());
		}
	}

	@Rollback
	@After
	public void tearDown() {

	}
}
