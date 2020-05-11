package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class AfficheFormeTest {
  @Test
  public void affiche() throws Exception {
  AfficheForme a = new AfficheForme();
  a.affiche("Ceci est un test");
  }



}