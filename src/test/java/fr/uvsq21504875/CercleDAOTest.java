package fr.uvsq21504875;

import org.junit.Test;

import java.security.cert.CertPathChecker;

import static org.junit.Assert.*;

public class CercleDAOTest {
  @Test
  public void create() throws Exception {
    Cercle c2 = new Cercle("c2",200,200,10);
    DAO<Cercle> D = new CercleDAO();
    assertSame(c2,D.create(c2));
  }

  @Test
  public void find() throws Exception {
  Cercle c1;
  DAO<Cercle> D = new CercleDAO();
  c1 = D.find("c1");
  AfficheForme a = new AfficheForme();
  a.affiche(c1.toString());
  }

  @Test
  public void update() throws Exception {
    Cercle c1 = new Cercle("c1",100,100,10);
    c1.move(15,15);
    DAO<Cercle> D = new CercleDAO();
    assertSame(c1,D.update(c1));
    AfficheForme a = new AfficheForme();
    a.affiche(c1.toString());
  }

  @Test
  public void delete() throws Exception {
    Cercle c1;
    AfficheForme a = new AfficheForme();
    DAO<Cercle> D = new CercleDAO();

    c1= D.find("c1");
    a.affiche(c1.toString());
    D.delete(c1);
    assertEquals(D.find("c1"),null);
  }




}