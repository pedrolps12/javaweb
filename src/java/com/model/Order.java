package com.model;
import java.util.Date;

public class Order {
  private int id;
  private int Customer_id;
  private Date dateOrderPlaced;
  private String detail;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCustomer_id() {
    return Customer_id;
  }

  public void setCustomer_id(int Customer_id) {
    this.Customer_id = Customer_id;
  }

  public Date getDateOrderPlaced() {
    return dateOrderPlaced;
  }

  public void setDateOrderPlaced(Date dateOrderPlaced) {
    this.dateOrderPlaced = dateOrderPlaced;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
  
  @Override
	public String toString() {
		return "Order [id=" + id + ", customerid=" + Customer_id	+ ", dateorder=" + dateOrderPlaced + ", detail=" + detail + "]";
	}
}
