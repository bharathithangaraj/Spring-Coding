package jpa.demo;

import jpa.repo.*;
import jpa.repo.AccountRepository;
import jpa.entity.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class DemoApplicationTests {

  @Autowired
  AccountRepository accountRepository;

  @Test
  public void contextLoads() {
    Account account = accountRepository.save(
        new Account().setAccountNumber("ABCD-PORS").setName("Support123")
    );
    Assert.assertNotNull(account.getId());

    Optional<Account> ac =   accountRepository.findById(account.getId());
    Account ac1 = ac.isPresent()?ac.get():null;
    ac1.setWhenCreated(new Date());
    accountRepository.save(ac1);
    Assert.assertNotNull(ac1);


    ac1 =   accountRepository.findByName(account.getName());
    Assert.assertNotNull(ac1);

    ac1 =   accountRepository.findByNameAndAccountNumber(account.getName(), account.getAccountNumber());
    Assert.assertNotNull(ac1);


    accountRepository.delete(ac1);

    ac =   accountRepository.findById(ac1.getId());

    Assert.assertFalse(ac.isPresent());

  }

}
