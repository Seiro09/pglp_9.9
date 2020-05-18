package fr.uvsq21504875;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CarreDAO extends DAO<Carre> {

  DBConnection db = new DBConnection();
  @Override
  public Carre create(Carre obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "INSERT INTO Carres(nom,HGx,HGy,cote) VALUES (?, ?, ?, ?) "
      );
      ps.setString(1,obj.getNom());
      ps.setInt(2,obj.getHG().getX());
      ps.setInt(3,obj.getHG().getY());
      ps.setDouble(4,obj.getCote());
      int result = ps.executeUpdate();
      assert result == 1;
      ps.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    db.disconnect();
    return obj;
  }

  @Override
  public Carre find(String id) {
    db.connect();
    Carre c1 = null;
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "SELECT * FROM Carres WHERE nom = ?"
      );
      ps.setString(1,id);
      ResultSet result = ps.executeQuery();
      if(result.first()){
        c1 = new Carre(
            result.getString("nom"),
            result.getInt("HGx"),
            result.getInt("HGy"),
            result.getInt("cote")
        );
      }
      ps.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    db.disconnect();

    return c1;
  }

  @Override
  public List<Carre> findAll() {
    return null;
  }

  @Override
  public Carre update(Carre obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "UPDATE Carre SET HGx = ?, HGy = ?, cote = ? WHERE nom = ?"
      );
      ps.setInt(1,obj.getHG().getX());
      ps.setInt(2,obj.getHG().getY());
      ps.setInt(3,obj.getCote());
      ps.setString(4,obj.getNom());
      int result = ps.executeUpdate();
      assert result == 1;
      ps.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    db.disconnect();
    return obj;
  }

  @Override
  public void delete(Carre obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "DELETE FROM Carres WHERE nom = ?"
      );
      ps.setString(1,obj.getNom());
      int result = ps.executeUpdate();
      assert result == 1;
      ps.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    db.disconnect();
  }
}
