package com.wavelabs.entities;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int TeamNo;
	private Map<Integer, Employee> employees; 
	private String teamLeadName;
	
	public Team() {}
	
	public Team(Map<Integer, Employee> employees, String teamLeadName) {
		super();
		this.employees = employees;
		this.teamLeadName = teamLeadName;
	}
	
	@Override
	public String toString() {
		return "Team [TeamNo=" + TeamNo + ", employees=" + employees + ", teamLeadName=" + teamLeadName + "]";
	}

	public int getTeamNo() {
		return TeamNo;
	}
	public void setTeamNo(int teamNo) {
		TeamNo = teamNo;
	}
	public Map<Integer, Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Map<Integer, Employee> employees) {
		this.employees = employees;
	}
	public String getTeamLeadName() {
		return teamLeadName;
	}
	public void setTeamLeadName(String teamLeadName) {
		this.teamLeadName = teamLeadName;
	}
	
}
