package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeFormeTest {
  @Test
  public void add() throws Exception {
    Cercle c1 = new Cercle("c1",0,0,15);
    Cercle c2 = new Cercle("c2",0,10,16);
    CompositeForme cf = new CompositeForme();
    cf.add(c1);
    cf.add(c2);
    System.out.println(cf.children.size());
  }

  @Test
  public void move() throws Exception {

  }

  @Test
  public void print() throws Exception {
  }

}