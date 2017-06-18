package com.dao;

import com.connect.ConnectDB;
import com.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
  private Connection connection;
  
	public CustomerDao() {
		connection = ConnectDB.getConnect();
	}
  public void addCustomer(Customer customer){
    try{
      PreparedStatement preparedStatement = connection
              .prepareStatement("insert into customers(firstName,lastName,birthDate,email,ubigeo) values (?, ?, ?, ? ,?)");
      preparedStatement.setString(1, customer.getFirstName());
      preparedStatement.setString(2, customer.getLastName());
      preparedStatement.setDate(3, new java.sql.Date(customer.getBirthDate().getTime()));
      preparedStatement.setString(4, customer.getEmail());
      preparedStatement.setString(5, customer.getUbigeo());
      preparedStatement.executeUpdate();
    }catch (SQLException e) {			e.printStackTrace();		}
  }  
  public void deleteCustomer(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from customers where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();	}
	}	
	public void updateCustomer(Customer customer) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update customers set firstName=?, lastName=?, birthDate=?, email=?, ubigeo=? where id=?");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(customer.getBirthDate().getTime()));
			preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getUbigeo());
			preparedStatement.setInt(6, customer.getId());      
			preparedStatement.executeUpdate();
		} catch (SQLException e) {			e.printStackTrace();		}
	}
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from customers");
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setBirthDate(rs.getDate("birthDate"));
				customer.setEmail(rs.getString("email"));
                customer.setUbigeo(rs.getString("ubigeo"));
				customers.add(customer);
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return customers;
	}	
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customers where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();			
			if (rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setBirthDate(rs.getDate("birthDate"));
				customer.setEmail(rs.getString("email"));
        customer.setUbigeo(rs.getString("ubigeo"));
			}
		} catch (SQLException e) {			e.printStackTrace();		}

		return customer;
	}
}
