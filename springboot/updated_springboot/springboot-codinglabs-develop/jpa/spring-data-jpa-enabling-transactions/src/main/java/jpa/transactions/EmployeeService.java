package jpa.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

  @Autowired
  EmployeeRepository repository;

  @Autowired
  EmployeeService svc;

  @Transactional
  public Employee save(String name, String dept, int sal) {
    return repository.save(Employee.create(name, dept, sal));
  }



  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void transfer(String fromAct, String toaccount, double amt){
    svc.verifyAccounts();
    svc.debit(fromAct, amt); // create a new transaction
     this.debit(fromAct, amt); // will not create a new transaction
    svc.credit(toaccount, amt);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void debit(String fromAct, double amt ){

  }

  @Transactional
  public void credit(String toAct, double amt){

  }

  public void verifyAccounts(){

  }

  public void proxyTransfer(){
    try{
      // beginTxn() // BEGIN TXN

//     verifyAccounts();
//      proxyDebit(fromAct, amt);
//      proxyCredit(toaccount, amt);

    }catch (Exception e){
      // rollbackTXn();
    }finally {
      // commitTXn()
    }

  }

  public void proxyDebit(){
    try{
      // beginTxn()

      // org.debit();

    }catch (Exception e){
      // rollbackTXn();
    }finally {
      // commitTXn()
    }

  }


  public void proxyCredit(){
    // create new if not existing Txn()
    //boolean createdHere = true/false;

    // org.credit();
//    boolean isCreatedHere = false

    try{
      // isCreatedHere =  useExistingOrCreateTxn()

      // org.debit();

    }catch (Exception e){

      // rollbackTXn() if createdHere is true
    }finally {
      // commitTXn() if createdHere is true
    }
  }
}
