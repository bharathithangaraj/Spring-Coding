package jpa.repo;

import jpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface AccountRepository extends JpaRepository<Account, Long> {

  Account findByName(String name);

  Account findByNameAndAccountNumber(String name, String accNum);


  Account findByWhenCreatedBetween(Date d1, Date d2);

}
