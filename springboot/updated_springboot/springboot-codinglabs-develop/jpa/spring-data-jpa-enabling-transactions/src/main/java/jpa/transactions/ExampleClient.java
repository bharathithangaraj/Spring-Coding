package jpa.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ExampleClient {

  @Autowired
  private EmployeeRepository repo;


  @Autowired
  EmployeeService svc;

  public void findEmployees() {
    System.out.println(" -- finding all employees --");
    repo.findAll().forEach(System.out::println);
  }

  @Transactional
  public void saveEmployees() {
    System.out.println(">>>>> start saving ");
    repo.save(Employee.create("Mike", "Sale", 1000));
    repo.save(Employee.create("Diana", "Admin", 3000));

    // following line will throw unique constraint exception. but the previous inserts will be committed
    repo.save(Employee.create("Diana", "IT", 3200));
    System.out.println(">>>> end saving ");
  }

  void m1() {
    svc.transfer();
    svc.debit();
  }

}