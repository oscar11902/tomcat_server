package fcu.android.backend.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Database implements IDatabase {
  
  private static final String DB_DRIVER = "org.h2.Driver";
  private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
  private static final String DB_USER = "";
  private static final String DB_PASSWORD = "";
  
  H2Database() {
    super();
    createUserTable();
    createOrganizerTable();
  }

  @Override
  public Connection getConnection() {
    Connection dbConnection = null;
    try {
        Class.forName(DB_DRIVER);
    } catch (ClassNotFoundException e) {
        System.out.println(e.getMessage());
    }
    try {
        dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return dbConnection;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return dbConnection;
  }

  private void createUserTable() {
    Connection conn = getConnection();
    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      stmt.execute("CREATE TABLE USER(userAccount varchar(255), userName varchar(255), password varchar(255), email varchar(255), phone varchar(255) primary key)");   
      stmt.close();
      conn.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  private void createOrganizerTable() {
	    Connection conn = getConnection();
	    Statement stmt = null;
	    try {
	      stmt = conn.createStatement();
	      stmt.execute("CREATE TABLE ORGANIZER(organizerAccount varchar(255), organizerName varchar(255), password varchar(255), email varchar(255), phone varchar(255), principal varchar(255) primary key)");   
	      stmt.close();
	      conn.commit();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    finally {
	      try {
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	  }
  
}
