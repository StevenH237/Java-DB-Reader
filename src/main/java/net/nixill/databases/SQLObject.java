package net.nixill.databases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

public class SQLObject {
  private HashMap<String, Object> attributes;
  
  SQLObject(ResultSet res) throws SQLException {
    attributes = new HashMap<>();
    
    ResultSetMetaData rsmd = res.getMetaData();
    int columnCount = rsmd.getColumnCount();
    
    // The column count starts from 1
    for (int i = 1; i <= columnCount; i++) {
      String name = rsmd.getColumnLabel(i);
      Object obj = res.getObject(name);
      
      attributes.put(name, obj);
      // Do stuff with name
    }
  }
}
