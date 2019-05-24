package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sbi")
public class SBICustomer {

	@Id
	@Column
	@NotNull(message = "not be null")
	private long customerid;

	@NotNull(message = "not be null")
	@Column
	@Size(min = 2, max = 10, message = "validation my failed")
	private String customername;

	@NotNull(message = "not be null")
	@Column
	@Size(min = 2, max = 10, message = "validation my failed")
	private String accountnum;

	@NotNull(message = "not be null")
	@Column
	@Size(min = 2, max = 10, message = "validation my failed")
	private String mobilenum;

	@Override
	public String toString() {
		return "SBICustomer [customerid=" + customerid + ", customername=" + customername + ", accountnum=" + accountnum
				+ ", mobilenum=" + mobilenum + "]";
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

}
