package com.wavelabs.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int clientNo;
	
	@Column(name="clientName")
	private String clientName;
	
	private ContactDetails contactDetails;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
	private List<Project> projects;
	
	public Client(String clientName, ContactDetails contactDetails, List<Project> projects) {
		super();
		this.clientName = clientName;
		this.contactDetails = contactDetails;
		this.projects = projects;
	}
	
	public Client() {}

	public int getClientNo() {
		return clientNo;
	}

	public void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Client [clientNo=" + clientNo + ", clientName=" + clientName + ", contactDetails=" + contactDetails
				+ ", projects=" + projects + "]";
	}
	
	
	
}
