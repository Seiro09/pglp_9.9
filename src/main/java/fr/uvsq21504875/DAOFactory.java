package fr.uvsq21504875;

public class DAOFactory {
  public static DAO<Cercle> getCercleDAO(){
    return new CercleDAO();
  }
}
