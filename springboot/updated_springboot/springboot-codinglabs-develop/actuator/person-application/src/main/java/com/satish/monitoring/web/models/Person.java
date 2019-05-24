package com.satish.monitoring.web.models;

import java.io.Serializable;

import com.satish.monitoring.db.entities.PersonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Satish Sharma
 * 
 * <pre>
 *  Model class to represent a person;
 *  For the sake of simplicity all fields are kept same as {@link PersonEntity} object to be used as Entity class representing th table
 *  </pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
	private static final long serialVersionUID = 3570556679061270028L;


	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private int personId;
	private String firstName;
	private String lastName;
	private String email;


}
