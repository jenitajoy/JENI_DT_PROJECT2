package com.niit.digi.dazzle.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Table(name="Job")

public class Job {

	@Id
	@Column
	String jobid;
	
	@Column
	@NotNull(message="Enter the company name")
	String cmpy_name;
	
	@Column
	@NotNull(message="About Company description")
	String description;
	
	@Column
	@NotNull(message="Enter your qualification")
	String qualification;
	
	@Column
	@NotNull(message="Experience or Fresher")
	String experience;
	
	@Column
	@NotNull(message="Enter the vacancies")
	String vacancy;

	
	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getCmpy_name() {
		return cmpy_name;
	}

	public void setCmpy_name(String cmpy_name) {
		this.cmpy_name = cmpy_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}
	

	
	
	
}
