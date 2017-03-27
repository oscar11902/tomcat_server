package fcu.android.backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fcu.android.backend.data.*;

public class DatabaseManager {

  private static DatabaseManager DB_MANAGER = new DatabaseManager();

  public static DatabaseManager getInstance() {
    return DB_MANAGER;
  }

  private IDatabase database = DatabaseFactory.getDatabase(DatabaseFactory.DatabaseType.MySql);

  private DatabaseManager() {

  }

  public boolean addUser(User user) {
    Connection conn = database.getConnection();
    PreparedStatement preStmt = null;
    Statement stmt = null;
    String sql = "INSERT INTO USER(userAccount ,userName ,password ,email ,phone)  VALUES(? ,? ,? ,? ,?)";
    String query = "SELECT * FROM USER";
    try {
      preStmt = conn.prepareStatement(sql);
      preStmt.setString(1, user.getUseraccount());
      preStmt.setString(2, user.getUserName());
      preStmt.setString(3, user.getPassword());
      preStmt.setString(4, user.getEmail());
      preStmt.setString(5, user.getPhone());
      preStmt.executeUpdate();
      preStmt.close();

      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      System.out.println("List All Users");
      while (rs.next()) {
        System.out.println("User Account: " + rs.getString("userAccount") + ", User Name: " + rs.getString("userName") + ", Email: " + rs.getString("email") + ", Phone: " + rs.getString("phone"));
      }
      stmt.close();
      
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean loginUser(String account, String password){
	  Connection conn = database.getConnection();
	  PreparedStatement stmt = null;
	  String query = "SELECT * FROM USER WHERE userAccount = ? and password = ?";
	  try {
	      stmt = conn.prepareStatement(query);
	      stmt.setString(1, account);
	      stmt.setString(2, password);
	      ResultSet rs = stmt.executeQuery();
	      boolean login = rs.first();
	      stmt.close();
	      
	      return login;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return false;
  }

  public boolean validateUser(String email, String password) {
    Connection conn = database.getConnection();
    PreparedStatement stmt = null;
    String query = "SELECT * FROM USER WHERE email = ? and password = ?";
    try {
      stmt = conn.prepareStatement(query);
      stmt.setString(1, email);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      boolean valid = rs.first();
      stmt.close();
      
      return valid;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public User getUser(String email) {
    Connection conn = database.getConnection();
    PreparedStatement stmt = null;
    String query = "select * from USER where email = ?";
    try {
      stmt = conn.prepareStatement(query);
      stmt.setString(1, email);
      ResultSet rs = stmt.executeQuery();
      User user = new User();
      if (rs.next()) {
    	user.setUserAccount(rs.getString("userAccount"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
      }
      stmt.close();
      
      return user;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return new User();
  }

  public List<User> listAllUsers() {
    List<User> lsUsers = new ArrayList<User>();

    Connection conn = database.getConnection();
    String sql = "SELECT * FROM USER";
    Statement stmt = null;

    try {
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
    	String Account = rs.getString("userAccount");
        String name = rs.getString("userName");
        String password = rs.getString("password");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        

        User user = new User();
        user.setUserAccount(Account);
        user.setUserName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        lsUsers.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lsUsers;
  }
  
  public boolean addOrganizer(organizer organizer) {
	    Connection conn = database.getConnection();
	    PreparedStatement preStmt = null;
	    Statement stmt = null;
	    String sql = "INSERT INTO ORGANIZER(organizerAccount ,organizerName ,password ,email ,phone ,principal)  VALUES(? ,? ,? ,? ,? ,?)";
	    String query = "SELECT * FROM ORGANIZER";
	    try {
	      preStmt = conn.prepareStatement(sql);
	      preStmt.setString(1, organizer.getOranizerAccount());
	      preStmt.setString(2, organizer.getPassword());
	      preStmt.setString(3, organizer.getOrganizerName());
	      preStmt.setString(4, organizer.getEmail());
	      preStmt.setString(5, organizer.getPhone());
	      preStmt.setString(6, organizer.getPrincipal());
	      preStmt.executeUpdate();
	      preStmt.close();

	      stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(query);
	      System.out.println("List All Organizers");
	      while (rs.next()) {
	        System.out.println("Organizer Account: " + rs.getString("organizerAccount") + ", Organizer Name: " + rs.getString("organizerName") + ", Email: " + rs.getString("email") + ", Phone: " + rs.getString("phone") + ", Principal: " + rs.getString("principal"));
	      }
	      stmt.close();
	      
	      return true;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return false;
	  }

  public boolean loginOrganizer(String account, String password){
	  Connection conn = database.getConnection();
	  PreparedStatement stmt = null;
	  String query = "SELECT * FROM ORGANIZER WHERE organizerAccount = ? and password = ?";
	  try {
	      stmt = conn.prepareStatement(query);
	      stmt.setString(1, account);
	      stmt.setString(2, password);
	      ResultSet rs = stmt.executeQuery();
	      boolean login = rs.first();
	      stmt.close();
	      
	      return login;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return false;
  }
	  public boolean validateOrganizer(String email, String password) {
	    Connection conn = database.getConnection();
	    PreparedStatement stmt = null;
	    String query = "SELECT * FROM Organizer WHERE email = ? and password = ?";
	    try {
	      stmt = conn.prepareStatement(query);
	      stmt.setString(1, email);
	      stmt.setString(2, password);
	      ResultSet rs = stmt.executeQuery();
	      boolean valid = rs.first();
	      stmt.close();
	      
	      return valid;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return false;
	  }

	  public organizer getOrganizer(String email) {
	    Connection conn = database.getConnection();
	    PreparedStatement stmt = null;
	    String query = "select * from ORGANIZER where email = ?";
	    try {
	      stmt = conn.prepareStatement(query);
	      stmt.setString(1, email);
	      ResultSet rs = stmt.executeQuery();
	      organizer organizer = new organizer();
	      if (rs.next()) {
	    	organizer.setOrganizerAccount(rs.getString("organizerAccount"));
	        organizer.setOrganizerName(rs.getString("organizerName"));
	        organizer.setPassword(rs.getString("password"));
	        organizer.setEmail(rs.getString("email"));
	        organizer.setPhone(rs.getString("phone"));
	        organizer.setPrincipal(rs.getString("principal"));
	      }
	      stmt.close();
	      
	      return organizer;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        conn.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return new organizer();
	  }

	  public List<organizer> listAllorganizer() {
	    List<organizer> lsOrganizers = new ArrayList<organizer>();

	    Connection conn = database.getConnection();
	    String sql = "SELECT * FROM ORGANIZER";
	    Statement stmt = null;

	    try {
	      stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	String account = rs.getString("organizerAccount");
	        String name = rs.getString("organizerName");
	        String password = rs.getString("password");
	        String email = rs.getString("email");
	        String phone = rs.getString("phone");
	        String principal = rs.getString("principal");

	        organizer organizer = new organizer();
	        organizer.setOrganizerAccount(account);
	        organizer.setOrganizerName(name);
	        organizer.setPassword(password);
	        organizer.setEmail(email);
	        organizer.setPhone(phone);
	        organizer.setPrincipal(principal);
	        lsOrganizers.add(organizer);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return lsOrganizers;
	  }
	  
	  public boolean addiBeacon(iBeacon iBeacon) {
		    Connection conn = database.getConnection();
		    PreparedStatement preStmt = null;
		    Statement stmt = null;
		    String sql = "INSERT INTO IBEACON(Uuid ,Major ,Minor)  VALUES(? ,? ,?)";
		    String query = "SELECT * FROM IBEACON";
		    try {
		      preStmt = conn.prepareStatement(sql);
		      preStmt.setString(1, iBeacon.getUuid());
		      preStmt.setString(2, iBeacon.getMajor());
		      preStmt.setString(3, iBeacon.getMinor());
		      preStmt.executeUpdate();
		      preStmt.close();

		      stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery(query);
		      System.out.println("List All iBeacons");
		      while (rs.next()) {
		        System.out.println("uuid: " + rs.getString("uuid") + ", major: " + rs.getString("major") + ", minor: " + rs.getString("minor"));
		      }
		      stmt.close();
		      
		      return true;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        conn.close();
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		    return false;
		  }
	  
	  public boolean cheakiniBeacon(String uuid, String major, String minor){
		  Connection conn = database.getConnection();
		  PreparedStatement stmt = null;
		  String query = "SELECT * FROM IBEACON";
		  try {
		      stmt = conn.prepareStatement(query);
		      stmt.setString(1, uuid);
		      stmt.setString(2, major);
		      stmt.setString(3, minor);
		      ResultSet rs = stmt.executeQuery();
		      boolean cheakin = rs.first();
		      stmt.close();
		      
		      return cheakin;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        conn.close();
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		    return false;
	  }
	  
	  public List<iBeacon> listAlliBeacons() {
		    List<iBeacon> lsiBeacons = new ArrayList<iBeacon>();

		    Connection conn = database.getConnection();
		    String sql = "SELECT * FROM IBEACON";
		    Statement stmt = null;

		    try {
		      stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery(sql);
		      while (rs.next()) {
		    	String uuid = rs.getString("uuid");
		        String major = rs.getString("major");
		        String minor = rs.getString("minor");
		        
		        iBeacon iBeacon = new iBeacon();
		        iBeacon.setUuid(uuid);
		        iBeacon.setMajor(major);
		        iBeacon.setMinor(minor);
		        lsiBeacons.add(iBeacon);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return lsiBeacons;
		  }
		  

}
