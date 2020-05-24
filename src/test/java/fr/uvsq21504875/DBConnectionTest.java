package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class DBConnectionTest {
  @Test
  public void createTables() throws Exception {
    DBConnection db = new DBConnection();
    db.dropTables("Cercles");
    db.dropTables("Carres ");
    db.dropTables("Rectangles");
    db.dropTables("Triangles");
    db.createTables();
  }

  @Test
  public void connect() throws Exception {
    DBConnection db = new DBConnection();
    db.connect();
  }

  @Test
  public void disconnect() throws Exception {
    DBConnection db = new DBConnection();
    db.connect();
    db.disconnect();
  }


}