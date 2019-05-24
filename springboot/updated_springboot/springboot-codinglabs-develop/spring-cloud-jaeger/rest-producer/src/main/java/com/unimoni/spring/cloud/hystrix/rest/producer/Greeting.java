package com.unimoni.spring.cloud.hystrix.rest.producer;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Long getId() {
    return id;
  }

  public Greeting setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Greeting setName(String name) {
    this.name = name;
    return this;
  }
}
