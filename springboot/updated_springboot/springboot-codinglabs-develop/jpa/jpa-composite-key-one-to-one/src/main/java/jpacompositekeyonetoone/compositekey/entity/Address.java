package jpacompositekeyonetoone.compositekey.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@EmbeddedId
	private AddressKey id;

	private String city;

	private String street;

	private String country;

	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)

	private Person person;

	public Address() {
		super();
	}

	public Address(AddressKey id, String city, String street, String country, Person person) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.country = country;
		this.person = person;
	}

	public AddressKey getId() {
		return id;
	}

	public void setId(AddressKey id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}