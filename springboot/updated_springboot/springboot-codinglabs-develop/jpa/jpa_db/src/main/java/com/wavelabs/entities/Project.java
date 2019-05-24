package com.wavelabs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int projectId;
	private String projectName;
	private Team team;
	private Date startDate;
	private List<String> technologies;
	private String projManager;
	private double totalManHours;
	
	public Project() {}
	
	public Project(String projectName, Team team, Date startDate, List<String> technologies,
			String projManager, double totalManHours) {
		super();
		this.projectName = projectName;
		this.team = team;
		this.startDate = startDate;
		this.technologies = technologies;
		this.projManager = projManager;
		this.totalManHours = totalManHours;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<String> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}
	public String getProjManager() {
		return projManager;
	}
	public void setProjManager(String projManager) {
		this.projManager = projManager;
	}
	public double getTotalManHours() {
		return totalManHours;
	}
	public void setTotalManHours(double totalManHours) {
		this.totalManHours = totalManHours;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", team=" + team + ", startDate="
				+ startDate + ", technologies=" + technologies + ", projManager=" + projManager + ", totalManHours="
				+ totalManHours + "]";
	}
	
}
