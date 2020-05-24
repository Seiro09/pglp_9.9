package fr.uvsq21504875;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TriangleDAO extends DAO<Triangle> {
  /**
   * Variable de connexion à la base de données.
   */
  private DBConnection db = new DBConnection();

  /**
   * Méthode de création d'un Triangle dans la base de données.
   *
   * @param obj L'objet à créer dans la base de données.
   * @return Le triangle crée
   */
  @Override
  public Triangle create(final Triangle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "INSERT INTO Cercles(nom, p1x, p1y, p2x, p2y, p3x, p3y) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?) "
      );
      ps.setString(1, obj.getNom());
      ps.setInt(2, obj.getP1().getX());
      ps.setInt(3, obj.getP1().getY());
      ps.setInt(4, obj.getP2().getX());
      ps.setInt(5, obj.getP2().getY());
      ps.setInt(6, obj.getP3().getX());
      ps.setInt(7, obj.getP3().getY());
      int result = ps.executeUpdate();
      assert result == 1;
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    db.disconnect();
    return obj;
  }

  /**
   * Méthode de recherche d'un Triangle.
   *
   * @param id Le paramètre d'identification de l'objet.
   * @return Le Triangle trouvé (ou null).
   */
  @Override
  public Triangle find(final String id) {
    db.connect();
    Triangle t1 = null;
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Triangles WHERE nom = ?"
      );
      ps.setString(1,id);
      ResultSet result = ps.executeQuery();
      if (result.first()) {
        t1 = new Triangle(
            result.getString("nom"),
            result.getInt("p1x"),
            result.getInt("p1y"),
            result.getInt("p2x"),
            result.getInt("p2y"),
            result.getInt("p3x"),
            result.getInt("p3y")
        );
      }
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    db.disconnect();
    return t1;
  }

  /**
   * Fonction de récupération du contenu de la Table Triangle.
   *
   * @return Les triangles sauvegardés.
   */
  @Override
  public List<Triangle> findAll() {
    db.connect();
    List<Triangle> lc = new ArrayList<>();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Triangles"
      );
      ResultSet result = ps.executeQuery();
      while (result.next()) {
        lc.add(new Triangle(
            result.getString("nom"),
            result.getInt("p1x"),
            result.getInt("p1y"),
            result.getInt("p2x"),
            result.getInt("p2y"),
            result.getInt("p3x"),
            result.getInt("p3y")
        ));
      }
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    db.disconnect();
    return lc;
  }

  /**
   * Méthode de mise à jour d'un objet de la Table.
   *
   * @param obj L"objet à mettre à jour.
   * @return L'objet modifié.
   */
  @Override
  public Triangle update(final Triangle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "UPDATE Triangles SET"
              + " p1x = ?, p1y= ?, p2x= ?, p2y = ?, p3x= ?, p3y = ? "
              + "WHERE nom = ?"
      );
      ps.setInt(1, obj.getP1().getX());
      ps.setInt(2, obj.getP1().getY());
      ps.setInt(3, obj.getP2().getX());
      ps.setInt(4, obj.getP2().getY());
      ps.setInt(5, obj.getP3().getX());
      ps.setInt(6, obj.getP3().getY());
      ps.setString(7, obj.getNom());
      int result = ps.executeUpdate();
      assert result == 1;
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    db.disconnect();
    return obj;
  }

  /**
   * Méthode de suppression de la Table.
   *
   * @param obj L"objet à supprimer.
   */
  @Override
  public void delete(final Triangle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "DELETE FROM Triangles WHERE nom = ?"
      );
      ps.setString(1, obj.getNom());
      int result = ps.executeUpdate();
      assert result == 1;
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    db.disconnect();
  }
}
