package fr.uvsq21504875;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
  /**
   * URL de la base de données.
   */
  private static final String DB_URL = "jdbc:h2:./Database/Dessin";
  /**
   * Classe utilisée pour la base de données.
   */
  private static final String JDBC_DRIVER = "org.h2.Driver";

  /**
   * Username de la base de données.
   */
  private static final String USER = "sa";
  /**
   * Mot de passe de la base de données.
   */
  private static final String PASS = "";

  /**
   * Classe de connexion.
   */
  private Connection conn = null;

  /**
   * Fonction de connexion.
   */
  public void connect() {

    try {
      Class.forName(JDBC_DRIVER).newInstance();
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Fonction de déconnexion.
   */
  public void disconnect() {
    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  /**
   * Fonction de création des tables de la base de données.
   */
  public void createTables() {
    this.connect();
    Statement st;
    try {
      st = this.getConn().createStatement();
      String sql = "CREATE TABLE IF NOT EXISTS "
          + "Cercles"
          + "(nom VARCHAR(255), "
          + "CoordPx INTEGER, "
          + "CoordPy INTEGER, "
          + "rayon DOUBLE, "
          + "PRIMARY KEY (nom))";
      st.executeUpdate(sql);
      sql = "CREATE TABLE IF NOT EXISTS "
          + "Carres"
          + "(nom VARCHAR(255), "
          + "HGx INTEGER, "
          + "HGy INTEGER, "
          + "cote INTEGER, "
          + "PRIMARY KEY (nom))";
      st.executeUpdate(sql);
      sql = "CREATE TABLE IF NOT EXISTS "
          + "Rectangles"
          + "(nom VARCHAR(255), "
          + "HGx INTEGER, "
          + "HGy INTEGER, "
          + "Longueur INTEGER, "
          + "Largeur INTEGER, "
          + "PRIMARY KEY (nom))";
      st.executeUpdate(sql);
      sql = "CREATE TABLE IF NOT EXISTS "
          + "Triangles"
          + "(nom VARCHAR(255), "
          + "P1x INTEGER, "
          + "P1y INTEGER, "
          + "P2x INTEGER, "
          + "P2y INTEGER, "
          + "P3x INTEGER, "
          + "P3y INTEGER, "
          + "PRIMARY KEY (nom))";
      st.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
  }

  /**
   * Fonction de suppression de tables.
   *
   * @param s Le nom de la base de données à supprimer.
   */
  public void dropTables(final String s) {
    this.connect();
    Statement st;
    try {
      st = this.getConn().createStatement();
      String sql = "DROP TABLE "
          + s
          + " IF EXISTS ";
      st.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
  }

  /**
   * Getter de la variable de connexion.
   *
   * @return La variable de connexion.
   */
  public Connection getConn() {
    return conn;
  }
}