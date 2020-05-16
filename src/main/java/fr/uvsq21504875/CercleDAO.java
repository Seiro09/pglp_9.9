package fr.uvsq21504875;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CercleDAO extends DAO<Cercle>{
  DBConnection db = new DBConnection();

  @Override
  public Cercle create(Cercle obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "INSERT INTO Cercles(nom,CoordPx,CoordPy,rayon) VALUES (?, ?, ?, ?) "
      );
      ps.setString(1,obj.getNom());
      ps.setInt(2,obj.getCentre().getX());
      ps.setInt(3,obj.getCentre().getY());
      ps.setDouble(4,obj.getRayon());
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
  public Cercle find(String id) {
    db.connect();
    Cercle c1 = null;
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "SELECT * FROM Cercles WHERE nom = ?"
      );
      ps.setString(1,id);
      ResultSet result = ps.executeQuery();
      if(result.first()){
        c1 = new Cercle(
            result.getString("nom"),
            result.getInt("CoordPx"),
            result.getInt("CoordPy"),
            result.getDouble("rayon")
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
  public List<Cercle> findAll() {
    db.connect();
    List<Cercle> lc = new ArrayList<>();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "SELECT * FROM Cercles"
      );
      ResultSet result = ps.executeQuery();
      while(result.next()){
        lc.add(new Cercle(
            result.getString("nom"),
            result.getInt("CoordPx"),
            result.getInt("CoordPy"),
            result.getDouble("rayon")
        ));
      }
      ps.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    db.disconnect();
    return lc;
  }

  @Override
  public Cercle update(Cercle obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "UPDATE Cercles SET CoordPx = ?, CoordPy = ?, rayon = ? WHERE nom = ?"
      );
      ps.setInt(1,obj.getCentre().getX());
      ps.setInt(2,obj.getCentre().getY());
      ps.setDouble(3,obj.getRayon());
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
  public void delete(Cercle obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "DELETE FROM Cercles WHERE nom = ?"
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
