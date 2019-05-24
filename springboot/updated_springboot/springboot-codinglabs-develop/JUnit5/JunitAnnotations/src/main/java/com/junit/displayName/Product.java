package com.junit.displayName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
private String productName;
	
public Product() {}

public Product(String productName) {
		super();
		this.productName = productName;
	}
	
}

