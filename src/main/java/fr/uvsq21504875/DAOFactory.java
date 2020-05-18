package fr.uvsq21504875;

public class DAOFactory {
  public static DAO<Cercle> getCercleDAO(){
    return new CercleDAO();
  }

  public static DAO<Triangle> getTriangleDAO() {
    return new TriangleDAO();
  }

  public static DAO<Rectangle> getRectangleDAO(){
    return new RectangleDAO();
  }

  public static DAO<Carre> getCarreDAO(){
    return new CarreDAO();
  }
}
