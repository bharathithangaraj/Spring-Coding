package jpacompositekeyonetoone.compositekey.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@EmbeddedId
	private AddressKey id;

	private String name;

	private String society;

	@OneToOne
	@JoinColumn(name = "xId", referencedColumnName = "xId")
	@JoinColumn(name = "yId", referencedColumnName = "yId")
	@MapsId
	private Address address;

	public AddressKey getId() {
		return id;
	}

	public void setId(AddressKey id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}