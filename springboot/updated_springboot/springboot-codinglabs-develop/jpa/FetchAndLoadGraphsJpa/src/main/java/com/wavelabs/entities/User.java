package com.wavelabs.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

@Entity
@NamedEntityGraph(name = "user-phones-entity-graph", attributeNodes = @NamedAttributeNode("phones"))
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Phone> phones;

	public User() {
		super();
	}

	public User(String name, Set<Address> addresses, Set<Phone> phones) {
		super();
		this.name = name;
		this.addresses = addresses;
		this.phones = phones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addresses=" + addresses + ", phones=" + phones + "]";
	}
	
	public void addPhone(String number, String type) {
        if (phones == null) {
            phones = new HashSet<>();
        }
        Phone p = new Phone();
        p.setNumber(number);
        p.setType(type);
        phones.add(p);
    }

    public void addAddress(String street, String city, String country) {
        if (addresses == null) {
            addresses = new HashSet<>();
        }
        Address a = new Address();
        a.setStreet(street);
        a.setCity(city);
        a.setCountry(country);
        addresses.add(a);
    }
	
}
