package com.niit.digi.dazzle.model;


import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Table(name="event")
public class Event {
	@Id 
	@Column
	String eid;
	
	@Column
	@NotNull(message="Enter Event Name")
	String ename;
	
	@Column
	@NotNull(message="Created Date and time")
	Date date1;
	
	
	
	@Column
	@NotNull(message="Conducted Venue")
	String venue;
	
	@Column
	@NotNull(message="Description of the event")
	String description;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public Date getDate() {
		return date1;
	}

	public void setDate(Date date1) {
		this.date1 = date1;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
