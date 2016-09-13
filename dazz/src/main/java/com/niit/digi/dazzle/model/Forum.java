package com.niit.digi.dazzle.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Table(name="forum")

public class Forum {
	
	
	@Id 
	@Column
	String fid;
	
	@Column
	@NotNull(message="Enter the name")
	String name;
	
	@Column
	@NotNull(message="Enter Message")
	String message;
	
	@Column
	@NotNull(message="Created Timing")
	Date date_time;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	
	
	
}
