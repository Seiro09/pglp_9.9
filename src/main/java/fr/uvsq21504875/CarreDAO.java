package fr.uvsq21504875;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarreDAO extends DAO<Carre> {

  /**
   * Variable de connexion à la base de données.
   */
  private DBConnection db = new DBConnection();

  /**
   * Méthode de création d'un Carré dans la base de données.
   *
   * @param obj L'objet à créer dans la base de données.
   * @return Le carré crée
   */
  @Override
  public Carre create(final Carre obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "INSERT INTO Carres(nom,HGx,HGy,cote) VALUES (?, ?, ?, ?) "
      );
      ps.setString(1, obj.getNom());
      ps.setInt(2, obj.getHG().getX());
      ps.setInt(3, obj.getHG().getY());
      ps.setInt(4, obj.getCote());
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
   * Méthode de recherche d'un Carré.
   *
   * @param id Le paramètre d'identification de l'objet.
   * @return Le Carré trouvé (ou null).
   */
  @Override
  public Carre find(final String id) {
    db.connect();
    Carre c1 = null;
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Carres WHERE nom = ?"
      );
      ps.setString(1, id);
      ResultSet result = ps.executeQuery();
      if (result.first()) {
        c1 = new Carre(
            result.getString("nom"),
            result.getInt("HGx"),
            result.getInt("HGy"),
            result.getInt("cote")
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
   * Fonction de récupération du contenu de la Table Carre.
   *
   * @return Les Carrés sauvegardés.
   */
  @Override
  public List<Carre> findAll() {
    db.connect();
    List<Carre> lc = new ArrayList<>();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "SELECT * FROM Carres"
      );
      ResultSet result = ps.executeQuery();
      while (result.next()) {
        lc.add(new Carre(
            result.getString("nom"),
            result.getInt("HGx"),
            result.getInt("HGy"),
            result.getInt("cote")
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
  public Carre update(final Carre obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "UPDATE Carre "
              + "SET HGx = ?, HGy = ?, cote = ? WHERE nom = ?"
      );
      ps.setInt(1, obj.getHG().getX());
      ps.setInt(2, obj.getHG().getY());
      ps.setInt(3, obj.getCote());
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
  public void delete(final Carre obj) {
    db.connect();
    try {
      PreparedStatement ps = db.getConn().prepareStatement(
          "DELETE FROM Carres WHERE nom = ?"
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
