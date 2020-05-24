package fr.uvsq21504875;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CercleDAO extends DAO<Cercle> {

  /**
   * Variable de connexion à la base de données.
   */
  private DBConnection db = new DBConnection();

  /**
   * Méthode de création d'un Cercle dans la base de données.
   *
   * @param obj L'objet à créer dans la base de données.
   * @return Le cercle crée
   */
  @Override
  public Cercle create(final Cercle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "INSERT INTO Cercles(nom, CoordPx, CoordPy, rayon)"
              + " VALUES (?, ?, ?, ?) "
      );
      ps.setString(1, obj.getNom());
      ps.setInt(2, obj.getCentre().getX());
      ps.setInt(3, obj.getCentre().getY());
      ps.setDouble(4, obj.getRayon());
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
   * Méthode de recherche d'un Cercle.
   *
   * @param id Le paramètre d'identification de l'objet.
   * @return Le Cercle trouvé (ou null).
   */
  @Override
  public Cercle find(final String id) {
    db.connect();
    Cercle c1 = null;
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Cercles WHERE nom = ?"
      );
      ps.setString(1, id);
      ResultSet result = ps.executeQuery();
      if (result.first()) {
        c1 = new Cercle(
            result.getString("nom"),
            result.getInt("CoordPx"),
            result.getInt("CoordPy"),
            result.getDouble("rayon")
        );
      }
      ps.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    db.disconnect();
    return c1;
  }

  /**
   * Fonction de récupération du contenu de la Table Cercle.
   *
   * @return Les cercles sauvegardés.
   */
  @Override
  public List<Cercle> findAll() {
    db.connect();
    List<Cercle> lc = new ArrayList<>();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Cercles"
      );
      ResultSet result = ps.executeQuery();
      while (result.next()) {
        lc.add(new Cercle(
            result.getString("nom"),
            result.getInt("CoordPx"),
            result.getInt("CoordPy"),
            result.getDouble("rayon")
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
  public Cercle update(final Cercle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "UPDATE Cercles SET CoordPx = ?, CoordPy = ?, rayon = ?"
              + " WHERE nom = ?"
      );
      ps.setInt(1, obj.getCentre().getX());
      ps.setInt(2, obj.getCentre().getY());
      ps.setDouble(3, obj.getRayon());
      ps.setString(4, obj.getNom());
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
  public void delete(final Cercle obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "DELETE FROM Cercles WHERE nom = ?"
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
