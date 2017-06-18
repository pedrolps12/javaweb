package com.connect;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;
import com.mysql.jdbc.Connection;
public class ConnectDB {
  public static Connection getConnect()
  {
    Connection connection = null;
    try{
      Properties p = new Properties();
      InputStream inputStream = ConnectDB.class.getClassLoader().getResourceAsStream("com/prop/db.properties");
      p.load(inputStream);
      String driver = p.getProperty("dvr"),url = p.getProperty("url"),user = p.getProperty("user"),pwd = p.getProperty("pwd");
      Class.forName(driver);
      connection=(Connection)DriverManager.getConnection(url, user, pwd);
    }
    catch(ClassNotFoundException ex){ ex.printStackTrace(); }
    catch(Exception ex){              ex.printStackTrace(); }
    finally{                          return connection;    }
  }
}