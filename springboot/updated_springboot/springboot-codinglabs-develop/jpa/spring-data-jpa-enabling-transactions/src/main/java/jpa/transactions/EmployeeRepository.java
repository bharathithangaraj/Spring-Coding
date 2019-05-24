package jpa.transactions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//  @Transactional(timeout = 10)
//  @Override
//  <S extends Employee> S save(S s);
}