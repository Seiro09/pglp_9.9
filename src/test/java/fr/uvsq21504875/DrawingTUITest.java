package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class DrawingTUITest {
  @Test
  public void nextCommande() throws Exception {
    DrawingTUI d = new DrawingTUI();
    Commande c = d.nextCommande("Cercle(c4,(50,50),64)");
    //assertNotEquals(c,null);
    assertTrue(c instanceof CommandeCercle);
  }

  @Test
  public void nextCommande2() throws Exception {
    DrawingTUI d = new DrawingTUI();
    Commande c = d.nextCommande("Rectangle(c4,(50,50),64)");
    assertEquals(c,null);
  }

}