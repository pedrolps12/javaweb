package com.dao;

import com.connect.ConnectDB;
import com.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
  private Connection connection;
  
	public CategoryDao() {
		connection = ConnectDB.getConnect();
	}
  public void addCategory(Category category){
    try{
      PreparedStatement preparedStatement = connection.prepareStatement("insert into categories(name,description,picture) values (?, ?, ?)");
      preparedStatement.setString(1, category.getName());
      preparedStatement.setString(2, category.getDescription());
      preparedStatement.setString(3, category.getPicture());
      preparedStatement.executeUpdate();
    }catch (SQLException e) {			e.printStackTrace();		}
  }  
  public void deleteCategory(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from categories where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();	}
	}	
	public void updateCategory(Category category) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update categories set name=?, description=?, picture=? where id=?");
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2, category.getDescription());
			preparedStatement.setString(3, category.getPicture());
            preparedStatement.setInt(4, category.getId());  
			preparedStatement.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();		}
	}
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from categories");
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
                category.setPicture(rs.getString("picture"));
				categories.add(category);
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return categories;
	}	
	public Category getCategoryById(int id) {
		Category category = new Category();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from categories where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();			
			if (rs.next()) {
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				category.setPicture(rs.getString("picture"));
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return category;
	}
}
