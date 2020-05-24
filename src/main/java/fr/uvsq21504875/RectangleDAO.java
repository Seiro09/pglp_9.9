package fr.uvsq21504875;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RectangleDAO extends DAO<Rectangle> {
  /**
   * Variable de connexion à la base de données.
   */
  private DBConnection db = new DBConnection();

  /**
   * Méthode de création d'un Rectangle dans la base de données.
   *
   * @param obj L'objet à créer dans la base de données.
   * @return Le rectangle crée
   */
  @Override
  public Rectangle create(final Rectangle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "INSERT INTO Rectangles(nom, Px, Py, longueur, largeur)"
              + " VALUES (?, ?, ?, ?, ?) "
      );
      ps.setString(1, obj.getNom());
      ps.setInt(2, obj.getHG().getX());
      ps.setInt(3, obj.getHG().getY());
      ps.setInt(4, obj.getLongueur());
      ps.setInt(5, obj.getLargeur());
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
   * Méthode de recherche d'un Rectangle.
   *
   * @param id Le paramètre d'identification de l'objet.
   * @return Le Rectangle trouvé (ou null).
   */
  @Override
  public Rectangle find(final String id) {
    db.connect();
    Rectangle r1 = null;
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Rectangles WHERE nom = ?"
      );
      ps.setString(1, id);
      ResultSet result = ps.executeQuery();
      if (result.first()) {
        r1 = new Rectangle(
            result.getString("nom"),
            result.getInt("Px"),
            result.getInt("Py"),
            result.getInt("longueur"),
            result.getInt("largeur")
        );
      }
      ps.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    db.disconnect();
    return r1;
  }

  /**
   * Fonction de récupération du contenu de la Table Rectangle.
   *
   * @return Les rectangles sauvegardés.
   */
  @Override
  public List<Rectangle> findAll() {
    db.connect();
    List<Rectangle> lc = new ArrayList<>();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Rectangles"
      );
      ResultSet result = ps.executeQuery();
      while (result.next()) {
        lc.add(new Rectangle(
            result.getString("nom"),
            result.getInt("Px"),
            result.getInt("Py"),
            result.getInt("longueur"),
            result.getInt("largeur")
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
  public Rectangle update(final Rectangle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "UPDATE Rectangles SET Px = ?, Py = ? WHERE nom = ?"
      );
      ps.setInt(1, obj.getHG().getX());
      ps.setInt(2, obj.getHG().getY());
      ps.setString(3, obj.getNom());
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
  public void delete(final Rectangle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "DELETE FROM Rectangles WHERE nom = ?"
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
