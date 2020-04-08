package com.teamtreehouse.sample;

import java.util.Date;

public class Person {
	public String firstName;
	public String lastName;
	public Long ssn;
	public Date dob;
	public boolean codeInJava;

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
	public Long getSsn() {
		return ssn;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean canCodeInJava() {
		return codeInJava;
	}
	public void setCodeInJava(boolean codeInJava) {
		this.codeInJava = codeInJava;
	}
}