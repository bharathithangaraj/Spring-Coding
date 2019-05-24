package com.wavelabs.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact_details")
public class ContactDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contactId;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "email_id")
	private String emailId;
	
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
	private Address address;
	
	public ContactDetails() {}
	
	public ContactDetails(String mobileNo, String emailId, Address address, Address currentAddress) {
		super();
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.address = address;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ContactDetails [contactId=" + contactId + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", primaryAddress=" + address + "]";
	}
	
}
