package com.dao;

import com.connect.ConnectDB;
import com.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
  private Connection connection;
  
	public ProductDao() {
		connection = ConnectDB.getConnect();
	}
  public void addProduct(Product product){
    try{
      PreparedStatement preparedStatement = connection.prepareStatement("insert into products(name,description,Categories_id,quantityPerUnit,unitInStock,unitPrice,disccount,picture) values (?, ?, ?, ? ,? ,? ,? ,?)");
      System.out.println(product.getCategories_id());
      preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getDescription());
        preparedStatement.setInt(3, product.getCategories_id());
        preparedStatement.setInt(4, product.getQuantityPerUnit());
        preparedStatement.setInt(5, product.getUnitInStock());
        preparedStatement.setDouble(6, product.getUnitPrice());
        preparedStatement.setDouble(7, product.getDisccount());            
        preparedStatement.setString(8, product.getPicture());
      preparedStatement.executeUpdate();
    }catch (SQLException e) {			e.printStackTrace();		}
  }  
  public void deleteProduct(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from products where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();	}
	}	
	public void updateProduct(Product product) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update products set name=?, description=?, Categories_id=?, quantityPerUnit=?, unitInStock=?, unitPrice=?, disccount=?, picture=? where id=?");
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getCategories_id());
            preparedStatement.setInt(4, product.getQuantityPerUnit());
            preparedStatement.setInt(5, product.getUnitInStock());
            preparedStatement.setDouble(6, product.getUnitPrice());
            preparedStatement.setDouble(7, product.getDisccount());            
			preparedStatement.setString(8, product.getPicture());
            preparedStatement.setInt(9, product.getId());    
			preparedStatement.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();		}
	}
    
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from products");
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
                product.setCategories_id(rs.getInt("categories_id"));
                product.setQuantityPerUnit(rs.getInt("quantityPerUnit"));
                product.setUnitInStock(rs.getInt("unitInStock"));
                product.setUnitPrice(rs.getDouble("unitPrice"));
                product.setDisccount(rs.getDouble("disccount"));                
                product.setPicture(rs.getString("picture"));
				products.add(product);
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return products;
	}	
	public Product getProductById(int id) {
		Product product = new Product();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from products where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();			
			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
                product.setCategories_id(Integer.parseInt(rs.getString("categories_id")));
                product.setQuantityPerUnit(Integer.parseInt(rs.getString("quantityPerUnit")));
                product.setUnitInStock(Integer.parseInt(rs.getString("unitInStock")));
                product.setUnitPrice(Double.parseDouble(rs.getString("unitPrice")));
                product.setDisccount(Double.parseDouble(rs.getString("disccount")));                
                product.setPicture(rs.getString("picture"));
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return product;
	}
}
