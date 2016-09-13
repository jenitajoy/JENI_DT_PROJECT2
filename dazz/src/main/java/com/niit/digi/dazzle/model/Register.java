package com.niit.digi.dazzle.model;

import java.util.Set;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
@SuppressWarnings("unused")
@Entity
@Table
public class Register {
	
	

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private String id;

	@Column
	@Size(min=2,max=30)
	@NotNull(message="Enter your Name")
	private String name;

	@Column
	@NotEmpty(message="Choose a password of your choice")
	private String password;
	
	@Column
	@Size(min=10)
	@NotNull (message="Must Enter your phone number")
	private String mobile;
	
	@Column
	@NotEmpty @Email(message="Invalid Email Id")
	private String mail;
	private String address;
	
	
	
	
	public Register() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Register(String id, String name, String password, String mobile, String mail, String address) {
		//super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.mail = mail;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
