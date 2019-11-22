package net.nixill.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
  Connection conn;
  Statement stmt;
  
  public DBConnection(String file) {
    try {
      conn = DriverManager.getConnection("jdbc:sqlite:" + file);
      stmt = conn.createStatement();
    } catch (SQLException ex) {
      throw new DBException(ex);
    }
  }
  
  public SQLResult query(String query) {
    try {
      return new SQLResult(stmt.executeQuery(query));
    } catch (SQLException ex) {
      throw new DBException(ex);
    }
  }
}
