package com.model;
public class Supplier {
  
  private int id;
  private String contactFName;
  private String contactLName;
  private String contactTitle;
  private String companyName;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContactFName() {
    return contactFName;
  }

  public void setContactFName(String contactFName) {
    this.contactFName = contactFName;
  }

  public String getContactLName() {
    return contactLName;
  }

  public void setContactLName(String contactLName) {
    this.contactLName = contactLName;
  }

  public String getContactTitle() {
    return contactTitle;
  }

  public void setContactTitle(String contactTitle) {
    this.contactTitle = contactTitle;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
  
   @Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + contactFName	+ ", title=" + contactTitle + ", companyName=" + companyName + "]";
	}
  
  
}
