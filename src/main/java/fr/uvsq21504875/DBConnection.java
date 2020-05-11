package fr.uvsq21504875;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.*;

public class DBConnection {
  private static final String DB_URL = "jdbc:h2:./Database/Dessin";
  private static final String JDBC_DRIVER = "org.h2.Driver";

  private static final String USER = "sa";
  private static final String PASS = "";

  protected Connection conn = null;

  public void connect() {

    try {
      Class.forName(JDBC_DRIVER).newInstance();
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void disconnect(){
    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  public void createTables(String s){
    this.connect();
    Statement st;
    try {
      st = this.conn.createStatement();
      String sql = "CREATE TABLE IF NOT EXISTS "
          + s + "(nom VARCHAR(255), "
          + "CoordPx INTEGER, "
          + "CoordPy INTEGER, "
          + "rayon DOUBLE, "
          + "PRIMARY KEY (nom))";
      st.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
  }
}