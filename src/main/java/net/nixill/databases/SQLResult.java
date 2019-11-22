package net.nixill.databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLResult {
  private ArrayList<SQLObject> objects;
  
  SQLResult(ResultSet res) throws SQLException {
    objects = new ArrayList<>();
    while (res.next()) {
      objects.add(new SQLObject(res));
    }
  }
}
