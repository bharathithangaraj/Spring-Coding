package jpa.repo;

import jpa.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
  Account findByName(String name);
  Account findByNameAndAccountNumber(String name, String accountNumber);
  Long deleteByName(String name);

}
