package com.dao;

import com.connect.ConnectDB;
import com.model.Ubigeo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UbigeoDao {
  private Connection connection;
  
	public UbigeoDao() {
		connection = ConnectDB.getConnect();
	}	
	public List<Ubigeo> getAllDepartamentos() {
		List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ubigeo group by departamento");
			while (rs.next()) {
				Ubigeo ubigeo = new Ubigeo();
				ubigeo.setIdubigeo(rs.getString("idubigeo"));
				ubigeo.setDepartamento(rs.getString("departamento"));
				ubigeo.setProvincia(rs.getString("provincia"));
				ubigeo.setDistrito(rs.getString("distrito"));
				ubigeos.add(ubigeo);
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return ubigeos;
	}	
	public List<Ubigeo> getProvincias(String id) {
    List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from ubigeo where substring(idubigeo,1,2)=? and provincia!='' GROUP by provincia");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();			
			while (rs.next()) {
                Ubigeo ubigeo = new Ubigeo();
				ubigeo.setIdubigeo(rs.getString("idubigeo"));
				ubigeo.setDepartamento(rs.getString("departamento"));
				ubigeo.setProvincia(rs.getString("provincia"));
				ubigeo.setDistrito(rs.getString("distrito"));   
                ubigeos.add(ubigeo);
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return ubigeos;
	}
  public List<Ubigeo> getDistritos(String id) {
        List<Ubigeo> ubigeos = new ArrayList<Ubigeo>();		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from ubigeo where substring(idubigeo,1,4)=? and distrito!='' GROUP by distrito");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();			
			while (rs.next()) {
                Ubigeo ubigeo = new Ubigeo();
				ubigeo.setIdubigeo(rs.getString("idubigeo"));
				ubigeo.setDepartamento(rs.getString("departamento"));
				ubigeo.setProvincia(rs.getString("provincia"));
				ubigeo.setDistrito(rs.getString("distrito"));   
                ubigeos.add(ubigeo);
			}
		} catch (SQLException e) {			e.printStackTrace();		}
		return ubigeos;
	}
}
