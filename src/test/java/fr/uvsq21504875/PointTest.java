package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
  @Test
  public void affichagePoint() throws Exception {
  AfficheForme a = new AfficheForme();
  Point p = new Point("Point1",10,20);
  a.affiche(p.toString());
  }

}