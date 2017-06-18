package com.model;
public class Product {  
  private int id;
  private String name;
  private String description;
  private int quantityPerUnit;
  private double unitPrice;
  private double unitWeight;
  private int unitInStock;
  private int unitInOrder;
  private double disccount;
  private String picture;
  private int Categories_id;

    public int getCategories_id() {
        return Categories_id;
    }

    public void setCategories_id(int Categories_id) {
        this.Categories_id = Categories_id;
    }
  
  

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getQuantityPerUnit() {
    return quantityPerUnit;
  }

  public void setQuantityPerUnit(int quantityPerUnit) {
    this.quantityPerUnit = quantityPerUnit;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public double getUnitWeight() {
    return unitWeight;
  }

  public void setUnitWeight(double unitWeight) {
    this.unitWeight = unitWeight;
  }

  public int getUnitInStock() {
    return unitInStock;
  }

  public void setUnitInStock(int unitInStock) {
    this.unitInStock = unitInStock;
  }

  public int getUnitInOrder() {
    return unitInOrder;
  }

  public void setUnitInOrder(int unitInOrder) {
    this.unitInOrder = unitInOrder;
  }

  public double getDisccount() {
    return disccount;
  }

  public void setDisccount(double disccount) {
    this.disccount = disccount;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }
  
  @Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name	+ ", description=" + description + ", picture=" + picture + "]";
	}
  
}
