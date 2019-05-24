package com.wavelabs.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component@Entity
public class Customer
{@Id
private Integer custId;
private String custName;
private String mobileNumber;

public Customer() {
}
public Integer getCustId() {
	return custId;
}
public void setCustId(Integer custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
}
