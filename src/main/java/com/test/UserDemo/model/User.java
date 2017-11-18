package com.test.UserDemo.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String id;
	private String fName;
	private String lName;
	private String email;
	private Number pinCode;
	private Date birthDate;
	private Boolean isActive = true;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String fName, String lName, String email, Number pinCode, Date birthDate, Boolean isActive) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pinCode = pinCode;
		this.birthDate = birthDate;
		this.isActive = isActive;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Number getPinCode() {
		return pinCode;
	}
	public void setPinCode(Number pinCode) {
		this.pinCode = pinCode;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pinCode=" + pinCode
				+ ", birthDate=" + birthDate + ", isActive=" + isActive + "]";
	}
	
}
