package com.model;

import java.util.Date;

public class Customer {
  private int id;
	private String firstName;
	private String lastName;
  private String email;
  private String ubigeo;
	private Date birthDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getUbigeo() {
    return ubigeo;
  }

  public void setUbigeo(String ubigeo) {
    this.ubigeo = ubigeo;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
	
  
  
  

  @Override
	public String toString() {
		return "User [userid=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + birthDate + ", email="
				+ email + "]";
	}
  
}
