package fr.uvsq21504875;

public final class DAOFactory {
  /**
   * Constructeur privé de la fabrique.
   */
  private DAOFactory() {

  }

  /**
   * Constructeur d'un cercle dans la base de données.
   *
   * @return Le constructeur du cercle de la base de données
   */
  public static DAO<Cercle> getCercleDAO() {
    return new CercleDAO();
  }
  /**
   * Constructeur d'un triangle dans la base de données.
   *
   * @return Le constructeur du triangle de la base de données
   */
  public static DAO<Triangle> getTriangleDAO() {
    return new TriangleDAO();
  }
  /**
   * Constructeur d'un rectangle dans la base de données.
   *
   * @return Le constructeur du rectangle de la base de données
   */
  public static DAO<Rectangle> getRectangleDAO() {
    return new RectangleDAO();
  }
  /**
   * Constructeur d'un carré dans la base de données.
   *
   * @return Le constructeur du carré de la base de données
   */
  public static DAO<Carre> getCarreDAO() {
    return new CarreDAO();
  }
}
