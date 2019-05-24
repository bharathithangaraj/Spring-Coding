package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String accountNumber;
  private String name;

  @Column(name = "created_date")
  private Date whenCreated;

  public Long getId() {
    return id;
  }

  public Account setId(Long id) {
    this.id = id;
    return this;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public Account setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public String getName() {
    return name;
  }

  public Account setName(String name) {
    this.name = name;
    return this;
  }

  public Date getWhenCreated() {
    return whenCreated;
  }

  public Account setWhenCreated(Date whenCreated) {
    this.whenCreated = whenCreated;
    return this;
  }
}
