package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class DAOFactoryTest {
  @Test
  public void getCercleDAO() throws Exception {
    DAO<Cercle> cercleDAO = DAOFactory.getCercleDAO();
    Cercle c1 = new Cercle("c1",0,0,10);
    cercleDAO.create(c1);
    AfficheForme a = new AfficheForme();
    a.affiche(cercleDAO.find("c1").toString());
    a.affiche(cercleDAO.find("c2").toString());
  }
}