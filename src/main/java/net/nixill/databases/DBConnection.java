package net.nixill.databases;

public class DBConnection {
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
    }
  }
}