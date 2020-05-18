package fr.uvsq21504875;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RectangleDAO extends DAO<Rectangle> {
  DBConnection db=new DBConnection();
  @Override
  public Rectangle create(Rectangle obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "INSERT INTO Rectangles(nom, Px, Py, longueur, largeur) VALUES (?, ?, ?, ?, ?) "
      );
      ps.setString(1,obj.getNom());
      ps.setInt(2,obj.getHG().getX());
      ps.setInt(3,obj.getHG().getY());
      ps.setInt(4,obj.getLongueur());
      ps.setInt(5,obj.getLargeur());
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
  public Rectangle find(String id) {
    db.connect();
    Rectangle r1 = null;
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "SELECT * FROM Rectangles WHERE nom = ?"
      );
      ps.setString(1,id);
      ResultSet result = ps.executeQuery();
      if(result.first()){
        r1 = new Rectangle(
            result.getString("nom"),
            result.getInt("Px"),
            result.getInt("Py"),
            result.getInt("longueur"),
            result.getInt("largeur")
        );
      }
      ps.close();
    }catch(Exception e){
      e.printStackTrace();
    }
    db.disconnect();

    return r1;
  }

  @Override
  public List<Rectangle> findAll() {
    db.connect();
    List<Rectangle> lc = new ArrayList<>();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "SELECT * FROM Rectangles"
      );
      ResultSet result = ps.executeQuery();
      while(result.next()){
        lc.add(new Rectangle(
            result.getString("nom"),
            result.getInt("Px"),
            result.getInt("Py"),
            result.getInt("longueur"),
            result.getInt("largeur")
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
  public Rectangle update(Rectangle obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "UPDATE Rectangles SET Px = ?, Py = ? WHERE nom = ?"
      );
      ps.setInt(1,obj.getHG().getX());
      ps.setInt(2,obj.getHG().getY());
      ps.setString(3,obj.getNom());
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
  public void delete(Rectangle obj) {
    db.connect();
    try{
      PreparedStatement ps = db.conn.prepareStatement(
          "DELETE FROM Rectangles WHERE nom = ?"
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
