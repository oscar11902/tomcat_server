package fcu.android.backend.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDatabase implements IDatabase {
  private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_CONNECTION = "jdbc:mysql://140.134.26.71:2560/beacon?useUnicode=true&characterEncoding=utf8";
  private static final String DB_USER = "server_user";
  private static final String DB_PASSWORD = "iecs1995";
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

}
